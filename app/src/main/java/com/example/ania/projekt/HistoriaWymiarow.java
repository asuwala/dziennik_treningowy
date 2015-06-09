package com.example.ania.projekt;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ania on 2015-06-02.
 */
public class HistoriaWymiarow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia_wymiarow);

        Button cliButton = (Button) findViewById(R.id.btn_usun_hist_wym);

        cliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // usunięcie historii wymiarów
            }
        });
    }

}
