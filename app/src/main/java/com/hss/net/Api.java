package com.hss.net;
/**
 * Created by TheScar on 2018/1/24.
 * 所有的接口
*/

public interface Api {
    //获得购物车的接口
    public static final String GETCARS = "https://www.zhaoapi.cn/product/getCarts";
    //Boss
    public static final String BASE = "http://120.27.23.105/";
    //Login
    public static final String Login = "user/login";
    public static final String zhuce = "user/reg";
    //创建订单接口
    public static final String CREATEORDER = "https://www.zhaoapi.cn/product/createOrder";
    //获取订单列表接口
    public static final String GETORDERS = "https://www.zhaoapi.cn/product/getOrders";
    //.修改订单状态
    public static final String UPDATEORDER = "https://www.zhaoapi.cn/product/updateOrder";
}