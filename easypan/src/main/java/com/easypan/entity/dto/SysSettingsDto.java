package com.easypan.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;



/*
* ignoreUnknown = true
* 缓存加对象属性不一致不会报错
* 序列化   */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SysSettingsDto implements Serializable {

    /**
     * 注册发送邮件标题
     */
    private String registerEmailTitle = "邮箱验证码";

    /**
     * 注册发送邮件内容
     */
    private String registerEmailContent = "你好，您的邮箱验证码是：%s，15分钟有效";

    /**
     * 用户初始化空间大小 5M
     */
    private Integer userInitUseSpace = 5;

}
