package multiling.com.multilingualsampleapp.modules.Main;

/**
 * MainContract.
 */

public class MainContract {

    public interface IMainView {
        void onStartBtnClick();

        void onInit();
    }

    public interface IMainPresenter {

        void addPresenter(MainContract.IMainView mainView);

        void removePresenter();

        MainContract.IMainView getMainView();

        void startBtnClick();

        void removeMainModel();

        MainContract.IMainModel getMainModel();

        void init();
    }

    public interface IMainModel {
        void showSomething();
    }
}
