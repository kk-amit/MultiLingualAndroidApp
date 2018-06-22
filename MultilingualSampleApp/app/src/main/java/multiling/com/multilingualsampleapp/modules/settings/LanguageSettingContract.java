package multiling.com.multilingualsampleapp.modules.settings;

import android.widget.CompoundButton;

public class LanguageSettingContract {

    public interface ILanguageSettingView {
        void onSetCheckView(CompoundButton buttonView, String language);

        void onChangeLanguage();
    }

    public interface ILanguageSettingPresenter {
        void addPresenter(LanguageSettingContract.ILanguageSettingView languageSettingView);

        void removePresenter();

        void setCheckView(CompoundButton buttonView, String language);

        void changeLanguage(String selectedLang);

        LanguageSettingContract.ILanguageSettingView getSettingLanguageView();

        LanguageSettingContract.ILanguageSettingModel getSettingLanguageModel();

    }

    public interface ILanguageSettingModel {
        void selectLanguage(String selectedLang);
    }

}
