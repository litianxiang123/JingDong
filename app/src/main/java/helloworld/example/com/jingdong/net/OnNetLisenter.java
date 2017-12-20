package helloworld.example.com.jingdong.net;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public interface OnNetLisenter<T> {
    public void onSuccess(T t);

    public void onFailure(Exception e);
}
