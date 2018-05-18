package multiling.com.multilingualsampleapp;

import android.app.Application;

import multiling.com.multilingualsampleapp.modules.DaggerMyComponent;
import multiling.com.multilingualsampleapp.modules.Main.MainModule;
import multiling.com.multilingualsampleapp.modules.MyComponent;
import multiling.com.multilingualsampleapp.modules.Splash.SplashModule;

/**
 * AppApplication.
 */

public class AppApplication extends Application {

    private static AppApplication appInstance;
    private MyComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        mMyComponent = createMyComponent();
    }

    public static AppApplication getInstance() {
        return appInstance;
    }

    private MyComponent createMyComponent() {
        return DaggerMyComponent
                .builder()
                .splashModule(new SplashModule())
                .mainModule(new MainModule(getApplicationContext()))
                .build();
    }

    public MyComponent getMyComponent() {
        return mMyComponent;
    }


}
