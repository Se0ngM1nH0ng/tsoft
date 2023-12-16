/*package com.hong.test1.cart;

import com.hong.test1.cart.InterfaceCartDAO;
import com.hong.test1.cart.CartDTO;
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
    private final InterfaceCartDAO cDAO;

    @Override
    public List<CartDTO> selectAll() {

        return cDAO.selectAll();
    }

    @Override
    public CartDTO selectOne(CartDTO cDTO) {

        return cDAO.selectOne(cDTO.getCNum());
    }
    @Override
    public CartDTO selectOne_login(CartDTO cDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("cNum", cDTO.getCNum());
        map.put("mId", cDTO.getMId() );
        map.put("pNum", cDTO.getPNum());
        map.put("cCnt", cDTO.getCCnt());
        return cDAO.selectOne_login(map);
    }

    @Override
    public boolean insert(CartDTO cDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", cDTO.getMId()); // 첫번째
        map.put("data2", cDTO.getMPw()); // 두번째
        map.put("data3", cDTO.getMName()); // 두번째
        return cDAO.insert(map);
    }

    @Override
    public boolean update(CartDTO cDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", cDTO.getMPw()); // 첫번째
        map.put("data2", cDTO.getMId()); // 두번째
        return cDAO.update(map);
    }

    @Override
    public boolean delete(CartDTO cDTO) {

        return cDAO.delete(cDTO.getMId()); // param 인자 방식
    }
}
*/