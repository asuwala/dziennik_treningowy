package com.example.ania.projekt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ania on 2015-05-24.
 */
public class Historia extends Fragment {
    ZarzadcaBazy zb;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        zb=new ZarzadcaBazy(getActivity());
         View w = inflater.inflate(R.layout.fragment_historia, container, false);

        Button cliButton = (Button) w .findViewById(R.id.btn_usun_hist_tren);

        cliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zb.usunTrening();
            }
        });

        return w;
    }
}
