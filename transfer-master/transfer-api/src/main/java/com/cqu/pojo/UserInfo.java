package com.cqu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class UserInfo {
    @TableId(value="user_id",type= IdType.AUTO)
    private Long userId;

    private String name;

    private String email;

    private Integer enableStatus;

    private Integer userType;

    private Date createTime;

    private Date lastEditTime;
}
