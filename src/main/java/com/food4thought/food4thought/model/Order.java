package com.food4thought.food4thought.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity

public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private String customerName;
//    private Food food;
    private String specialReq;
    private String location;
    private Date orderedAt;
    private Date deliveredAt;
    private OrderState state;
    private Double orderPrice;


    public boolean isActive() {
        return state != OrderState.AT_CUSTOMER;
    }

}
