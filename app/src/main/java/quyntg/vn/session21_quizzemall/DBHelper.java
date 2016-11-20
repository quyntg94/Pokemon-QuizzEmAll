package quyntg.vn.session21_quizzemall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giaqu on 11/20/2016.
 */

public class DBHelper extends SQLiteAssetHelper {
    private final static String DB_NAME = "pokemon.db";
    private final static int DB_VERSION = 1;

    //===================QUOTE==================================
    private static final String POKEMON_TABLE_NAME = "pokemon";
    private static final String POKEMON_ID = "id";
    private static final String POKEMON_NAME = "name";
    private static final String POKEMON_TAG = "tag";
    private static final String POKEMON_GEN = "gen";
    private static final String POKEMON_IMG = "img";
    private static final String POKEMON_COLOR = "color";
    private static final String[] POKEMON_COLUMNS =
            new String[]{
                    POKEMON_ID,
                    POKEMON_NAME,
                    POKEMON_TAG,
                    POKEMON_GEN,
                    POKEMON_IMG,
                    POKEMON_COLOR
            };
    private static final String TAG = DBHelper.class.toString();

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void insert(Pokemon pokemon) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(POKEMON_NAME, pokemon.getName());
        contentValues.put(POKEMON_TAG, pokemon.getTag());
        contentValues.put(POKEMON_GEN, pokemon.getGen());
        contentValues.put(POKEMON_IMG, pokemon.getImg());
        contentValues.put(POKEMON_COLOR, pokemon.getColor());
        long id = db.insert(POKEMON_TABLE_NAME, null, contentValues);
        pokemon.setId((int) id);
        db.close();
    }

    public List<Pokemon> selectAllPokemon() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
      /*
      * String table, String[] columns, String selection,
          String[] selectionArgs, String groupBy, String having,
          String orderBy
      * */
        Cursor cursor = db.query(POKEMON_TABLE_NAME,
                POKEMON_COLUMNS,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            pokemons.add(create(cursor));
        }
        cursor.close();
        db.close();
        return pokemons;
    }

    public Pokemon selectRandomPokemon() {
        Pokemon pokemon = null;
        SQLiteDatabase db = getReadableDatabase();
      /*
      * String table, String[] columns, String selection,
          String[] selectionArgs, String groupBy, String having,
          String orderBy, String limit
      * */
        Cursor cursor = db.query(POKEMON_TABLE_NAME,
                POKEMON_COLUMNS,
                null,
                null,
                null,
                null,
                "RANDOM()",
                "1"
        );
        if(cursor.moveToNext()) {
            pokemon = create(cursor);
            cursor.close();
            db.close();
            return pokemon;
        }else{
            return null;
        }
    }

    private Pokemon create(Cursor cursor){
        int id = cursor.getInt(cursor.getColumnIndex(POKEMON_ID));
        String name = cursor.getString(cursor.getColumnIndex(POKEMON_NAME));
        String tag = cursor.getString(cursor.getColumnIndex(POKEMON_TAG));
        int gen = cursor.getInt(cursor.getColumnIndex(POKEMON_GEN));
        String img = cursor.getString(cursor.getColumnIndex(POKEMON_IMG));
        String color = cursor.getString(cursor.getColumnIndex(POKEMON_COLOR));
        Pokemon pokemon = new Pokemon(id, name, tag, gen, img, color);
        Log.d("db", pokemon.toString());
        return pokemon;
    }

    private static DBHelper instance;

    public static DBHelper getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DBHelper(context);
    }
}
