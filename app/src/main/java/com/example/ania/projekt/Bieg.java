package com.example.ania.projekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Kapibara on 2015-06-02.
 */
public class Bieg extends Activity {
    ZarzadcaBazy zb;
    String czasT;
    String dataT;
    String aktywnoscT;
    String notatka;
    String styl;
    protected void onCreate(Bundle savedInstanceState) {
        zb=new ZarzadcaBazy(this);
        super.onCreate(savedInstanceState);

        aktywnoscT="bieg";
        setContentView(R.layout.bieg);
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
        Button b2=(Button)findViewById(R.id.AnulujBieg);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), rodzaj_Treningu.class);
                startActivity(i);
            }
        });
        Button b3=(Button)findViewById(R.id.ZapiszBieg);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText not=(EditText)findViewById(R.id.notatkaBieg);
                EditText dys=(EditText)findViewById(R.id.dystansBieg);
                EditText kat=(EditText)findViewById(R.id.kategoriaBieg);
                notatka=not.getText().toString();
                styl="";
                String kategoria=kat.getText().toString();
                double dystans=Double.parseDouble(dys.getText().toString());
                zb.dodajTrening(dataT, czasT, aktywnoscT,
                dystans, kategoria, notatka, styl);
                Intent i = new Intent(getApplicationContext(), rodzaj_Treningu.class);
                startActivity(i);
            }
        });
    }
}
