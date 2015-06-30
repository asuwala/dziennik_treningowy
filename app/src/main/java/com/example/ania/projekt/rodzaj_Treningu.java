package com.example.ania.projekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Klasa zawierajaca metody i funkcje sterujace zachowaniem i walidacja danych widoku dodawanie_treningu
 * Pola klasy:
 * @p zb zawiera odwolania do metod obsugujacych baze danych
 * @p i koordynuje przelaczanie pomiedzy poszczegolnymi widokami
 * @p aktywnosc zawiera rodzaj aktywnosci sportowej
 * Created by Kapibara on 2015-06-02.
 * @autor Joanna W�jcik
 */
public class rodzaj_Treningu extends Activity {
    ZarzadcaBazy zb;
    public Intent i;
    String aktywnosc;
   // walidacjaDanych walidacja;
    @Override
/**
 * Metoda dodawanie_trenngu wywolujaca sie po uruchomieniu biezacej instancji. Przelacza na widok
 * dodawanie.xml oraz steruje jego zachowaniem.
 */
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodawanie_terningu);
        final EditText dataE=(EditText)findViewById(R.id.Data);
        final EditText czasE=(EditText)findViewById(R.id.Czas);

        dataE.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // code to execute when EditText loses focus
                    boolean e=walidacjaDanych.walidacjaDaty(dataE.getText().toString());
                    if(!e)
                    {
                        dataE.setText("");
                    }

                }
            }
        });
        czasE.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // code to execute when EditText loses focus
                    boolean e=walidacjaDanych.walidacjaCzasu(czasE.getText().toString());
                    if(!e)
                    {
                        czasE.setText("");
                    }

                }
            }
        });


        zb=new ZarzadcaBazy(this);

        Button b1;
        Button b2=(Button)findViewById(R.id.anuluj);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
            b1=(Button)

            findViewById(R.id.szczegoly);

            b1.setOnClickListener(new View.OnClickListener()

                                  {
                                      public void onClick(View v) {
                                          final EditText czas = (EditText) findViewById(R.id.Czas);
                                          final EditText data = (EditText) findViewById(R.id.Data);

                                          String kat = ((Spinner) findViewById(R.id.rodzajTrening)).getSelectedItem().toString();
                                          if (kat.equals("Fitness") == true) {
                                              i = new Intent(getApplicationContext(), Fitness.class);
                                              aktywnosc = "fitness";
                                          }
                                          if (kat.equals("Bieg") == true) {
                                              i = new Intent(getApplicationContext(), Bieg.class);

                                          }
                                          if (kat.equals("Plywanie") == true) {
                                              i = new Intent(getApplicationContext(), Plywanie.class);


                                          }
                                          i.putExtra("czas", czas.getText().toString());
                                          i.putExtra("data", data.getText().toString());
                                          startActivity(i);
                                      }
                                  }
            );

        Button b3 = (Button) findViewById(R.id.Zapisz);
            b3.setOnClickListener(new View.OnClickListener()

                                  {
                                      public void onClick(View v) {
                                          try {
                                          final EditText czas = (EditText) findViewById(R.id.Czas);
                                          final EditText data = (EditText) findViewById(R.id.Data);
                                          String czasT = czas.getText().toString();
                                          String dataT = data.getText().toString();
                                              if( czasE.length()==0 || dataT.length()==0)
                                              {

                                                  throw new Exception("puste dane");
                                              }

                                          String kat = ((Spinner) findViewById(R.id.rodzajTrening)).getSelectedItem().toString();

                                              zb.dodajTrening(dataT, czasT, kat,
                                                      0, "", "", "");
                                              Toast.makeText(getApplicationContext(), "zapisano nowy rekord do bazy", Toast.LENGTH_LONG).show();
                                          }
                                          catch (Exception e)
                                          {
                                              Toast.makeText(getApplicationContext(), "Blad podczas zapisu. Sprawdz, czy wpisales date i czas treningu", Toast.LENGTH_LONG).show();
                                          }

                                      }
                                  }
            );

    }
}