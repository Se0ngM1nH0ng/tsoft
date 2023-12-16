package com.example.biz.order;

import com.example.biz.order.OrderDTO;
import com.example.biz.order.InterfaceOrderDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service
@RequiredArgsConstructor
public class OrderService {
    private final InterfaceOrderDAO orderDAO;

    @Override
    public List<OrderDTO> selectAll() {

        return mDAO.selectAll();
    }

    @Override
    public OrderDTO selectOne(OrderDTO oDTO) {

        return mDAO.selectOne(oDTO.getMId());
    }
    @Override
    public OrderDTO selectOne_login(OrderDTO oDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("data1", oDTO.getMId());
        map.put("data2", oDTO.getMPw());
        return mDAO.selectOne_login(map);
    }

    @Override
    public boolean insert(OrderDTO oDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", oDTO.getMId()); // 첫번째
        map.put("data2", oDTO.getMPw()); // 두번째
        map.put("data3", oDTO.getMName()); // 두번째
        return mDAO.insert(map);
    }

    @Override
    public boolean update(OrderDTO oDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", oDTO.getMPw()); // 첫번째
        map.put("data2", oDTO.getMId()); // 두번째
        return mDAO.update(map);
    }

    @Override
    public boolean delete(OrderDTO oDTO) {

        return mDAO.delete(oDTO.getMId()); // param 인자 방식
    }
}
