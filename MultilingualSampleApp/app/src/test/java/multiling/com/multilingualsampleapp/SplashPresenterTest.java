package multiling.com.multilingualsampleapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import multiling.com.multilingualsampleapp.modules.Main.MainContract;
import multiling.com.multilingualsampleapp.modules.Splash.SplashContract;
import multiling.com.multilingualsampleapp.modules.Splash.SplashPresenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * SplashPresenterTest - JUnit test for Splash Screen Presenter.
 */

public class SplashPresenterTest {

    private SplashContract.ISplashView splashView;
    private SplashContract.ISplashPresenter splashPresenter;
    private SplashContract.ISplashModel splashModel;
    @Before
    public void before() {
        System.out.println(this + "\tbefore");
        splashView = mock(SplashContract.ISplashView.class);
        splashModel = mock(SplashContract.ISplashModel.class);
        splashPresenter = new SplashPresenter(splashModel);
    }

    @After
    public void after() {
        System.out.println(this + "\tafter");
        splashPresenter.removePresenter();
        splashView = null;
        splashPresenter = null;
    }


    @Test
    public void testSplashViewNull() {
        splashPresenter.addPresenter(null);
        assertEquals(splashPresenter.getSplashView(), null);
    }

    @Test
    public void testSplashModelNotNull() {
        splashPresenter.addPresenter(null);
        assertNotEquals(splashPresenter.getSplashModel(), null);
    }

    @Test
    public void testSplashViewAdd() {
        splashPresenter.addPresenter(splashView);
        assertNotEquals(splashPresenter.getSplashView(), null);
    }

    @Test
    public void testSplashInitTime() {
        final long time = System.currentTimeMillis();
        splashPresenter.addPresenter((String language) -> {
            long completedTime = System.currentTimeMillis();
            assertTrue(time + 3 == completedTime);
        });
        splashPresenter.init();
    }

    @Test
    public void testSplashViewRemove() {
        splashPresenter.removePresenter();
        assertEquals(splashPresenter.getSplashView(), null);
    }
}
