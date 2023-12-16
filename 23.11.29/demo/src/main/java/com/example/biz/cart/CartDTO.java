package com.example.biz.cart;

import lombok.Data;

@Data
public class CartDTO {
    private int cNum; // 장바구니 번호
    private int mId; // 아이디(FK)
    private int pNum; // 상품번호(FK)
    private int cCnt; // 장바구니에 담은 수량
}
