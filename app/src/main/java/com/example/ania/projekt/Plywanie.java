package com.example.ania.projekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by Kapibara on 2015-06-02.
 */
public class Plywanie extends Activity {
    ZarzadcaBazy zb;
    String czasT;
    String styl;
    String dataT;
    protected void onCreate(Bundle savedInstanceState) {
        zb=new ZarzadcaBazy(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plywanie);
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
        Button b2=(Button)findViewById(R.id.AnulujPlywanie);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), rodzaj_Treningu.class);
                startActivity(i);
            }
        });
        Button b3=(Button)findViewById(R.id.ZapiszPlywanie);

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               RadioGroup s=(RadioGroup)findViewById(R.id.stylPlywanie);
                int s1=s.getCheckedRadioButtonId();

                if(s1==R.id.motylkowy)
                {
                    styl="motylkowy";
                }
                else if(s1==R.id.klasyczny)
                {
                    styl="grzbietowy";
                }
                else if(s1==R.id.grzbietowy)
                {
                    styl="klasyczy";
                }
                else if(s1==R.id.kraul)
                {
                    styl="kraul";
                }
                EditText not=(EditText)findViewById(R.id.notatkaPlywanie);
                EditText dys=(EditText)findViewById(R.id.dystansPlywanie);
               //  EditText sty=(EditText)findViewById(R.id.stylPlywanie);
                String notatka=not.getText().toString();
                String kategoria="";
                String aktywnoscT="plywanie";
                double dystans=Double.parseDouble(dys.getText().toString());
                zb.dodajTrening(dataT, czasT, aktywnoscT,
                        dystans, kategoria, notatka, styl);
                Intent i = new Intent(getApplicationContext(), rodzaj_Treningu.class);
                startActivity(i);
            }
        });
    }
}
