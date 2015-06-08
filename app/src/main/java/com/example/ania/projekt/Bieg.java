package com.example.ania.projekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Kapibara on 2015-06-02.
 */
public class Bieg extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bieg);
        Button b2=(Button)findViewById(R.id.AnulujBieg);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), rodzaj_Treningu.class);
                startActivity(i);
            }
        });
    }
}
