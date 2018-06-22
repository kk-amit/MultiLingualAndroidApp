package multiling.com.multilingualsampleapp;

import android.content.Context;
import android.widget.CompoundButton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import multiling.com.multilingualsampleapp.modules.settings.LanguageSettingContract;
import multiling.com.multilingualsampleapp.modules.settings.LanguageSettingModel;
import multiling.com.multilingualsampleapp.modules.settings.LanguageSettingPresenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

public class LanguageSettingTest {

    @Mock
    private LanguageSettingContract.ILanguageSettingView languageSettingView;
    private LanguageSettingContract.ILanguageSettingModel languageSettingModel;
    @Mock
    private LanguageSettingContract.ILanguageSettingPresenter languageSettingPresenter;
    @Mock
    private Context context;

    @Before
    public void before() {
        System.out.println(this + "\tbefore");
        languageSettingView = mock(LanguageSettingContract.ILanguageSettingView.class);
        context = mock(Context.class);
        languageSettingModel = new LanguageSettingModel(context);
        languageSettingPresenter = new LanguageSettingPresenter(languageSettingModel);
    }

    @After
    public void after() {
        System.out.println(this + "\tafter");
        languageSettingView = null;
        languageSettingModel = null;
        languageSettingPresenter = null;
    }

    @Test
    public void testLanguageSettingNull() {
        assertEquals(languageSettingPresenter.getSettingLanguageView(), null);
    }

    @Test
    public void testLanguageSettingNotNull() {
        assertEquals(languageSettingPresenter.getSettingLanguageView(), null);
        languageSettingPresenter.addPresenter(languageSettingView);
        assertNotEquals(languageSettingPresenter.getSettingLanguageView(), null);
        languageSettingPresenter.removePresenter();
        assertEquals(languageSettingPresenter.getSettingLanguageView(), null);
    }

    @Test
    public void testLanguageSettingModelNotNull() {
        assertNotEquals(languageSettingPresenter.getSettingLanguageModel(), null);
    }

    @Test
    public void testLanguageSettingCheckView() {
        CompoundButton compoundButton = mock(CompoundButton.class);
        assertEquals(languageSettingPresenter.getSettingLanguageView(), null);
        LanguageSettingContract.ILanguageSettingView languageSettingView = new LanguageSettingContract.ILanguageSettingView() {
            @Override
            public void onSetCheckView(CompoundButton buttonView, String language) {
                assertNotEquals(languageSettingPresenter.getSettingLanguageView(), null);
                assertEquals(compoundButton, buttonView);
                assertEquals(language, Constants.LANG_HINDI);
                assertNotEquals(language, Constants.LANG_ENGLISH);
                assertNotEquals(languageSettingPresenter.getSettingLanguageView(), null);
                languageSettingPresenter.removePresenter();
                assertEquals(languageSettingPresenter.getSettingLanguageView(), null);
            }

            @Override
            public void onChangeLanguage() {
            }
        };
        languageSettingPresenter.addPresenter(languageSettingView);
        languageSettingPresenter.setCheckView(compoundButton, Constants.LANG_HINDI);
    }


    @Test
    public void testLanguageSettingSelectLocale() {
        LanguageSettingContract.ILanguageSettingModel languageSettingModel = (String selectedLang) -> {
            assertEquals(selectedLang, Constants.LANG_HINDI);
            assertNotEquals(selectedLang, Constants.LANG_ENGLISH);
        };
        LanguageSettingContract.ILanguageSettingPresenter languageSettingPresenter = new LanguageSettingPresenter(languageSettingModel);
        assertEquals(languageSettingPresenter.getSettingLanguageView(), null);
        LanguageSettingContract.ILanguageSettingView languageSettingView = new LanguageSettingContract.ILanguageSettingView() {
            @Override
            public void onSetCheckView(CompoundButton buttonView, String language) {
            }

            @Override
            public void onChangeLanguage() {
                assertNotEquals(languageSettingPresenter.getSettingLanguageView(), null);
                languageSettingPresenter.removePresenter();
                assertEquals(languageSettingPresenter.getSettingLanguageView(), null);
            }
        };
        languageSettingPresenter.addPresenter(languageSettingView);
        languageSettingPresenter.changeLanguage(Constants.LANG_HINDI);
    }

    @Test
    public void testLanguageSettingSelectLocaleModel() {
        assertEquals(languageSettingPresenter.getSettingLanguageView(), null);
        LanguageSettingContract.ILanguageSettingView languageSettingView = new LanguageSettingContract.ILanguageSettingView() {
            @Override
            public void onSetCheckView(CompoundButton buttonView, String language) {
            }

            @Override
            public void onChangeLanguage() {
                assertNotEquals(languageSettingPresenter.getSettingLanguageView(), null);
                languageSettingPresenter.removePresenter();
                assertEquals(languageSettingPresenter.getSettingLanguageView(), null);
            }
        };
        languageSettingPresenter.addPresenter(languageSettingView);
        languageSettingPresenter.changeLanguage(Constants.LANG_HINDI);
        languageSettingPresenter.getSettingLanguageModel().selectLanguage(Constants.LANG_HINDI);
    }


}
