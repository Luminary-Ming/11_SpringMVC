package com.ssm.pojo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // 订单 id
    private Integer id;
    // 用户 id
    private Long userId;
    // 订单号
    private String orderNumber;

}
