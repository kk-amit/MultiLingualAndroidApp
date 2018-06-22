package multiling.com.multilingualsampleapp.modules.settings;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LanguageSettingModule {

    private Context context;

    public LanguageSettingModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    LanguageSettingContract.ILanguageSettingPresenter provideLanguageSettingModule() {
        return new LanguageSettingPresenter(provideLanguageSettingModel());
    }

    private LanguageSettingContract.ILanguageSettingModel provideLanguageSettingModel() {
        return new LanguageSettingModel(context);
    }
}
