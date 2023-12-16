package com.example.biz.orderDetail;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private int odNum; // 주문 상세 번호
    private int oNum; // 주문번호
    private int pNum; // 상품번호
    private int odCnt; // 내가 구매하려는 수량
}
