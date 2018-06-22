package multiling.com.multilingualsampleapp.modules.localechange;

public class SelectedLanguageContract {

    public interface ISelectedLanguageView {
        void openSettingScreen();
    }

    public interface ISelectedLanguagePresenter {
        void addPresenter(SelectedLanguageContract.ISelectedLanguageView selectedLanguageView);

        void removePresenter();

        void openSettingScreen();
    }
}
