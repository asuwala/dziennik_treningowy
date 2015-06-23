package com.example.ania.projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Kapibara on 2015-06-09.
 */
public class ZarzadcaBazy extends SQLiteOpenHelper {
    public ZarzadcaBazy(Context context) {
        super(context, "baza.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table wymiary(" + "id integer primary key autoincrement, " + "dataZapisu datetime not null, " +
                "wzrost double, " + "waga double, " + "obKlatki double, " + "obTalii double, " + "obBioder double, " + "obUda double);" + "");
        db.execSQL("create table trening(" + "id integer primary key autoincrement, " + "czasTreningu time not null, " + "rodzajTreningu string not null, " + "dystans double, "
                + "kategoria string, " + "notatka string, " + "styl string, " + "data datetime);" + "");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersin, int newVersion )
    {

        db = getWritableDatabase();
        db.execSQL("drop table if exists wymiary;");
        db.execSQL("drop table if exists trening;");
        onCreate(db);
    };
    //metoda zapisuje wymiar uzytkownika wraz z aktualna data zapisu
    public void dodajWymiar(double wzrost, double waga, double obKlatki,double obTalii,
                            double obBioder, double obUda) throws Exception {
        try {

            SQLiteDatabase db = getWritableDatabase();
            ContentValues wartosc = new ContentValues();
            //pobietanie aktualnej daty
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String strDate = sdf.format(c.getTime());
            wartosc.put("dataZapisu", strDate);
            wartosc.put("wzrost", wzrost);
            wartosc.put("waga", waga);
            wartosc.put("obKlatki", obKlatki);
            wartosc.put("obTalii", obTalii);
            wartosc.put("obBioder", obBioder);
            wartosc.put("obUda", obUda);
            db.insertOrThrow("wymiary", null, wartosc);
            db.close();
        }
        catch (SQLException ex)
        {
          System.out.print(ex.getMessage());
        }
    }
    // dodawanie treningu
    public void dodajTrening(String data, String czas, String rodzajTreningu,
                             double Dystans, String Kategoria, String notatka, String Styl){
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues wartosc = new ContentValues();
            wartosc.put("data", data);
            wartosc.put("czasTreningu", czas);
            wartosc.put("rodzajTreningu", rodzajTreningu);
            wartosc.put("dystans", Dystans);
            wartosc.put("kategoria", Kategoria);
            wartosc.put("styl", Styl);
            wartosc.put("notatka", notatka);
            db.insertOrThrow("trening", null, wartosc);
            db.close();


        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        }

    }
    public void usunTrening(){
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.delete("trening", null, null);
            db.close();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        }

    }

    // pobranie danych z bazy "wymiary"
    public Cursor dajWymiary(){
        // "klolumny" to klumny jakie chcemy odczytać z bazy danych w podanej kolejności
        String[] kolumny ={"dataZapisu","waga", "obKlatki", "obTalii", "obBioder", "obUda"};
        // pobranie uchwytu do bazy
        SQLiteDatabase db = getReadableDatabase();
        // pobieranie danych metoda query
        Cursor kursor = db.query("wymiary",kolumny,null,null,null,null,null);
        return  kursor;
    }


    // pobranie danych z bazy "trening"
    public Cursor dajTreningi() {
        // "klolumny" to klumny jakie chcemy odczytać z bazy danych w podanej kolejności
        String[] kolumny = {"data","czasTreningu","rodzajTreningu","dystans", "kategoria","styl","notatka"};
        // pobranie uchwytu do bazy
        SQLiteDatabase db = getReadableDatabase();
        // pobieranie danych metoda query
        Cursor kursor = db.query("trening",kolumny,null,null,null,null,"data");
        return kursor;


    }
}
