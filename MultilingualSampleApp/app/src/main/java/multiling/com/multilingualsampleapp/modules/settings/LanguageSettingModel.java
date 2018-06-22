package multiling.com.multilingualsampleapp.modules.settings;

import android.content.Context;

import multiling.com.multilingualsampleapp.LocaleManager;

public class LanguageSettingModel implements LanguageSettingContract.ILanguageSettingModel {

    private Context context;

    public LanguageSettingModel(Context context) {
        this.context = context;
    }

    @Override
    public void selectLanguage(String selectedLang) {
        LocaleManager.setNewLocale(context, selectedLang);
    }
}
