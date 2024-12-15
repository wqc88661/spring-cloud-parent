package com.itheima.goodsprovider.dao;

import com.itheima.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartDao {

    //1.根据用户的id查询购物车里所有的购物项
    List<Cart> getAllCart(@Param("uid") int uid);

    //2.修改购物车商品的数量
    int updateCart(@Param("number") int number, @Param("id") int id);

    //3.添加购物车
    int insertCart(@Param("goodsname") String goodsname, @Param("number") int number,
                   @Param("price") int price, @Param("goodid") int goodid, @Param("uid") int uid);
}
