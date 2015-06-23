package com.example.ania.projekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Ta klasa zawiera funkcje, które obs³uguj¹ aktywnosc widoku fitnes.xml
 *  Pola klasy:
 *   @p zb zawiera odwolania do metod obsugujacych baze danych.
 * @p czasT czas treningu
 * @p dataT data treningu
 * @p aktywnoscT rodzaj aktywnosci
 * @p notatka dodatkowe komentarze u¿ytownika
 * Created by Kapibara on 2015-06-02.
 * @autor Joana Wójcik
 */
public class Fitness extends Activity {
    ZarzadcaBazy zb;
    String czasT;
    String dataT;
    String notatka;
    String styl;
    /**
     * Metoda wywolujaca sie po uruchomieniu biezacej instancji. Przelacza na widok
     * fitnes.xml oraz steruje jego zachowaniem
     */
    protected void onCreate(Bundle savedInstanceState) {
        zb=new ZarzadcaBazy(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitnes);
        String aktywnoscT="fitness";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            czasT = extras.getString("czas");
            dataT = extras.getString("data");
        }
        else
        {
            final EditText czas1=(EditText)findViewById(R.id.Czas);
            final EditText data1=(EditText)findViewById(R.id.Data);
            czasT=czas1.getText().toString();
            dataT=data1.getText().toString();
        }
        Button b2=(Button)findViewById(R.id.AnulujFitness);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), rodzaj_Treningu.class);
                startActivity(i);
            }
        });
        Button b3=(Button)findViewById(R.id.ZapiszFitness);


        styl="";

        final double dystans=0;
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText not=(EditText)findViewById(R.id.notatkaFitness);
                EditText kat=(EditText)findViewById(R.id.kategoriaFitness);
                notatka=not.getText().toString();
                String kategoria=kat.getText().toString();
                String aktywnoscT="fitness";
                zb.dodajTrening(dataT, czasT, aktywnoscT,
                        dystans, kategoria, notatka, styl);
                Intent i = new Intent(getApplicationContext(), rodzaj_Treningu.class);
                startActivity(i);
            }
        });
    }
}
