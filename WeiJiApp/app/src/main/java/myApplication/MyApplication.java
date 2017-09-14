package myApplication;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import org.xutils.x;

import entity.User;


/**
 * Created by Mr.chen on 2016/10/8.
 */

    public class MyApplication extends Application{


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user=new User(1);//设置一个默认的用户：id=1



    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}


