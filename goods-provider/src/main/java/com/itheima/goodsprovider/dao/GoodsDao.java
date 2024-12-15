package com.itheima.goodsprovider.dao;

import com.itheima.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {

    //1.查询所有商品的集合
    List<Goods> getAllGoods();

    //2.根据商品的名称进行模糊查询
    List<Goods> getLikeGoods(@Param("gname") String gname);

    //3.根据商品的id进行查询
    Goods getIdGoods(@Param("gid") int gid);
}
