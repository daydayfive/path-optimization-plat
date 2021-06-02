package com.cqu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    private Boolean success;
    private String  message;
    private Integer code;
    private Task similarTask;
}
