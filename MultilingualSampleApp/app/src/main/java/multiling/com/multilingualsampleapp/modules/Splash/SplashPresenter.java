package multiling.com.multilingualsampleapp.modules.Splash;

import android.os.Handler;

/**
 * SplashPresenter.
 */

public class SplashPresenter implements SplashContract.ISplashPresenter {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    private SplashContract.ISplashView mSplashView;
    private SplashContract.ISplashModel splashModel;

    public SplashPresenter(SplashContract.ISplashModel iSplashModel) {
        this.splashModel = iSplashModel;
    }

    @Override
    public SplashContract.ISplashView getSplashView() {
        return mSplashView;
    }

    @Override
    public SplashContract.ISplashModel getSplashModel() {
        return splashModel;
    }

    @Override
    public void addPresenter(SplashContract.ISplashView splashView) {
        mSplashView = splashView;
    }

    @Override
    public void init() {
        new Handler().postDelayed(() -> {
            if (mSplashView != null && splashModel != null) {
                mSplashView.onSplashComplete(splashModel.getSelectedLanguage());
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void removePresenter() {
        mSplashView = null;
    }
}
