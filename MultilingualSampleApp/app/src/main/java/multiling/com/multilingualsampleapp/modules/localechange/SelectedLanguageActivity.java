package multiling.com.multilingualsampleapp.modules.localechange;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import multiling.com.multilingualsampleapp.AppApplication;
import multiling.com.multilingualsampleapp.BaseActivity;
import multiling.com.multilingualsampleapp.R;
import multiling.com.multilingualsampleapp.modules.settings.LanguageSettingActivity;

public class SelectedLanguageActivity extends BaseActivity implements SelectedLanguageContract.ISelectedLanguageView {

    @Inject
    SelectedLanguageContract.ISelectedLanguagePresenter selectedLanguagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_language);
        enableToolBarHome(getResources().getString(R.string.str_title_activity_selected_language));
        AppApplication.getInstance().getMyComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        selectedLanguagePresenter.addPresenter(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        selectedLanguagePresenter.removePresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_setting) {
            selectedLanguagePresenter.openSettingScreen();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void openSettingScreen() {
        Intent intent = new Intent(SelectedLanguageActivity.this, LanguageSettingActivity.class);
        startActivity(intent);
    }
}
