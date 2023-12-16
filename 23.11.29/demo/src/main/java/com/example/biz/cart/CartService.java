package com.example.biz.cart;

import com.example.biz.cart.InterfaceCartDAO;
import com.example.biz.cart.CartDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service
@RequiredArgsConstructor
public class CartService {
    private final InterfaceCartDAO mDAO;

    @Override
    public List<CartDTO> selectAll() {

        return mDAO.selectAll();
    }

    @Override
    public CartDTO selectOne(CartDTO cDTO) {

        return mDAO.selectOne(cDTO.getMId());
    }
    @Override
    public CartDTO selectOne_login(CartDTO cDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("data1", cDTO.getMId());
        map.put("data2", cDTO.getMPw());
        return mDAO.selectOne_login(map);
    }

    @Override
    public boolean insert(CartDTO cDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", cDTO.getMId()); // 첫번째
        map.put("data2", cDTO.getMPw()); // 두번째
        map.put("data3", cDTO.getMName()); // 두번째
        return mDAO.insert(map);
    }

    @Override
    public boolean update(CartDTO cDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", cDTO.getMPw()); // 첫번째
        map.put("data2", cDTO.getMId()); // 두번째
        return mDAO.update(map);
    }

    @Override
    public boolean delete(CartDTO cDTO) {

        return mDAO.delete(cDTO.getMId()); // param 인자 방식
    }
}
