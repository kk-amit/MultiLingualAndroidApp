package multiling.com.multilingualsampleapp.modules.Splash;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * SplashModule .
 */
@Module
public class SplashModule {
    @Provides
    @Singleton
    SplashContract.ISplashPresenter provideSplashModule() {
        return new SplashPresenter();
    }
}
