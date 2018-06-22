package multiling.com.multilingualsampleapp;

import android.content.Context;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import multiling.com.multilingualsampleapp.modules.SelectLanguage.SelectLanguageContract;
import multiling.com.multilingualsampleapp.modules.SelectLanguage.SelectLanguageContractModel;
import multiling.com.multilingualsampleapp.modules.SelectLanguage.SelectLanguageContractPresenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

public class SelectLanguagePresenterTest {

    @Mock
    private SelectLanguageContract.ISelectLanguageContractView selectLanguageContractView;
    private SelectLanguageContract.ISelectLanguageContractModel selectLanguageContractModel;
    private SelectLanguageContract.ISelectLanguageContractPresenter selectLanguageContractPresenter;
    @Mock
    private Context context;

    @Before
    public void before() {
        System.out.println(this + "\tbefore");
        context = mock(Context.class);
        selectLanguageContractView = mock(SelectLanguageContract.ISelectLanguageContractView.class);
        selectLanguageContractModel = new SelectLanguageContractModel(context);
        selectLanguageContractPresenter = new SelectLanguageContractPresenter(selectLanguageContractModel);
    }

    @After
    public void after() {
        System.out.println(this + "\tafter");
        selectLanguageContractView = null;
        selectLanguageContractModel = null;
        selectLanguageContractPresenter = null;
    }

    @Test
    public void testSelectLanguageViewNull() {
        assertEquals(selectLanguageContractPresenter.getSelectedLanguageView(), null);
    }

    @Test
    public void testSelectLanguageNonViewNull() {
        selectLanguageContractPresenter.addPresenter(new SelectLanguageContract.ISelectLanguageContractView() {
            @Override
            public void onInit() {
            }

            @Override
            public void onShowVisibleTick(View view) {
            }

            @Override
            public void onLanguageSelected() {
            }
        });
        assertNotEquals(selectLanguageContractPresenter.getSelectedLanguageView(), null);
        selectLanguageContractPresenter.removePresenter();
    }

    @Test
    public void testSelectLanguageModelNonNull() {
        assertNotEquals(selectLanguageContractPresenter.getSelectedLanguageModel(), null);
    }

    @Test
    public void testSelectLanguageTestInit() {
        SelectLanguageContract.ISelectLanguageContractView selectLanguageContractView = new SelectLanguageContract.ISelectLanguageContractView() {
            @Override
            public void onInit() {
                assertNotEquals(selectLanguageContractPresenter.getSelectedLanguageView(), null);
                selectLanguageContractPresenter.removePresenter();
                assertEquals(selectLanguageContractPresenter.getSelectedLanguageView(), null);
            }

            @Override
            public void onShowVisibleTick(View view) {
            }

            @Override
            public void onLanguageSelected() {
            }
        };
        selectLanguageContractPresenter.addPresenter(selectLanguageContractView);
        selectLanguageContractPresenter.init();
    }

    @Test
    public void testSelectLanguageModelTestInit() {
        SelectLanguageContract.ISelectLanguageContractView selectLanguageContractView = new SelectLanguageContract.ISelectLanguageContractView() {
            @Override
            public void onInit() {
            }

            @Override
            public void onShowVisibleTick(View view) {
                assertNotEquals(view, null);
                assertNotEquals(selectLanguageContractPresenter.getSelectedLanguageView(), null);
                selectLanguageContractPresenter.removePresenter();
                assertEquals(selectLanguageContractPresenter.getSelectedLanguageView(), null);
            }

            @Override
            public void onLanguageSelected() {
            }
        };
        selectLanguageContractPresenter.addPresenter(selectLanguageContractView);
        View view = mock(View.class);
        selectLanguageContractPresenter.showVisibleTick(view);
    }

    @Test
    public void testSelectLanguageModelLanguageChange() {
        SelectLanguageContract.ISelectLanguageContractView selectLanguageContractView = new SelectLanguageContract.ISelectLanguageContractView() {
            @Override
            public void onInit() {
            }

            @Override
            public void onShowVisibleTick(View view) {
            }

            @Override
            public void onLanguageSelected() {
                assertNotEquals(selectLanguageContractPresenter.getSelectedLanguageView(), null);
                assertEquals(LocaleManager.getLanguage(context), null);
                selectLanguageContractPresenter.removePresenter();
                assertEquals(selectLanguageContractPresenter.getSelectedLanguageView(), null);
            }
        };
        selectLanguageContractPresenter.addPresenter(selectLanguageContractView);
        selectLanguageContractPresenter.selectNewLanguage(Constants.LANG_HINDI);
    }

}

