package com.example.ania.projekt;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Class Uzytkownik ustawia widok fragment_uzytkownik.xml jako jedna z części głównego
 * interfejsu użytkownika oraz obsługuje jego aktywność.
 * Created by Ania on 2015-05-24.
 * @autor Anna Suwała
 */
public class Uzytkownik extends Fragment {

    ZarzadcaBazy zb;

    /** Metoda wywolujaca sie po uruchomieniu biezacej instancji. Uruchamia widok
     * fragment_uzytkownik.xml oraz steruje jego zachowaniem*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        zb=new ZarzadcaBazy(getActivity());

        View w = inflater.inflate(R.layout.fragment_uzytkownik, container, false);
        TextView waga = (TextView) w.findViewById(R.id.tV_Waga_wartosc);
        TextView klatka = (TextView) w.findViewById(R.id.tV_Klatka_wartosc);
        TextView talia = (TextView) w.findViewById(R.id.tV_Talia_wartosc);
        TextView biodra = (TextView) w.findViewById(R.id.tV_Biodra_wartosc);
        TextView uda = (TextView) w.findViewById(R.id.tV_Uda_wartosc);
        TextView whr = (TextView) w.findViewById(R.id.txtWHR);

        Button btn2 = (Button) w
                .findViewById(R.id.btn_Aktualizuj_wymiary);
        Button cliButton2 = (Button) w
                .findViewById(R.id.btn_Historia_wymiary);

        /** Wywołanie metody dajWymiary, która zwraca obiekt klasy Cursor*/
        Cursor k = zb.dajWymiary();
        /** W ykorzystanie metody moveToNext(), w pętli while pozwala na przesuwanie się po
         * wyniku zapytania po linii w dół tak długo jak długo są jeszcze jakieś dane do
         * przeczytania.
         */
        while(k.moveToNext()) {
            // interesuje nas tylko ostatni element - k.isLast()
            if (k.isLast()) {
                // przypisanie zawartości kolumn z kolejnych wierszy do zmiennych
                String dt = k.getString(0);
                String wwaga = k.getString(1);
                String wobKlatki = k.getString(2);
                String wobTalii = k.getString(3);
                String wobBioder = k.getString(4);
                String wobUda = k.getString(5);
                Double WHR = Double.valueOf(wobTalii) / Double.valueOf(wobBioder);
                String wWHRs = String.format("%.2f",WHR);

                // wyświetlenie pobranych danych w przeznaczonych do tego polach
                waga.setText(wwaga);
                klatka.setText(wobKlatki);
                talia.setText(wobTalii);
                biodra.setText(wobBioder);
                uda.setText(wobUda);
                whr.setText(wWHRs);

            }
        }



        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AktualizacjaWymiarowActivity.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });
        cliButton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HistoriaWymiarow.class);
                ((MainActivity) getActivity()).startActivity(intent);
            }
        });

        return w;

    }

}
