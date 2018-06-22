package multiling.com.multilingualsampleapp.modules.SelectLanguage;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by asrivastava on 5/18/2018.
 */
@Module
public class SelectLanguageModule {

    private Context context;

    public SelectLanguageModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    SelectLanguageContract.ISelectLanguageContractPresenter provideSelectLanguageModule() {
        return new SelectLanguageContractPresenter(provideSelectLangModel());
    }

    private SelectLanguageContract.ISelectLanguageContractModel provideSelectLangModel() {
        return new SelectLanguageContractModel(context);
    }
}
