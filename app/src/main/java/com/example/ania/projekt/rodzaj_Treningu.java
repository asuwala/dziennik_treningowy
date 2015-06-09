package com.example.ania.projekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Kapibara on 2015-06-02.
 */
public class rodzaj_Treningu extends Activity {
    ZarzadcaBazy zb;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodawanie_terningu);
        zb=new ZarzadcaBazy(this);
        Button b1;
        Button b2=(Button)findViewById(R.id.anuluj);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        b1=(Button)findViewById(R.id.szczegoly);
        b1.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {

                                      String kat=((Spinner)findViewById(R.id.rodzajTrening)).getSelectedItem().toString();
                                      if(kat.equals("Fitness")==true) {
                                          Intent i = new Intent(getApplicationContext(), Plywanie.class);
                                          startActivity(i);
                                      }
                                      if (kat.equals("Bieg")==true){
                                          Intent i = new Intent(getApplicationContext(), Bieg.class);
                                          startActivity(i);
                                      }
                                      if (kat.equals("Plywanie")==true) {
                                          Intent i = new Intent(getApplicationContext(), Plywanie.class);
                                          startActivity(i);
                                      }
                                  }
                              }
        );
        Button b3=(Button)findViewById(R.id.Zapisz);
        b3.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {
                                     // zb.dodajTrening("15-01-2001", "11:23:03", "bieg",
                                      //23, "fdf", "df", "df");
                                      Toast.makeText(getApplicationContext(), "zapisano nowy rekord do bazy", Toast.LENGTH_SHORT).show();
                                  }
                              }
        );

    }
}