package com.hss.net;

import android.util.Log;

import com.hss.beans.LoginBean;
import com.hss.net.Api;
import com.hss.net.BaseObserver;
import com.hss.net.RetrofitManager;

import java.util.Map;

public class LoginModule {

    public void getData(Map<String, String> map, final LoginModuleListener loginModuleListener){
        RetrofitManager.post(Api.Login, map, new BaseObserver<LoginBean>() {
            @Override
            public void success(LoginBean loginBean) {
                if(loginModuleListener!=null){
                    loginModuleListener.success(loginBean);
                }
            }

            @Override
            public void failure(int code) {
                Log.d("TAG",code+"");
            }

        });
    }

    public interface LoginModuleListener{
           void success(LoginBean loginBean);
    }

}
