package com.yejy.wealthcatch;

import android.app.Application;
import android.util.Log;
import com.mastersdk.android.NewMasterSDK;
import com.tencent.bugly.crashreport.CrashReport;
import com.yejy.wealthcatch.ui.activity.MainActivity;

import java.util.ArrayList;

import cn.jpush.android.api.JPushInterface;

/**
 * 项目名称：WealthCatch
 * 类描述：
 * 创建人：yejinyun
 * 创建时间：2017/12/25 18:45
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class App extends Application{

    @Override
    public void onCreate() {
//        Log.d("JPush", "[ExampleApplication] onCreate");
        super.onCreate();
//        JPushInterface.init(this);
//        CrashReport.initCrashReport(this.getApplicationContext(), "b556dd99fd", true);
//        ArrayList var1;
//        (var1 = new ArrayList()).add("http://psi48zy.com:9991");
//        var1.add("http://utit29n.com:9991");
//        var1.add("http://yuj8xjz.com:9991");
//        NewMasterSDK.init(MainActivity.class, var1, this);
    }
}
