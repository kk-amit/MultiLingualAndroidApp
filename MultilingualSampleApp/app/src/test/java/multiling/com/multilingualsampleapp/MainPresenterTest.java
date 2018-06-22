package multiling.com.multilingualsampleapp;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import multiling.com.multilingualsampleapp.modules.Main.MainContract;
import multiling.com.multilingualsampleapp.modules.Main.MainModel;
import multiling.com.multilingualsampleapp.modules.Main.MainPresenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

/**
 * SplashPresenterTest - JUnit test for Main Screen Presenter.
 */

public class MainPresenterTest {

    @Mock
    private MainContract.IMainView mainView;
    private MainContract.IMainModel mainModel;
    private MainContract.IMainPresenter mainPresenter;
    @Mock
    private Context context;

    @Before
    public void before() {
        System.out.println(this + "\tbefore");
        context = mock(Context.class);
        mainView = mock(MainContract.IMainView.class);
        mainModel = new MainModel(context);
        mainPresenter = new MainPresenter(mainModel);
    }

    @After
    public void after() {
        System.out.println(this + "\tafter");
        mainView = null;
        mainModel = null;
        mainPresenter = null;
    }

    @Test
    public void testMainViewNull() {
        assertEquals(mainPresenter.getMainView(), null);
    }

    @Test
    public void testMainViewAdd() {
        mainPresenter.addPresenter(mainView);
        assertNotEquals(mainPresenter.getMainView(), null);
    }

    @Test
    public void testMainViewRemove() {
        mainPresenter.removePresenter();
        assertEquals(mainPresenter.getMainView(), null);
    }

    @Test
    public void testMainModelNull() {
        mainPresenter.removeMainModel();
        assertEquals(mainPresenter.getMainModel(), null);
    }

    @Test
    public void testMainModelAdd() {
        assertNotEquals(mainPresenter.getMainModel(), null);
    }

    @Test
    public void testStartBtnOperation() {
        mainPresenter.removePresenter();
        assertEquals(mainPresenter.getMainView(), null);
        mainPresenter.addPresenter(new MainContract.IMainView() {
            @Override
            public void onStartBtnClick() {
            }

            @Override
            public void onInit() {
            }
        });
        assertNotEquals(mainPresenter.getMainView(), null);
        mainPresenter.init();
        mainPresenter.startBtnClick();
    }


}
