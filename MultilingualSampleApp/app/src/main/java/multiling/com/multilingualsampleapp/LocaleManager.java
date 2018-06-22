package multiling.com.multilingualsampleapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;

import java.util.Locale;

public class LocaleManager {

    public static Context setLocale(Context c) {
        return updateResources(c, getLanguage(c));
    }

    public static void setNewLocale(Context c, String language) {
        persistLanguage(c, language);
        updateResources(c, language);
    }

    public static String getLanguage(Context c) {
        String language = Utility.retrieveString(c, Constants.LANGUAGE_KEY);
        if (!TextUtils.isEmpty(language)) {
            return language;
        }
        return Constants.LANG_ENGLISH;
    }

    @SuppressLint("ApplySharedPref")
    private static void persistLanguage(Context c, String language) {
        Utility.saveString(c, Constants.LANGUAGE_KEY, language);
    }

    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources res = context.getResources();
        if (res != null) {
            Configuration config = new Configuration(res.getConfiguration());
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
            return context;
        }
        return context;
    }
}
