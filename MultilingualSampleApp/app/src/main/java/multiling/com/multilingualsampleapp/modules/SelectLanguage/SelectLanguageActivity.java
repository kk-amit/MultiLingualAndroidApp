package multiling.com.multilingualsampleapp.modules.SelectLanguage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import javax.inject.Inject;

import multiling.com.multilingualsampleapp.AppApplication;
import multiling.com.multilingualsampleapp.BaseActivity;
import multiling.com.multilingualsampleapp.Constants;
import multiling.com.multilingualsampleapp.R;
import multiling.com.multilingualsampleapp.modules.Main.MainActivity;

public class SelectLanguageActivity extends BaseActivity implements SelectLanguageContract.ISelectLanguageContractView {

    private ImageView englishTick;
    private ImageView tamilTick;
    private ImageView hindiTick;

    private String language = "";

    @Inject
    SelectLanguageContract.ISelectLanguageContractPresenter selectLanguageContractPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        enableToolBarHome(getResources().getString(R.string.str_title_activity_select_language));
        AppApplication.getInstance().getMyComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        selectLanguageContractPresenter.addPresenter(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        selectLanguageContractPresenter.removePresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        selectLanguageContractPresenter.init();
    }

    @Override
    public void onInit() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LinearLayout mEnglishPanel = findViewById(R.id.englishPanel);
        LinearLayout mTamilPanel = findViewById(R.id.tamilPanel);
        LinearLayout mHindiPanel = findViewById(R.id.hindiPanel);
        englishTick = findViewById(R.id.englishTick);
        tamilTick = findViewById(R.id.tamilTick);
        hindiTick = findViewById(R.id.hindiTick);
        Button proceedBtn = findViewById(R.id.proceedBtn);
        mTamilPanel.setOnClickListener((View v) -> {
            selectLanguageContractPresenter.showVisibleTick(tamilTick);
            language = Constants.LANG_TAMIL;
        });
        mEnglishPanel.setOnClickListener((View v) -> {
            selectLanguageContractPresenter.showVisibleTick(englishTick);
            language = Constants.LANG_ENGLISH;
        });
        mHindiPanel.setOnClickListener((View v) -> {
            selectLanguageContractPresenter.showVisibleTick(hindiTick);
            language = Constants.LANG_HINDI;
        });
        proceedBtn.setOnClickListener((View v) -> {
            selectLanguageContractPresenter.selectNewLanguage(language);
        });
    }

    @Override
    public void onShowVisibleTick(View view) {
        englishTick.setVisibility(View.INVISIBLE);
        tamilTick.setVisibility(View.INVISIBLE);
        hindiTick.setVisibility(View.INVISIBLE);
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLanguageSelected() {
        Intent intent = new Intent(SelectLanguageActivity.this, MainActivity.class);
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
