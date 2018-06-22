package multiling.com.multilingualsampleapp.modules.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.Objects;

import javax.inject.Inject;

import multiling.com.multilingualsampleapp.AppApplication;
import multiling.com.multilingualsampleapp.BaseActivity;
import multiling.com.multilingualsampleapp.R;
import multiling.com.multilingualsampleapp.modules.Main.MainActivity;
import multiling.com.multilingualsampleapp.modules.SelectLanguage.SelectLanguageActivity;

public class SplashActivity extends BaseActivity implements SplashContract.ISplashView {

    @Inject
    SplashContract.ISplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();
        AppApplication.getInstance().getMyComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mSplashPresenter.addPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSplashPresenter.init();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSplashPresenter.removePresenter();
    }

    @Override
    public void onSplashComplete(String language) {
        if (TextUtils.isEmpty(language)) {
            Intent i = new Intent(SplashActivity.this, SelectLanguageActivity.class);
            startActivity(i);
        } else {
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
        }
        // close this activity
        finish();
    }
}
