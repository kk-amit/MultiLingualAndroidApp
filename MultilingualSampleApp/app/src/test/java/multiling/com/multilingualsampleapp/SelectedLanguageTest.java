package multiling.com.multilingualsampleapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import multiling.com.multilingualsampleapp.modules.localechange.SelectedLanguageContract;
import multiling.com.multilingualsampleapp.modules.localechange.SelectedLanguagePresenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

public class SelectedLanguageTest {

    private SelectedLanguageContract.ISelectedLanguagePresenter selectedLanguagePresenter;
    @Mock
    private SelectedLanguageContract.ISelectedLanguageView selectedLanguageView;


    @Before
    public void before() {
        System.out.println(this + "\tbefore");
        selectedLanguageView = mock(SelectedLanguageContract.ISelectedLanguageView.class);
        selectedLanguagePresenter = new SelectedLanguagePresenter();
    }

    @After
    public void after() {
        System.out.println(this + "\tafter");
        selectedLanguagePresenter = null;
        selectedLanguageView = null;
    }

    @Test
    public void testSelectedLanguageNull() {
        assertEquals(selectedLanguagePresenter.getSelectedLanguageView(), null);
    }

    @Test
    public void testSelectedLanguageNotNull() {
        selectedLanguagePresenter.addPresenter(selectedLanguageView);
        assertNotEquals(selectedLanguagePresenter.getSelectedLanguageView(), null);
    }

    @Test
    public void testSelectedLanguageOpenSettings() {
        SelectedLanguageContract.ISelectedLanguageView selectedLanguageView = () -> {
            assertNotEquals(selectedLanguagePresenter.getSelectedLanguageView(), null);
            selectedLanguagePresenter.removePresenter();
            assertEquals(selectedLanguagePresenter.getSelectedLanguageView(), null);
        };
        assertEquals(selectedLanguagePresenter.getSelectedLanguageView(), null);
        selectedLanguagePresenter.addPresenter(selectedLanguageView);
        assertNotEquals(selectedLanguagePresenter.getSelectedLanguageView(), null);
        selectedLanguagePresenter.openSettingScreen();
    }

}
