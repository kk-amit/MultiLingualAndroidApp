package multiling.com.multilingualsampleapp.modules;

import javax.inject.Singleton;

import dagger.Component;
import multiling.com.multilingualsampleapp.modules.Main.MainActivity;
import multiling.com.multilingualsampleapp.modules.Main.MainModule;
import multiling.com.multilingualsampleapp.modules.SelectLanguage.SelectLanguageActivity;
import multiling.com.multilingualsampleapp.modules.SelectLanguage.SelectLanguageModule;
import multiling.com.multilingualsampleapp.modules.Splash.SplashActivity;
import multiling.com.multilingualsampleapp.modules.Splash.SplashModule;
import multiling.com.multilingualsampleapp.modules.localechange.SelectedLanguageActivity;
import multiling.com.multilingualsampleapp.modules.localechange.SelectedLanguageModule;
import multiling.com.multilingualsampleapp.modules.settings.LanguageSettingActivity;
import multiling.com.multilingualsampleapp.modules.settings.LanguageSettingModule;

/**
 * MyComponent.
 */

@Singleton
@Component(modules = {SplashModule.class, MainModule.class, SelectLanguageModule.class, SelectedLanguageModule.class, LanguageSettingModule.class})
public interface MyComponent {
    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);

    void inject(SelectLanguageActivity selectLanguageActivity);

    void inject(SelectedLanguageActivity selectedLanguageActivity);

    void inject(LanguageSettingActivity languageSettingActivity);
}
