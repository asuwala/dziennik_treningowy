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
 * Created by Kapibara on 2015-06-02.
 */
public class rodzaj_Treningu extends Activity {
    ZarzadcaBazy zb;
    public Intent i;
    String aktywnosc;
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
                                      final EditText czas=(EditText)findViewById(R.id.Czas);
                                      final EditText data=(EditText)findViewById(R.id.Data);

                                      String kat=((Spinner)findViewById(R.id.rodzajTrening)).getSelectedItem().toString();
                                      if(kat.equals("Fitness")==true) {
                                          i = new Intent(getApplicationContext(), Fitness.class);
                                          aktywnosc="fitness";
                                      }
                                      if (kat.equals("Bieg")==true){
                                          i = new Intent(getApplicationContext(), Bieg.class);

                                      }
                                      if (kat.equals("Plywanie")==true) {
                                          i = new Intent(getApplicationContext(), Plywanie.class);



                                      }
                                      i.putExtra("czas", czas.getText().toString());
                                      i.putExtra("data", data.getText().toString());
                                      startActivity(i);
                                  }
                              }
        );

        Button b3=(Button)findViewById(R.id.Zapisz);
        b3.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {
                                      final EditText czas=(EditText)findViewById(R.id.Czas);
                                      final EditText data=(EditText)findViewById(R.id.Data);
                                      String czasT=czas.getText().toString();
                                      String dataT=data.getText().toString();

                                      String kat=((Spinner)findViewById(R.id.rodzajTrening)).getSelectedItem().toString();
                                      zb.dodajTrening(dataT, czasT, kat,
                                              0, "", "", "");
                                      Toast.makeText(getApplicationContext(), "zapisano nowy rekord do bazy", Toast.LENGTH_LONG).show();
                                  }
                              }
        );

    }
}