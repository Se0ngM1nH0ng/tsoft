package com.example.biz.product;

import lombok.Data;

@Data
public class ProductDTO {
    private int pNum; // 상품번호
    private int pName; // 상품이름
    private int pPrice; // 상품 가격
    private int pCnt; // 상품 재고

}
