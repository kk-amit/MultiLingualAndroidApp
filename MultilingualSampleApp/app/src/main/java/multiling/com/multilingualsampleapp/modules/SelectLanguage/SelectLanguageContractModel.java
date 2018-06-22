package multiling.com.multilingualsampleapp.modules.SelectLanguage;

import android.content.Context;

import multiling.com.multilingualsampleapp.Constants;
import multiling.com.multilingualsampleapp.LocaleManager;
import multiling.com.multilingualsampleapp.Utility;

public class SelectLanguageContractModel implements SelectLanguageContract.ISelectLanguageContractModel {

    private Context context;

    public SelectLanguageContractModel(Context context) {
        this.context = context;
    }

    @Override
    public void setNewLocale(String language) {
        Utility.saveString(context, Constants.ALREADY_LANGUAGE_SELECTED, Constants.ALREADY_LANGUAGE_SELECTED);
        LocaleManager.setNewLocale(context, language);
    }
}
