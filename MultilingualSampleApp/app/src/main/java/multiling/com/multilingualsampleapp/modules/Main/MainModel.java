package multiling.com.multilingualsampleapp.modules.Main;

import android.content.Context;
import android.widget.Toast;

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
        Toast.makeText(context, "Hello World", Toast.LENGTH_LONG).show();
    }
}
