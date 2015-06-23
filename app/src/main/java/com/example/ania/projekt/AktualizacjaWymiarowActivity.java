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
 * Created by Ania on 2015-06-02.
 */
public class AktualizacjaWymiarowActivity extends Activity {

    // stworzenie obiektu zarządcy baza danych
    ZarzadcaBazy zb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktualizacja_wymiarow);
        zb=new ZarzadcaBazy(this);
        Button cliButton = (Button) findViewById(R.id.btn_Zapisz_wymiary);
        Button cliButton2 = (Button) findViewById(R.id.btnAnulujAktualizacja);






        cliButton.setOnClickListener(new View.OnClickListener() {

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
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(i);


            }
        });


    }
}
