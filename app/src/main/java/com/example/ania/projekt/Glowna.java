package com.example.ania.projekt;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ania on 2015-05-24.
 */
public class Glowna extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View w = inflater.inflate(R.layout.fragment_glowna, container,false);
        Button btn1 = (Button) w
                .findViewById(R.id.buttonDodajTrening);


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
