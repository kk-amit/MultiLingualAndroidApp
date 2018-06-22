package multiling.com.multilingualsampleapp.modules.settings;

import android.widget.CompoundButton;

public class LanguageSettingPresenter implements LanguageSettingContract.ILanguageSettingPresenter {

    private LanguageSettingContract.ILanguageSettingView languageSettingView;
    private LanguageSettingContract.ILanguageSettingModel languageSettingModel;

    public LanguageSettingPresenter(LanguageSettingContract.ILanguageSettingModel languageSettingModel) {
        this.languageSettingModel = languageSettingModel;
    }

    @Override
    public void addPresenter(LanguageSettingContract.ILanguageSettingView languageSettingView) {
        this.languageSettingView = languageSettingView;
    }

    @Override
    public void removePresenter() {
        languageSettingView = null;
    }

    @Override
    public void setCheckView(CompoundButton buttonView, String language) {
        languageSettingView.onSetCheckView(buttonView, language);
    }

    @Override
    public void changeLanguage(String selectedLang) {
        languageSettingModel.selectLanguage(selectedLang);
        languageSettingView.onChangeLanguage();
    }
}
