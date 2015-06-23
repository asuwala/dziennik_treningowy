package com.example.ania.projekt;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ania on 2015-05-24.
 *
 */
public class Historia extends Fragment {
    ZarzadcaBazy zb;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        zb=new ZarzadcaBazy(getActivity());
         View w = inflater.inflate(R.layout.fragment_historia, container, false);

        Button cliButton = (Button) w.findViewById(R.id.btn_usun_hist_tren);
        TextView treningi = (TextView) w.findViewById(R.id.tV_Historia_trenngow);



        Cursor k = zb.dajTreningi();
        while(k.moveToNext()) {
            // przypisanie zawartość kolumn z kolejnych wierszy wg pozycji tej kolumny
            // wg kolejności wymienionej w metodzie dajWszystkie klasy ZarzadcaBazy
            String data = k.getString(0);
            String[] sp = data.split(" ");
            String[] sp2 = sp[0].split("-");
            data  = sp2[2]+":"+sp2[1]+":"+sp2[0];
            String czas = k.getString(1);
            sp = czas.split(":");
            czas = sp[0]+":"+sp[1];
            String rodzaj = k.getString(2);
            String dystans = k.getString(3);
            String kategoria = k.getString(4);
            String styl = k.getString(5);
            String notatka = k.getString(6);

            //  konkatenacja uzyskanych informacji i wyświetlenie ich w kompononecie klasy TextView
            treningi.setText(treningi.getText()+"\n"+" Data: "+data+ "\n" +" Czas: " +czas+" h"+ "\n"+
                    " Rodzaj: "+rodzaj+ "\n"+" Dystans: "+dystans+" km "+ "\n"+" Kategoria: "
                    +kategoria+styl+"\n"+" Notatka: "+notatka+"\n");

        }

        cliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zb.usunTrening();
            }
        });

        return w;
    }
}
