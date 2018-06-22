package multiling.com.multilingualsampleapp.modules.settings;

import android.widget.CompoundButton;

public class LanguageSettingContract {

    interface ILanguageSettingView {
        void onSetCheckView(CompoundButton buttonView, String language);

        void onChangeLanguage();
    }

    interface ILanguageSettingPresenter {
        void addPresenter(LanguageSettingContract.ILanguageSettingView languageSettingView);

        void removePresenter();

        void setCheckView(CompoundButton buttonView, String language);

        void changeLanguage(String selectedLang);

    }

    interface ILanguageSettingModel {
        void selectLanguage(String selectedLang);
    }

}
