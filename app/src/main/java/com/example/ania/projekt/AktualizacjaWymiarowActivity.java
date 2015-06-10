package com.example.ania.projekt;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ania on 2015-06-02.
 */
public class AktualizacjaWymiarowActivity extends Activity {
    ZarzadcaBazy zb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktualizacja_wymiarow);
        zb=new ZarzadcaBazy(this);
        Button cliButton = (Button) findViewById(R.id.btn_Zapisz_wymiary);



        cliButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText e1 = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_waga);
                EditText e2 = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_klatka);
                EditText e3= (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_talia);
                EditText e4 = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_biodra);
                EditText e5 = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_uda);
             //   String napis = waga.getText().toString();
                Double waga=Double.parseDouble(e1.getText().toString());
                Double klatka=Double.parseDouble(e2.getText().toString());
                Double talia=Double.parseDouble(e3.getText().toString());
                Double biodra=Double.parseDouble(e4.getText().toString());
                Double uda=Double.parseDouble(e5.getText().toString());
                //DO ANI !!!
                // zmienic w razie dodania editText z wzrostem-nie chcę mi sie znowu bawić w usuwanie pliku z baza
                //wpisac wartosc tekstowa z editTexta, wktorym podaje się wzrost
                double wzrost=0;
                zb.dodajWymiar( wzrost, waga,klatka, talia,
                        biodra , uda);
                Toast.makeText(getApplicationContext(), "Zapisano wymiary", Toast.LENGTH_LONG).show();
               // Toast.makeText(getApplicationContext(),napis,Toast.LENGTH_LONG).show();
            }
        });

/*
        cliButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getRootView().getContext()).create();
                alertDialog.setTitle("AAA");
                alertDialog.setMessage("Zapianie wymiarów spowoduje zaktualizowanie wymiarów w oknie użtkownika.");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Anuluj", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        EditText waga = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_waga);
                        EditText obklatka = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_klatka);
                        EditText obtalia = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_talia);
                        EditText obbiodra = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_biodra);
                        EditText obuda = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_uda);
                    }
                });
            }
        });

        */


    }
}
