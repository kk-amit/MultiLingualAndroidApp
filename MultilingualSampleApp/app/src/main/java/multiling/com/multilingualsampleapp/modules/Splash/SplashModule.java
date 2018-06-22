package multiling.com.multilingualsampleapp.modules.Splash;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * SplashModule .
 */
@Module
public class SplashModule {

    private Context context;

    public SplashModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    SplashContract.ISplashPresenter provideSplashModule() {
        return new SplashPresenter(provideSplashLangModel());
    }

    private SplashContract.ISplashModel provideSplashLangModel() {
        return new SplashModel(context);
    }
}
