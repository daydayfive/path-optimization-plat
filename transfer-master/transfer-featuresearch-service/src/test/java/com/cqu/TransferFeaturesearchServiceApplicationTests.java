package com.cqu;

import com.cqu.milvusmapper.MilvusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TransferFeaturesearchServiceApplicationTests {


    @Autowired
    MilvusService milvusService;
    @Test
    void contextLoads() {


        List<List<Float>> features= new ArrayList<>();

        ArrayList<Float> feature=new ArrayList<>();

        feature.add(-154.92126f);
        feature.add(235.61534f);
        feature.add(11.939766f);
        feature.add(311.41034f);
        feature.add(-109.505264f);
        feature.add(-56.43986f);
        feature.add(146.64279f);
        feature.add(225.2928f);
        feature.add(-264.79373f);
        feature.add(-363.71985f);
        features.add(feature);

        feature=new ArrayList<>();

        feature.add(-158.09177f);
        feature.add(10.38351f);
        feature.add(145.29347f);
        feature.add(171.17087f);
        feature.add(-293.7055f);
        feature.add(197.5978f);
        feature.add(13.885193f);
        feature.add(-5.0409203f);
        feature.add(-332.36987f);
        feature.add(-396.41177f);
        features.add(feature);

        feature=new ArrayList<>();

        feature.add(-223.75792f);
        feature.add(-44.727123f);
        feature.add(165.35223f);
        feature.add(104.20008f);
        feature.add(-174.57637f);
        feature.add(283.7687f);
        feature.add(14.198196f);
        feature.add(36.29561f);
        feature.add(-258.592f);
        feature.add(-382.50565f);
        features.add(feature);

        feature=new ArrayList<>();

        feature.add(-69.494446f);
        feature.add(-171.25337f);
        feature.add(220.52809f);
        feature.add(208.69989f);
        feature.add(-348.49368f);
        feature.add(210.54195f);
        feature.add(58.451035f);
        feature.add(-127.422264f);
        feature.add(-277.88647f);
        feature.add(-360.27704f);
        features.add(feature);

        feature=new ArrayList<>();

        feature.add(-156.00055f);
        feature.add(316.7929f);
        feature.add(-98.197754f);
        feature.add(195.52045f);
        feature.add(-140.98451f);
        feature.add(-4.538875f);
        feature.add(-18.591076f);
        feature.add(201.23048f);
        feature.add(-331.86414f);
        feature.add(-341.35165f);
        features.add(feature);

        System.out.println(milvusService.insertFeatures(features));

        feature=new ArrayList<>();
        features= new ArrayList<>();
        feature.add(-66.32581f);
        feature.add(383.11993f);
        feature.add(-210.89827f);
        feature.add(179.14844f);
        feature.add(-133.06346f);
        feature.add(-99.225525f);
        feature.add(-65.7545f);
        feature.add(190.76233f);
        feature.add(-347.08258f);
        feature.add(-285.69427f);
        features.add(feature);

        System.out.println(milvusService.searchFeature(features, 3, 1).getResultIdsList());


    }


    @Test
    void contextLoads2() {

        System.out.println(milvusService.getClient().getCollectionStats("ffsearch"));

        System.out.println(milvusService.getClient().countEntities("ffsearch"));


    }

    @Test
    void contextLoads3() {

        List<List<Float>> features= new ArrayList<>();

        ArrayList<Float> feature=new ArrayList<>();
        feature.add(-66.32581f);
        feature.add(383.11993f);
        feature.add(-210.89827f);
        feature.add(179.14844f);
        feature.add(-133.06346f);
        feature.add(-99.225525f);
        feature.add(-65.7545f);
        feature.add(190.76233f);
        feature.add(-347.08258f);
        feature.add(-285.69427f);
        features.add(feature);

        System.out.println(milvusService.searchFeature(features, 3, 2).getResultIdsList());

    }




}
