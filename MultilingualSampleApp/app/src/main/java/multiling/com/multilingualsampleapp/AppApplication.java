package multiling.com.multilingualsampleapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import multiling.com.multilingualsampleapp.modules.DaggerMyComponent;
import multiling.com.multilingualsampleapp.modules.Main.MainModule;
import multiling.com.multilingualsampleapp.modules.MyComponent;
import multiling.com.multilingualsampleapp.modules.SelectLanguage.SelectLanguageModule;
import multiling.com.multilingualsampleapp.modules.Splash.SplashModule;
import multiling.com.multilingualsampleapp.modules.localechange.SelectedLanguageModule;
import multiling.com.multilingualsampleapp.modules.settings.LanguageSettingModule;

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
                .splashModule(new SplashModule(getApplicationContext()))
                .mainModule(new MainModule(getApplicationContext()))
                .selectLanguageModule(new SelectLanguageModule(getApplicationContext()))
                .selectedLanguageModule(new SelectedLanguageModule())
                .languageSettingModule(new LanguageSettingModule(getApplicationContext()))
                .build();
    }

    public MyComponent getMyComponent() {
        return mMyComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
    }


}
