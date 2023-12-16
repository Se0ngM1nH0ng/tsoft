package com.hong.test1.cart;

import com.hong.test1.cart.CartDTO;

import java.util.List;
import java.util.Map;

public interface InterfaceCartDAO {
    List<CartDTO> selectAll();
    boolean insert(Map<String, Object> map); // 인자가 2개이상이라 map 컬레션 사용
    CartDTO selectOne(int cNum);
    boolean update(Map<String, Object> map);
    boolean delete(int cNum);
}
