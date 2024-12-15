package com.itheima.goodsconsumer.hystrix;

import com.itheima.Cart;
import com.itheima.goodsconsumer.service.CartService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartServiceHystrix implements CartService {
    @Override
    public List<Cart> getAllCart(int uid) {
        return null;
    }

    @Override
    public int updateCart(int number, int id) {
        return 0;
    }

    @Override
    public int insertCart(String goodsname, int number, int price, int goodid, int uid) {
        return 0;
    }
}
