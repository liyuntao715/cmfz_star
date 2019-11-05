package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Excel(name = "编号")
    private String id;
    @Excel(name = "用户名")
    private String username;
    @Excel(name = "密码")
    private String password;
    private String salt;
    @Excel(name = "姓名")
    private String nickname;
    @Excel(name = "电话")
    private String phone;
    @Excel(name = "省份")
    private String province;
    @Excel(name = "城市")
    private String city;
    @Excel(name = "签名")
    private String sign;
    @Excel(name = "照片")
    private String photo;
    @Excel(name = "性别")
    private String sex;
    @Excel(name = "创建时间",type = 2)
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private String starId;
    private int count;





}
