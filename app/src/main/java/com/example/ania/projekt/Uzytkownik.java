package com.example.ania.projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ania on 2015-05-24.
 */
public class Uzytkownik extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View w = inflater.inflate(R.layout.fragment_uzytkownik, container, false);

        Button btn2 = (Button) w
                .findViewById(R.id.btn_Aktualizuj_wymiary);
        Button cliButton2 = (Button) w
                .findViewById(R.id.btn_Historia_wymiary);

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
