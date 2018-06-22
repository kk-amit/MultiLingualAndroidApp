package multiling.com.multilingualsampleapp.modules.Main;

/**
 * MainPresenter.
 */

public class MainPresenter implements MainContract.IMainPresenter {

    private MainContract.IMainModel mainModel;
    private MainContract.IMainView mainView;

    public MainPresenter(MainContract.IMainModel iMainModel) {
        this.mainModel = iMainModel;
    }

    @Override
    public void removeMainModel() {
        this.mainModel = null;
    }

    @Override
    public MainContract.IMainModel getMainModel() {
        return mainModel;
    }

    @Override
    public void init() {
        mainView.onInit();
    }

    @Override
    public void addPresenter(MainContract.IMainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void removePresenter() {
        this.mainView = null;
    }

    @Override
    public MainContract.IMainView getMainView() {
        return mainView;
    }

    @Override
    public void startBtnClick() {
        mainModel.showSomething();
        mainView.onStartBtnClick();
    }

}
