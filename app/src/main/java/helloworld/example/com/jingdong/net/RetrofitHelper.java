package helloworld.example.com.jingdong.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private static ServersApi serversApi;

    static {
        getOkHttpClient();
    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null){
            synchronized (RetrofitHelper.class){
                okHttpClient = new OkHttpClient();
            }
        }
        return okHttpClient;
    }

    public static <T> T createApi(Class<T> tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(tClass);
    }

    public static ServersApi getServersApi(String s) {
        if (serversApi == null){
            synchronized (ServersApi.class){
                serversApi = createApi(ServersApi.class,s);
            }
        }
        return serversApi;
    }
}
