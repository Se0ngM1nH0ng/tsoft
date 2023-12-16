package com.hong.test1.cart;

import com.hong.test1.cart.CartDTO;

import java.util.List;

public interface InterfaceCartService {
    List<CartDTO> selectAll();
    CartDTO selectOne(CartDTO cDTO);

    boolean insert(CartDTO cDTO);
    boolean update(CartDTO cDTO);
    boolean delete(CartDTO cDTO);
}
