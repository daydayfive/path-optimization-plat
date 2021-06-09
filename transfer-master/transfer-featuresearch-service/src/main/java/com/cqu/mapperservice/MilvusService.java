package com.cqu.mapperservice;

import com.google.gson.JsonObject;
import io.milvus.client.*;
import org.springframework.stereotype.Service;

import java.util.List;


//milvus 的一些操作，将向量等存储到磁盘中，查询操作
@Service
public class MilvusService {
    private MilvusClient client = new MilvusGrpcClient();
    private String collectionName;

    public MilvusClient getClient() {
        return client;
    }

    public void setClient(MilvusClient client) {
        this.client = client;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    MilvusService(String host, int port, String collectionName, int nlist){
        this.collectionName = collectionName;
        //建立连接
        ConnectParam connectParam = new ConnectParam.Builder().withHost(host).withPort(port).build();
        try {
            client.connect(connectParam);
            //连接正常则创建collection

            Response responseCollect = createCollect(collectionName, 10, 1024, MetricType.IP);
            System.out.println(responseCollect.getMessage());

            //创建索引
            if(createIndex(nlist)){
                System.out.println("创建索引");
            }else {
                System.out.println("索引创建失败");
            }

        } catch (ConnectFailedException e) {
            System.out.println("连接失败！");
        }
    }

    MilvusService(String host, int port, String collectionName){
        this(host, port, collectionName, 1000);
    }

    public MilvusService(){
        this("localhost", 19530, "ffsearch");
    }


    /**
     * 插入特征向量
     * @param features
     * @return
     */
    public List<Long> insertFeatures(List<List<Float>> features){
        //先判断是否正常连接
        boolean connected = client.isConnected();
        if(!connected){
            System.out.println("连接失败！！");
        }

        //插入特征向量
        InsertParam insertParam = new InsertParam.Builder(collectionName).withFloatVectors(features).build();
        InsertResponse insertResponse = client.insert(insertParam);
        client.flush(collectionName);

        boolean flag = insertResponse.ok();
        if(!flag){
            System.out.println("插入失败");
            return null;
        }

        List<Long> vectorIds = insertResponse.getVectorIds();
        return vectorIds;
    }


    /**
     * 查询相似的特诊向量
     * @param vectorsToSearch
     * @param topK
     * @return
     */
    public SearchResponse searchFeature(List<List<Float>> vectorsToSearch, long topK, int nprobe){
        //先判断是否正常连接
        boolean connected = client.isConnected();
        if(!connected){
            System.out.println("连接失败！！");
        }

        JsonObject indexParamsJson = new JsonObject();
        indexParamsJson.addProperty("nprobe", nprobe);   //nprobe代表选择最近的多少个聚类去比较。
        SearchParam searchParam =new SearchParam.Builder(collectionName).withFloatVectors(vectorsToSearch)
                .withParamsInJson(indexParamsJson.toString())
                .withTopK(topK)
                .build();
        SearchResponse searchResponse = client.search(searchParam);
        return searchResponse;
    }

    public SearchResponse searchFeature(List<List<Float>> vectorsToSearch, long topK){
        return searchFeature(vectorsToSearch, topK, 15);
    }

    /**
     * 创建数据库表
     * @param collectionName 表的名称
     * @param dimension 向量维度
     * @param indexFileSize 单个文件的大小值
     * @param metricType
     * @return
     */
    private Response createCollect(String collectionName, int dimension, int indexFileSize,MetricType metricType){
        CollectionMapping collectionMapping = new CollectionMapping.Builder(collectionName, dimension)
                .withIndexFileSize(indexFileSize)
                .withMetricType(metricType)
                .build();
        Response response = client.createCollection(collectionMapping);
        return response;
    }

    // 创建索引，指定聚类数
    private boolean createIndex(int nlist){
        final IndexType indexType = IndexType.IVF_SQ8;
        JsonObject indexParamsJson = new JsonObject();
        indexParamsJson.addProperty("nlist", nlist);   //nlist代表聚类数，根据数据量多少设置
        Index index =
                new Index.Builder(collectionName, indexType)
                        .withParamsInJson(indexParamsJson.toString())
                        .build();
        Response createIndexResponse = client.createIndex(index);
        return createIndexResponse.ok();
    }










}
