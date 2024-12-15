package com.itheima.goodsprovider.controller;

import com.itheima.Goods;
import com.itheima.goodsprovider.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    GoodsDao goodsDao;

    @GetMapping("/getAllGoods")
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }

    @GetMapping("/getLikeGoods")
    public List<Goods> getLikeGoods(@RequestParam("gname") String gname){
        return goodsDao.getLikeGoods(gname);
    }

    @GetMapping("/getIdGoods")
    public Goods getIdGoods(@RequestParam("gid") int gid){
        return goodsDao.getIdGoods(gid);
    }




}
