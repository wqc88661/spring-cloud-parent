package com.itheima.goodsconsumer.service;

import com.itheima.Cart;
import com.itheima.goodsconsumer.hystrix.CartServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "goods-provider", fallback = CartServiceHystrix.class)
public interface CartService {

    @GetMapping("/getAllCart")
    public List<Cart> getAllCart(@RequestParam("uid") int uid);


    @GetMapping("/updateCart")
    public int updateCart(@RequestParam("/number") int number, @RequestParam("id") int id);


    @GetMapping("/insertCart")
    public int insertCart(@RequestParam("goodsname") String goodsname, @RequestParam("number") int number,
                          @RequestParam("price") int price, @RequestParam("goodid") int goodid, @RequestParam("uid") int uid);


}
