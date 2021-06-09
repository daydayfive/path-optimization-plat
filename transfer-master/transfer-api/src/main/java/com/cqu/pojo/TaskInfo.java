package com.cqu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskInfo implements Serializable {
    private Long userId;

    private Task task;
    private ArrayList coordinateX;
    private ArrayList coorninateY;
    private TaskFeature feature;

}
