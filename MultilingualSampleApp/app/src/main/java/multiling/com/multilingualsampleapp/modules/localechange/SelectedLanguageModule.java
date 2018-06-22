package multiling.com.multilingualsampleapp.modules.localechange;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SelectedLanguageModule {

    @Provides
    @Singleton
    SelectedLanguageContract.ISelectedLanguagePresenter provideSelectedLanguageModule() {
        return new SelectedLanguagePresenter();
    }
}
