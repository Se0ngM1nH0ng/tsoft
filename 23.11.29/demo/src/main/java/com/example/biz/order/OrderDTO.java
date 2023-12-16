package com.example.biz.order;

import lombok.Data;

@Data
public class OrderDTO {
    private int oNum; // 주문번호
    private int oTotalPrice; // 주문 총가격
    private int oDate; // 주문일자
    private int oAddress; // 배송지
    private int mId; // 아이디(FK)
}
