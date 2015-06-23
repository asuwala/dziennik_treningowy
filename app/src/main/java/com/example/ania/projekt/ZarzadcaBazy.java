package com.example.ania.projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Zawiera logikę sterujacą tworzeniem oraz modyfikowaniem bazy danych
 * Created by Kapibara on 2015-06-09.
 * @author Joanna Wójcik
 */
public class ZarzadcaBazy extends SQLiteOpenHelper {
    public ZarzadcaBazy(Context context) {
        super(context, "baza.db", null, 1);
    }
    @Override
    /**
     * Tworzy tabele bazie danych @p db:
     * tabela wymiary zawierajaca takie pola jak id, dataZapisu, wzrost, waga, obKlatki, obBioder,
     * obUda;
     * tabela trening zawierajaca takie pola jak id, czasTreningu, rodzajTreningu, dystans,
     * kategoria, notatka, styl data
     */
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table wymiary(" + "id integer primary key autoincrement, " + "dataZapisu datetime not null, " +
                "wzrost double, " + "waga double, " + "obKlatki double, " + "obTalii double, " + "obBioder double, " + "obUda double);" + "");
        db.execSQL("create table trening(" + "id integer primary key autoincrement, " + "czasTreningu time not null, " + "rodzajTreningu string not null, " + "dystans double, "
                + "kategoria string, " + "notatka string, " + "styl string, " + "data datetime);" + "");

    }

    @Override
    /**
     * Aktualizuje bazę danych do nowej wersji
     * @param db aktualizowana baza
     * @param oldVersion numer starej wersji bazy
     * @param newVersion numer nowej wersji bazy
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersin, int newVersion )
    {

        db = getWritableDatabase();
        db.execSQL("drop table if exists wymiary;");
        db.execSQL("drop table if exists trening;");
        onCreate(db);
    };
    //metoda zapisuje wymiar uzytkownika wraz z aktualna data zapisu

    /**
     * Dodaje nowy rekord w bazie danych do tabeli wymiary, w której zapisane są wymiary użytkownika
     * @param wzrost wzrost danej osoby
     * @param waga waga danej osoby
     * @param obKlatki obwód klatki piersiowej
     * @param obTalii obwód talii
     * @param obBioder obwód bioder
     * @param obUda obwód uda
     * @throws Exception
     */
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

    /**
     * Dodaje nowy rekord do tabeli trening w bazie danych z nastepującymi polami:
     * @param data data treningu
     * @param czas czas treningu
     * @param rodzajTreningu rodzaj treningu
     * @param Dystans przebyty dystans
     * @param Kategoria kategoria treningu
     * @param notatka dodatkowy komentarz dot treningu
     * @param Styl styl plywania
     */
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

    /**
     * usuwa wszystkie rekordy znajdujace sie w tabeli trening w bazie danych
     */
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
}
