package multiling.com.multilingualsampleapp.modules.SelectLanguage;

import android.view.View;

/**
 * Created by asrivastava on 5/18/2018.
 */

public class SelectLanguageContract {

    public interface ISelectLanguageContractView {

        void onInit();

        void onShowVisibleTick(View view);

        void onLanguageSelected();
    }

    public interface ISelectLanguageContractModel {
        void setNewLocale(String language);
    }

    public interface ISelectLanguageContractPresenter {
        void addPresenter(SelectLanguageContract.ISelectLanguageContractView selectLanguageContractView);

        void removePresenter();

        SelectLanguageContract.ISelectLanguageContractView getSelectedLanguageView();

        SelectLanguageContract.ISelectLanguageContractModel getSelectedLanguageModel();

        void init();

        void showVisibleTick(View view);

        void selectNewLanguage(String language);
    }
}
