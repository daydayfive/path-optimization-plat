package com.cqu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("task")
public class Task implements Serializable {
    @TableId(value="task_id",type= IdType.AUTO)
    private Long taskId;

    private String taskName;

    private String taskAddr;

    private Long taskScale;

    private Date createTime;

    private Date lastEditTime;


}
