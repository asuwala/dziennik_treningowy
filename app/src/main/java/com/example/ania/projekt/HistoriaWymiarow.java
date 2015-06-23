package com.example.ania.projekt;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ania on 2015-06-02.
 */
public class HistoriaWymiarow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia_wymiarow);

        Button cliButton = (Button) findViewById(R.id.btn_usun_hist_wym);
        TextView historiaWym = (TextView) findViewById(R.id.tv_historia_wymiarow);
        historiaWym.setText(" DATA          WAGA   K   T   B   U");

        // stworzenie obiektu zarządcy baza danych
        ZarzadcaBazy zb = new ZarzadcaBazy(this);
        // pobranie danych z bazy w postaci obiektu klasy Cursor
        Cursor k = zb.dajWymiary();
        // wyorzystanie metody moveToNext(), ktora pozwala na przesuwanie się po wyniku zapytania
        // po linii w dół tak długo, jak długo są jeszcze jakieś dane do przeczytania
        while(k.moveToNext()) {
            // przypisanie zawartość kolumn z kolejnych wierszy wg pozycji tej kolumny
            // wg kolejności wymienionej w metodzie dajWszystkie klasy ZarzadcaBazy
            String dt = k.getString(0);
            String[] sp = dt.split(" ");
            String[] sp2 = sp[0].split("-");
            String data = sp2[2]+":"+sp2[1]+":"+sp2[0];
            String waga = k.getString(1);
            String obKlatki = k.getString(2);
            String obTalii = k.getString(3);
            String obBioder = k.getString(4);
            String obUda = k.getString(5);
            //  konkatenacja uzyskanych informacji i wyświetlenie ich w kompononecie klasy TextView
            historiaWym.setText(historiaWym.getText()+"\n"+" "+data+"    "+waga+"     "+obKlatki+" "
                    +obTalii+" "+obBioder+" "+obUda);
        }

        cliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // usunięcie historii wymiarów
            }
        });
    }

}
