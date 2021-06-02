package com.cqu.service.impl;

import com.cqu.api.FeatureSearchService;
import com.cqu.milvusmapper.MilvusService;
import com.cqu.pojo.Feature;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@DubboService(version = "1.0.0")
public class FeatureSearchServiceImpl implements FeatureSearchService {

    @Autowired
    MilvusService milvusService;


    /**
     *
     * @param features
     * @param topK
     * @return topK个与输入向量最接近的向量
     */
    @Override
    public List<List<Long>> getTopKIds(List<Feature> features,int topK) {

        List<List<Float>> f=new ArrayList<>();
        for(Feature feature:features){
            f.add(feature.getFeatures());
        }

        List<List<Long>> resultIdsList = milvusService.searchFeature(f, topK).getResultIdsList();
        return resultIdsList;
    }

    @Override
    public  List<List<Long>> getTopOneId(List<Feature> features) {
        List<List<Float>> f=new ArrayList<>();
        for(Feature feature:features){
            f.add(feature.getFeatures());
        }

        List<List<Long>> resultIdsList = milvusService.searchFeature(f, 1).getResultIdsList();
        return resultIdsList;
    }

    @Override
    public List<Long> insertFeatures(List<Feature> features) {

        List<Long> ids=new ArrayList<>();

        List<List<Float>> f=new ArrayList<>();

        for(Feature feature:features){
            f.add(feature.getFeatures());
        }

        ids=milvusService.insertFeatures(f);


        return ids;
    }
}
