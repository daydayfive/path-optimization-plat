package com.cqu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    @TableId(value="auth_id",type= IdType.AUTO)
    private Long authId;

    private Long userId;

    private String username;

    private String password;

    private Date createTime;

    private Date lastEditTime;
}
