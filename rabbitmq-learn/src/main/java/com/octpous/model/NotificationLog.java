package com.octpous.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NotificationLog implements Serializable {


    private String contractNo;
    private String subGroupNo;
    private String certificateNumber;
    private String lob;
    private String policRole;
    private String contactSource;
    private String description;
    private String subject;
    private String sourceSystem;
    private Date createDateTime;

    public static void main(String[] args) {
        NotificationLog log = new NotificationLog();
        log.setContractNo("a19895542157");
        log.setLob("lob");
        log.setCertificateNumber("133sfadf");
        String s = JSONObject.toJSONString(log);
        System.out.println(s);
    }
}
