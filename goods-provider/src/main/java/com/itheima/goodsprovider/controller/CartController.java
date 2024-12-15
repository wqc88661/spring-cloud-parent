package com.itheima.goodsprovider.controller;

import com.itheima.Cart;
import com.itheima.goodsprovider.dao.CartDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartDao cartDao;

    @GetMapping("/getAllCart")
    public List<Cart> getAllCart(@RequestParam("uid") int uid) {
        return cartDao.getAllCart(uid);
    }

    @GetMapping("/updateCart")
    public int updateCart(@RequestParam("/number") int number, @RequestParam("id") int id) {
        return cartDao.updateCart(number, id);
    }

    @GetMapping("/insertCart")
    public int insertCart(@RequestParam("goodsname") String goodsname, @RequestParam("number") int number,
                          @RequestParam("price") int price, @RequestParam("goodid") int goodid, @RequestParam("uid") int uid) {
        return cartDao.insertCart(goodsname, number, price, goodid, uid);
    }

}
