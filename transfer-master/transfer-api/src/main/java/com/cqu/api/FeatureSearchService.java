package com.cqu.api;

import com.cqu.pojo.Feature;

import java.util.List;

public interface FeatureSearchService {

    /**  特征搜索接口
     *
     **/

    List<List<Long>> getTopKIds(List<Feature> features,int topK);


    List<List<Long>> getTopOneId(List<Feature> features);


    List<Long> insertFeatures(List<Feature> features);
}
