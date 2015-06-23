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
 * Created by Ania on 2015-05-24.
 */
public class Glowna extends Fragment {

    ZarzadcaBazy zb;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View w = inflater.inflate(R.layout.fragment_glowna, container,false);
        Button btn1 = (Button) w
                .findViewById(R.id.buttonDodajTrening);
        TextView data = (TextView) w.findViewById(R.id.tv01);
        TextView czas = (TextView) w.findViewById(R.id.tv11);
        TextView rodzaj = (TextView) w.findViewById(R.id.tv21);
        TextView kategoria = (TextView) w.findViewById(R.id.tv31);
        TextView styl = (TextView) w.findViewById(R.id.tv41);
        TextView dystans = (TextView) w.findViewById(R.id.tv51);
        TextView notatka = (TextView) w.findViewById(R.id.tv70);

        zb=new ZarzadcaBazy(getActivity());
        // String[] kolumny = {"data","czasTreningu","rodzajTreningu","dystans", "kategoria","styl","notatka"};
        Cursor k = zb.dajTreningi();
        while(k.moveToNext()) {
            if (k.isLast()) {
                String dt = k.getString(0);
                String[] sp = dt.split(" ");
                String[] sp2 = sp[0].split("-");
                dt = sp2[2]+":"+sp2[1]+":"+sp2[0];
                String cz = k.getString(1);
                sp = cz.split(":");
                cz = sp[0]+":"+sp[1];
                String rodz = k.getString(2);
                String dys = k.getString(3);
                String kateg = k.getString(4);
                String sty = k.getString(5);
                String not = k.getString(6);

                data.setText(dt);
                czas.setText(cz+" h");
                rodzaj.setText(rodz);
                kategoria.setText(kateg);
                styl.setText(sty);
                dystans.setText(dys+" km");
                notatka.setText(not);

            }
        }

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), rodzaj_Treningu.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }


        });




        return w;
    }

}
