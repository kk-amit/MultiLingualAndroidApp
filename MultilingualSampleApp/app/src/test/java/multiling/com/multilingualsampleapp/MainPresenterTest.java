package multiling.com.multilingualsampleapp;

import android.content.Context;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import multiling.com.multilingualsampleapp.modules.Main.MainContract;
import multiling.com.multilingualsampleapp.modules.Main.MainModel;
import multiling.com.multilingualsampleapp.modules.Main.MainPresenter;

import static org.mockito.Mockito.mock;

/**
 * SplashPresenterTest - JUnit test for Splash Screen Presenter.
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
        mainModel = new MainModel(context);
        mainPresenter = new MainPresenter(mainModel);
        context = mock(Context.class);
        mainView = mock(MainContract.IMainView.class);
    }

    @After
    public void after() {
        System.out.println(this + "\tafter");
        mainView = null;
        mainModel = null;
        mainPresenter = null;
    }

    @Test
    public void getDataTest() {
        Assert.assertNotEquals(1, 2);
    }
}
