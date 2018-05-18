package multiling.com.multilingualsampleapp.modules;

import javax.inject.Singleton;

import dagger.Component;
import multiling.com.multilingualsampleapp.modules.Main.MainActivity;
import multiling.com.multilingualsampleapp.modules.Main.MainModule;
import multiling.com.multilingualsampleapp.modules.Splash.SplashActivity;
import multiling.com.multilingualsampleapp.modules.Splash.SplashModule;

/**
 * MyComponent.
 */

@Singleton
@Component(modules = {SplashModule.class, MainModule.class})
public interface MyComponent {
    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);
}
