package com.hss.net;




import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
/**
 * Created by TheScar on 2018/1/24.
 * Retrofit管理者
*/

public class RetrofitManager {

    public static OkHttpClient client = new OkHttpClient.Builder()
            //OK自定义拦截器
            .addInterceptor(new LoggingInterceptor())
            .build();


    public static com.hss.net.ApiService apiService = new Retrofit.Builder()
            .baseUrl(com.hss.net.Api.BASE)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService.class);


    public static void get(String url, Map<String,String> map, Observer observer){

        apiService.get(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }


    public static void post(String url,Map<String,String> map,Observer observer){
        apiService.post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}