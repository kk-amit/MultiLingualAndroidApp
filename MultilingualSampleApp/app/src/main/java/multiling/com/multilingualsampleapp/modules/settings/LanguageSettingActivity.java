package multiling.com.multilingualsampleapp.modules.settings;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import javax.inject.Inject;

import multiling.com.multilingualsampleapp.AppApplication;
import multiling.com.multilingualsampleapp.BaseActivity;
import multiling.com.multilingualsampleapp.Constants;
import multiling.com.multilingualsampleapp.R;
import multiling.com.multilingualsampleapp.modules.Splash.SplashActivity;

public class LanguageSettingActivity extends BaseActivity implements LanguageSettingContract.ILanguageSettingView {

    private CheckBox chEnglish;
    private CheckBox chTamil;
    private CheckBox chHindi;
    private String selectedLang = "";

    @Inject
    LanguageSettingContract.ILanguageSettingPresenter languageSettingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_setting);
        enableToolBarHome(getResources().getString(R.string.str_title_activity_language_setting));
        AppApplication.getInstance().getMyComponent().inject(this);
        // Init the View
        chEnglish = findViewById(R.id.chEnglish);
        chTamil = findViewById(R.id.chTamil);
        chHindi = findViewById(R.id.chHindi);
        Button changeBtn = findViewById(R.id.changeBtn);
        chEnglish.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            if (isChecked) {
                languageSettingPresenter.setCheckView(buttonView, Constants.LANG_ENGLISH);
            } else {
                languageSettingPresenter.setCheckView(null, "");
            }
        });
        chTamil.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            if (isChecked) {
                languageSettingPresenter.setCheckView(buttonView, Constants.LANG_TAMIL);
            } else {
                languageSettingPresenter.setCheckView(null, "");
            }
        });
        chHindi.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            if (isChecked) {
                languageSettingPresenter.setCheckView(buttonView, Constants.LANG_HINDI);
            } else {
                languageSettingPresenter.setCheckView(null, "");
            }
        });
        changeBtn.setOnClickListener((View v) -> {
            if (TextUtils.isEmpty(selectedLang)) {
                Toast.makeText(getBaseContext(), getResources().getString(R.string.str_pls_select_lang), Toast.LENGTH_LONG).show();
            } else {
                languageSettingPresenter.changeLanguage(selectedLang);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        languageSettingPresenter.addPresenter(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        languageSettingPresenter.removePresenter();
    }


    private void unCheckAllView() {
        chEnglish.setChecked(false);
        chTamil.setChecked(false);
        chHindi.setChecked(false);
    }

    @Override
    public void onSetCheckView(CompoundButton buttonView, String selectedLang) {
        if (buttonView != null) {
            unCheckAllView();
            buttonView.setChecked(true);
        }
        this.selectedLang = selectedLang;
    }

    @Override
    public void onChangeLanguage() {
        Intent intent = new Intent(LanguageSettingActivity.this, SplashActivity.class);
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}
