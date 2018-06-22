package multiling.com.multilingualsampleapp.modules.localechange;


public class SelectedLanguagePresenter implements SelectedLanguageContract.ISelectedLanguagePresenter {

    private SelectedLanguageContract.ISelectedLanguageView selectedLanguageView;

    @Override
    public void addPresenter(SelectedLanguageContract.ISelectedLanguageView selectedLanguageView) {
        this.selectedLanguageView = selectedLanguageView;
    }

    @Override
    public void removePresenter() {
        this.selectedLanguageView = null;
    }

    @Override
    public void openSettingScreen() {
        if (selectedLanguageView != null) {
            selectedLanguageView.openSettingScreen();
        }
    }

    @Override
    public SelectedLanguageContract.ISelectedLanguageView getSelectedLanguageView() {
        return selectedLanguageView;
    }
}
