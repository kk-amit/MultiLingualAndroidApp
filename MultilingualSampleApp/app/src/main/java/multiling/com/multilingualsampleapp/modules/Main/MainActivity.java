package multiling.com.multilingualsampleapp.modules.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import multiling.com.multilingualsampleapp.AppApplication;
import multiling.com.multilingualsampleapp.BaseActivity;
import multiling.com.multilingualsampleapp.R;
import multiling.com.multilingualsampleapp.modules.localechange.SelectedLanguageActivity;

public class MainActivity extends BaseActivity implements MainContract.IMainView {

    @Inject
    MainContract.IMainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enableToolBarHome(getResources().getString(R.string.str_title_activity_main));
        AppApplication.getInstance().getMyComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.addPresenter(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.removePresenter();
    }

    @Override
    public void onStartBtnClick() {
        Intent intent = new Intent(MainActivity.this, SelectedLanguageActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.init();
    }

    @Override
    public void onInit() {
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener((View v) -> {
            mainPresenter.startBtnClick();
        });
    }
}
