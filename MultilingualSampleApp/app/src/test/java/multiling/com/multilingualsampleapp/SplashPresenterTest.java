package multiling.com.multilingualsampleapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import multiling.com.multilingualsampleapp.modules.Splash.SplashContract;
import multiling.com.multilingualsampleapp.modules.Splash.SplashPresenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * SplashPresenterTest - JUnit test for Splash Screen Presenter.
 */

public class SplashPresenterTest {

    private SplashContract.ISplashView splashView;
    private SplashContract.ISplashPresenter splashPresenter;

    @Before
    public void before() {
        System.out.println(this + "\tbefore");
        splashView = new SplashView();
        splashPresenter = new SplashPresenter();
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
        assertEquals(splashPresenter.getSplashView(), null);
    }

    @Test
    public void testSplashViewAdd() {
        splashPresenter.addPresenter(splashView);
        assertNotEquals(splashPresenter.getSplashView(), null);
    }

    @Test
    public void testSplashInitTime() {
        final long time = System.currentTimeMillis();
        splashPresenter.addPresenter(() -> {
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
