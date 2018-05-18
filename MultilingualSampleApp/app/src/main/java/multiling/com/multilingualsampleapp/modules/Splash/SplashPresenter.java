package multiling.com.multilingualsampleapp.modules.Splash;

import android.os.Handler;

/**
 * SplashPresenter.
 */

public class SplashPresenter implements SplashContract.ISplashPresenter {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    private SplashContract.ISplashView mSplashView;

    @Override
    public SplashContract.ISplashView getSplashView() {
        return mSplashView;
    }

    @Override
    public void addPresenter(SplashContract.ISplashView splashView) {
        mSplashView = splashView;
    }

    @Override
    public void init() {
        new Handler().postDelayed(() -> {
            if (mSplashView != null) {
                mSplashView.onSplashComplete();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void removePresenter() {
        mSplashView = null;
    }
}
