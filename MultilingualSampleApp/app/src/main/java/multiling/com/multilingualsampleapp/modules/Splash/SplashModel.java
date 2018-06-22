package multiling.com.multilingualsampleapp.modules.Splash;

import android.content.Context;

import multiling.com.multilingualsampleapp.Constants;
import multiling.com.multilingualsampleapp.Utility;

public class SplashModel implements SplashContract.ISplashModel {

    private Context context;

    public SplashModel(Context context) {
        this.context = context;
    }

    @Override
    public String getSelectedLanguage() {
        return Utility.retrieveString(context, Constants.ALREADY_LANGUAGE_SELECTED);
    }
}
