package com.example.ania.projekt;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Class AktualizacjaWymiarowActivity odpowiedzialna za aktualizacje wymiarów użytkownika.
 * Ustawia widok activity_aktualizacja_wymiarow.xml jako jedna z części głównego interfejsu
 * użytkownika oraz  obsługuje jego aktywność.
 * Created by Ania on 2015-06-02.
 * @author Anna Suwała
 */
public class AktualizacjaWymiarowActivity extends Activity {

    // stworzenie obiektu zarządcy bazy danych
    ZarzadcaBazy zb;

    /** Metoda wywolujaca sie po uruchomieniu biezacej instancji. Uruchamia widok
     *  activity_aktualizacja_wymiarow.xml slużacy do aktualizacji wymiarów ciała uzytkownika
     *  oraz zapisania tych danych do bazy danych. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktualizacja_wymiarow);
        zb=new ZarzadcaBazy(this);
        /** Przycisk btn_Zapisz_wymiary po kliknięciu, którego wprowadzone
         *  wymiary zostają zapisane do bazy*/
        Button cliButton = (Button) findViewById(R.id.btn_Zapisz_wymiary);
        /** Przycisk btnAnulujAktualizacja po kliknięciu, którego nastepuje powrót
         * do głownej aktywności*/
        Button cliButton2 = (Button) findViewById(R.id.btnAnulujAktualizacja);

        cliButton.setOnClickListener(new View.OnClickListener() {

            /** Metoda odpowiedzialna za pobranie wartości takich jak: waga, ob. klatki,
             * ob. talii, ob. bioder i ob. uda z odpwiednich pól EditTekst, . Zapisuje ona
             * również dane wartości do bazy danych.*/
            @Override
            public void onClick(View v) {
                EditText e1 = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_waga);
                EditText e2 = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_klatka);
                EditText e3= (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_talia);
                EditText e4 = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_biodra);
                EditText e5 = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_uda);
                if(e1.getText().toString().length()==0)
                { e1.setText("0"); }
                if(e2.getText().toString().length()==0)
                { e2.setText("0"); }
                if(e3.getText().toString().length()==0)
                { e3.setText("0"); }
                if(e4.getText().toString().length()==0)
                { e4.setText("0"); }
                if(e5.getText().toString().length()==0)
                { e5.setText("0"); }
                try
                {


                double waga=Double.parseDouble(e1.getText().toString());
                double klatka=Double.parseDouble(e2.getText().toString());
                double talia=Double.parseDouble(e3.getText().toString());
                double biodra=Double.parseDouble(e4.getText().toString());
                double uda=Double.parseDouble(e5.getText().toString());

                    if(waga==0 && klatka==0 && talia==0 && biodra==0 && uda==0)
                    {
                        throw  new Exception("puste wartosci wymiarow");
                    }
                double wzrost=0;
                    zb.dodajWymiar(wzrost, waga, klatka, talia, biodra, uda);
                    Toast.makeText(getApplicationContext(), "Zapisano wymiary", Toast.LENGTH_LONG).show();
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Blad podczas zapisu. Co najmniej jedna wartosc musi byc wieksza od 0", Toast.LENGTH_LONG).show();
                }



            }
        });

        cliButton2.setOnClickListener(new View.OnClickListener() {
            /** Metoda odpowiedzialna za powrót do głónwj aktywności */
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(i);


            }
        });


    }
}
