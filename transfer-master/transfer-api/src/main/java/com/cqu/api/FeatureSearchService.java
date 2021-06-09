package com.cqu.api;

import com.cqu.pojo.Feature;

import java.util.List;

public interface FeatureSearchService {

    /**  特征搜索接口
     *
     **/
    //返回与该向量最接近的k个向量的id列表
    List<Long> getTopKIds(Feature feature,int topK);

    //
    Long getTopOneId(Feature feature);


    List<Long> insertFeatures(List<Feature> features);


    Long insertOneFeature(Feature feature);
}
