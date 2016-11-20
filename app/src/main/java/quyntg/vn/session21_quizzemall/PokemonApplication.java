package quyntg.vn.session21_quizzemall;

import android.app.Application;
import android.util.Log;

/**
 * Created by giaqu on 11/20/2016.
 */

public class PokemonApplication extends Application{

    private static final String TAG = PokemonApplication.class.toString();

    @Override
    public void onCreate() {
        super.onCreate();

        DBHelper.init(this);

        Log.d(TAG,"Inserted");
        Log.d(TAG,DBHelper.getInstance().selectRandomPokemon().toString()+"");

    }
}
