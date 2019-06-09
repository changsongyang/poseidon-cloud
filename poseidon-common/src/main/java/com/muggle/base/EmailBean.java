package com.muggle.base;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class EmailBean implements Serializable {
    private String recipient;   //邮件接收人
    private String subject; //邮件主题
    private String content; //邮件内容

}