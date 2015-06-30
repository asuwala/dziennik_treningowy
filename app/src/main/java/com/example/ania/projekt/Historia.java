package com.example.ania.projekt;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Class Historia ustawia widok fragment_historia.xml jako jedna z części głównego
 * interfejsu użytkownika oraz obsługuje jego aktywność.
 * Created by Ania on 2015-05-24.
 * @autor Anna Suwała
 */
public class Historia extends Fragment {
    ZarzadcaBazy zb;

    /** Metoda wywolujaca sie po uruchomieniu biezacej instancji. Uruchamia widok
     * fragment_historia.xml oraz steruje jego zachowaniem*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        zb=new ZarzadcaBazy(getActivity());
         View w = inflater.inflate(R.layout.fragment_historia, container, false);

        Button cliButton = (Button) w.findViewById(R.id.btn_usun_hist_tren);
        TextView treningi = (TextView) w.findViewById(R.id.tV_Historia_trenngow);
        final TextView tv = (TextView) w.findViewById(R.id.tV_Historia_trenngow);


        /** Wywołanie metody dajTrening, która zwraca obiekt klasy Cursor*/
        Cursor k = zb.dajTreningi();
        /** W ykorzystanie metody moveToNext(), w pętli while pozwala na przesuwanie się po
         * wyniku zapytania po linii w dół tak długo jak długo są jeszcze jakieś dane do
         * przeczytania.
         */
        while(k.moveToNext()) {
            // przypisanie zawartości kolumn z kolejnych wierszy do zmiennych
            String data = k.getString(0);
            String[] sp = data.split(" ");
            String[] sp2 = sp[0].split("-");
            data  = sp2[2]+":"+sp2[1]+":"+sp2[0];
            String czas = k.getString(1);
            sp = czas.split(":");
            czas = sp[0] + ":" + sp[1];
            String rodzaj = k.getString(2);
            String dystans = k.getString(3);
            String kategoria = k.getString(4);
            String styl = k.getString(5);
            String notatka = k.getString(6);

            //  połączennie uzyskanych informacji i wyświetlenie ich w kompononecie klasy TextView
            treningi.setText(treningi.getText()+"\n"+" Data: "+data+ "\n" +" Czas: " +czas+" h"+ "\n"+
                    " Rodzaj: "+rodzaj+ "\n"+" Dystans: "+dystans+" km "+ "\n"+" Kategoria: "
                    +kategoria+styl+"\n"+" Notatka: "+notatka+"\n");

        }

        cliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zb.usunTrening();
                tv.setText("");
            }
        });

        return w;
    }
}
