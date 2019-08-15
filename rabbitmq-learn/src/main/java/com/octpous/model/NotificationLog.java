package com.octpous.model;

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
}
