package multiling.com.multilingualsampleapp.modules.Splash;

/**
 * SplashContract - Splash Contract.
 */

public class SplashContract {

    public interface ISplashView {

        void onSplashComplete(String language);

    }

    public interface ISplashPresenter {
        void addPresenter(ISplashView splashView);

        void init();

        void removePresenter();

        SplashContract.ISplashView getSplashView();

        SplashContract.ISplashModel getSplashModel();
    }

    public interface ISplashModel {
        String getSelectedLanguage();
    }
}
