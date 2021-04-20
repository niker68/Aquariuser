package com.niker68.aquariuser_timekiller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Jar3 extends Jar {

        /*Button button = findViewById(R.id.jar0);
        button.setText("удалось 1");*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.jar_activity3, container, false);
        Button button3 = (Button ) view.findViewById(R.id.jarfr3);
        return view;

    }

    /*@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button = getActivity().findViewById(R.id.jar0);
        //button.setOnClickListener();
    }*/
    public Jar3(){

    }
    public Jar3(int v, int maxv, String id, boolean mainjar){
        this.v = v;
        this.maxv = maxv;
        this.mainjar = mainjar;
    }
}
