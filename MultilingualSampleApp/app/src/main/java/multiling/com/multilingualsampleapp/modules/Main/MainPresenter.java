package multiling.com.multilingualsampleapp.modules.Main;

import android.util.Log;

/**
 * MainPresenter.
 */

public class MainPresenter implements MainContract.IMainPresenter {

    MainContract.IMainModel mainModel;

    public MainPresenter(MainContract.IMainModel iMainModel) {
        this.mainModel = iMainModel;
    }

    @Override
    public void showData() {
        Log.d("Amit", "A");
        mainModel.showSomething();
    }

    @Override
    public void addPresenter(MainContract.IMainView mainView) {
    }

    @Override
    public void init() {
    }

    @Override
    public void removePresenter() {
    }

    @Override
    public MainContract.IMainView getMainView() {
        return null;
    }

}
