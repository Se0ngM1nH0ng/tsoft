package com.example.biz.order;

import com.example.biz.cart.CartDTO;

import java.util.List;
import java.util.Map;

public interface InterfaceOrderDAO {
    List<CartDTO> selectAll();
    boolean insert(Map<String, Object> map); // 인자가 2개이상이라 map 컬레션 사용

    CartDTO selectOne(String mid);

    CartDTO selectOne_login(Map<String , Object> map);


    boolean update(Map<String, Object> map);

    boolean delete(String mid);
}
