package com.example.ania.projekt;


import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Ania on 2015-06-02.
 */
public class AktualizacjaWymiarowActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktualizacja_wymiarow);

        Button cliButton = (Button) findViewById(R.id.btn_Zapisz_wymiary);



        cliButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText waga = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_waga);
                EditText obklatka = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_klatka);
                EditText obtalia = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_talia);
                EditText obbiodra = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_biodra);
                EditText obuda = (EditText)AktualizacjaWymiarowActivity.this.findViewById(R.id.et_uda);
                String napis = waga.getText().toString();
                //Toast.makeText(getApplicationContext(), "Zapisano wymiary", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),napis,Toast.LENGTH_LONG).show();
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
