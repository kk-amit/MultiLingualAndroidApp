package multiling.com.multilingualsampleapp.modules.Main;

import android.content.Context;

/**
 * MainModel.
 */

public class MainModel implements MainContract.IMainModel {

    private Context context;

    public MainModel(Context context) {
        this.context = context;
    }

    @Override
    public void showSomething() {
    }


}
