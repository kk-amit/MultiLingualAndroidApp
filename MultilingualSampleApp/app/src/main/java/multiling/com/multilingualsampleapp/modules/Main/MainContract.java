package multiling.com.multilingualsampleapp.modules.Main;

/**
 * MainContract.
 */

public class MainContract {

    public interface IMainView {

    }

    public interface IMainPresenter {
        void showData();

        void addPresenter(MainContract.IMainView mainView);

        void init();

        void removePresenter();

        MainContract.IMainView getMainView();
    }

    public interface IMainModel {
        void showSomething();
    }
}
