package com.itheima.goodsconsumer.controller;

import com.itheima.Goods;
import com.itheima.goodsconsumer.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    //退出登录并跳转登陆页面的接口
    @GetMapping("/quit")
    public String quit(HttpSession session) {
        session.removeAttribute("uaccount");
        return "redirect:http://localhost:8893/admin/toLogin";
    }

    @GetMapping("/getAllGoods")
    //1.查询所有商品的集合
    public String getAllGoods(HttpServletRequest request,String uaccount,HttpSession session) {
        session.setAttribute("uaccount",uaccount);
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();

        List<Goods> newGoods = goodsService.getAllGoods();
        for (Goods newGood : newGoods) {
            if (newGood.getTypes().equals(1)) {
                goods1.add(newGood);
            }
            if (newGood.getTypes().equals(2)) {
                goods2.add(newGood);
            }
            if (newGood.getTypes().equals(0)) {
                goods3.add(newGood);
            }
            if (newGood.getTypes().equals(3)) {
                goods4.add(newGood);
            }
        }
        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);

        return "index";
    }

    //根据商品的名称进行模糊查询
    @GetMapping("/getLikeGoods")
    public String getLikeGoods(HttpServletRequest request, String gname) {
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();

        List<Goods> newGoods = goodsService.getLikeGoods(gname);
        for (Goods newGood : newGoods) {
            if (newGood.getTypes().equals(1)) {
                goods1.add(newGood);
            }
            if (newGood.getTypes().equals(2)) {
                goods2.add(newGood);
            }
            if (newGood.getTypes().equals(0)) {
                goods3.add(newGood);
            }
            if (newGood.getTypes().equals(3)) {
                goods4.add(newGood);
            }
        }
        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);

        return "index";
    }


    //根据商品的id进行查询
    @GetMapping("/getIdGoods")
    public String getIdGoods(HttpServletRequest request, int gid) {
        Goods idGoods = goodsService.getIdGoods(gid);
        request.setAttribute("detail", idGoods);
        return "detail";
    }
}
