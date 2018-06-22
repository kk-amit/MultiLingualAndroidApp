package multiling.com.multilingualsampleapp.modules.SelectLanguage;

import android.view.View;

/**
 * SelectLanguageContractPresenter
 */

public class SelectLanguageContractPresenter implements SelectLanguageContract.ISelectLanguageContractPresenter {

    private SelectLanguageContract.ISelectLanguageContractView selectLanguageContractView;
    private SelectLanguageContract.ISelectLanguageContractModel selectLanguageContractModel;

    public SelectLanguageContractPresenter(SelectLanguageContract.ISelectLanguageContractModel iSelectLanguageContractModel) {
        this.selectLanguageContractModel = iSelectLanguageContractModel;
    }

    @Override
    public void addPresenter(SelectLanguageContract.ISelectLanguageContractView selectLanguageContractView) {
        this.selectLanguageContractView = selectLanguageContractView;
    }

    @Override
    public void removePresenter() {
        selectLanguageContractView = null;
    }

    @Override
    public SelectLanguageContract.ISelectLanguageContractView getSelectedLanguageView() {
        return selectLanguageContractView;
    }

    @Override
    public SelectLanguageContract.ISelectLanguageContractModel getSelectedLanguageModel() {
        return selectLanguageContractModel;
    }

    @Override
    public void init() {
        selectLanguageContractView.onInit();
    }

    @Override
    public void showVisibleTick(View view) {
        selectLanguageContractView.onShowVisibleTick(view);
    }

    @Override
    public void selectNewLanguage(String language) {
        selectLanguageContractModel.setNewLocale(language);
        selectLanguageContractView.onLanguageSelected();
    }
}
