package multiling.com.multilingualsampleapp.modules.Main;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * SplashModule .
 */
@Module
public class MainModule {

    private Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    MainContract.IMainPresenter provideMainModule() {
        return new MainPresenter(provideMainModel());
    }

    private MainContract.IMainModel provideMainModel() {
        return new MainModel(context);
    }
}
