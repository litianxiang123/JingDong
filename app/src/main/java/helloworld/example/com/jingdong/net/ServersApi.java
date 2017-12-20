package helloworld.example.com.jingdong.net;

import helloworld.example.com.jingdong.addCart.AddCartBean;
import helloworld.example.com.jingdong.catagory.CataGoryBean;
import helloworld.example.com.jingdong.catagory.ProductCatagoryBean;
import helloworld.example.com.jingdong.getCarts.CartsBean;
import helloworld.example.com.jingdong.login.bean.LoginBean;
import helloworld.example.com.jingdong.register.RegisterBean;
import helloworld.example.com.jingdong.shop.ShopBean;
import helloworld.example.com.jingdong.shouye.ShouYeBean;
import helloworld.example.com.jingdong.sousuo.SouBean;
import helloworld.example.com.jingdong.syhua.HuaBean;
import helloworld.example.com.jingdong.user.UserBean;
import helloworld.example.com.jingdong.xiangqing.XiangqingBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public interface ServersApi {
    //登录接口
    @GET("{user}/{login}")
    Flowable<LoginBean> loginBean(@Path("user") String u, @Path("login") String l, @Query("mobile") String m, @Query("password") String p);

    //注册接口
    @GET("{user}/{reg}")
    Flowable<RegisterBean> registerBean(@Path("user") String u,@Path("reg") String r,@Query("mobile") String m,@Query("password") String p);

    //获取用户信息接口
    @GET("{user}/{getUserInfo}")
    Flowable<UserBean> userBean(@Path("user") String u,@Path("getUserInfo") String g,@Query("uid") String d);

    //获取商品分类接口   https://www.zhaoapi.cn/product/getCatagory
    @GET("{product}/{getCatagory}")
    Flowable<CataGoryBean> cataGoryBean(@Path("product")String p,@Path("getCatagory") String g);

    //获取商品子分类接口   https://www.zhaoapi.cn/product/getProductCatagory
    @GET("{product}/{getProductCatagory}")
    Flowable<ProductCatagoryBean> proBean(@Path("product") String p,@Path("getProductCatagory") String g,@Query("cid") String c);

    //当前子分类下的商品列表接口  https://www.zhaoapi.cn/product/getProducts
    @GET("{product}/{getProducts}")
    Flowable<ShopBean> shopBean(@Path("product") String p,@Path("getProducts") String g,@Query("pscid") String d);

    //商品详情接口 https://www.zhaoapi.cn/product/getProductDetail
    @GET("{product}/{getProductDetail}")
    Flowable<XiangqingBean> XQbean(@Path("product") String p,@Path("getProductDetail") String g,@Query("source") String s,@Query("pid") String d);

    //首页滑动接口
    @GET("{product}/{getCatagory}")
    Flowable<HuaBean> huaBean(@Path("product") String p,@Path("getCatagory") String g);

    //首页广告（轮播图+京东秒杀+最底部的为你推荐）  https://www.zhaoapi.cn/ad/getAd
    @GET("{ad}/{getAd}")
    Flowable<ShouYeBean> syBean(@Path("ad") String a,@Path("getAd") String g);

    //根据关键词搜索商品  https://www.zhaoapi.cn/product/searchProducts?keywords=笔记本
    @GET("{product}/{searchProducts}")
    Flowable<SouBean> souBean(@Path("product") String p,@Path("searchProducts") String s,@Query("source") String o,@Query("keywords") String k);

    //添加购物车  https://www.zhaoapi.cn/product/addCart
    @GET("{product}/{addCart}")
    Flowable<AddCartBean> addBean(@Path("product") String p,@Path("addCart") String a,@Query("source") String s,@Query("uid") String u,@Query("pid") String d);

    //查询购物车   https://www.zhaoapi.cn/product/getCarts
    @GET("{product}/{getCarts}")
    Flowable<CartsBean> cartsBean(@Path("product") String p,@Path("getCarts") String g,@Query("source") String s,@Query("uid") String u);

}
