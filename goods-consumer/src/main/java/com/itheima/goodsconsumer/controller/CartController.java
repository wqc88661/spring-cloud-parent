package com.itheima.goodsconsumer.controller;

import com.itheima.Cart;
import com.itheima.goodsconsumer.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    //1.根据用户的id查询购物车里所有的购物项
    @GetMapping("/getAllCart")
    public String getAllCart(HttpServletRequest request, HttpSession session) {
        String uid = (String) session.getAttribute("uaccount");
        List<Cart> allCart = cartService.getAllCart(Integer.parseInt(uid));
        request.setAttribute("carts", allCart);
        return "Settle";
    }

    /*
     * 2.加入购物车
     * （1）添加的购物车商品在cart表中存在，继续操作
     * （2）添加的购物车商品在cart表中不存在，添加操作
     * */
    @GetMapping("/insertCart")
    public String insertCart(String goodid, String name, String number, String price, HttpSession session) {
        String uid = (String) session.getAttribute("uaccount");
        List<Cart> allCart = cartService.getAllCart(Integer.parseInt(uid));
        for (int i = 0; i < allCart.size(); i++) {
            if (allCart.get(i).getGoodid() == Integer.parseInt(goodid)) {
                cartService.updateCart(Integer.parseInt(number), allCart.get(i).getId());
                return "redirect:/cart/getAllCart";
            }
        }

        cartService.insertCart(name, Integer.parseInt(number), Integer.parseInt(price), Integer.parseInt(goodid), Integer.parseInt(uid));
        return "redirect:/cart/getAllCart";
    }


}
