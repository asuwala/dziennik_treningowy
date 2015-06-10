package com.example.ania.projekt;

import android.content.ContentValues;
import android.content.Context;
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
        db.execSQL("create table wymiary(" + "id integer primary key autoincrement, " + "dataZapisu datetime, " +
                "wzrost double, " + "waga double, " + "obKlatki double, " + "obTalii double, " + "obBioder double, " + "obUda double);" + "");
        db.execSQL("create table trening(" + "id integer primary key autoincrement, " + "czasTreningu time, " + "rodzajTreningu string, " + "dystans double, "
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
                            double obBioder, double obUda)
    {
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
        catch (Exception e)
        {
        }
    }
    // dodawanie treningu
    public void dodajTrening(String data, String czas, String rodzajTreningu,
                             double Dystans, String Kategoria, String notatka, String Styl){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosc = new ContentValues();
        wartosc.put("data", data);
        wartosc.put("czasTreningu", czas);
        wartosc.put("rodzajTreningu", rodzajTreningu);
        wartosc.put("dystans", Dystans);
        wartosc.put("kategoria", Kategoria);
        wartosc.put("styl", Styl);
        wartosc.put("notatka",notatka);
        db.insertOrThrow("trening", null, wartosc);



    }
    public void usunTrening(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("trening",null, null);
    }
}
