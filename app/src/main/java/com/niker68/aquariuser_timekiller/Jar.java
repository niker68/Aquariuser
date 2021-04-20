package com.niker68.aquariuser_timekiller;

import androidx.fragment.app.Fragment;

public class Jar extends Fragment {
    public int v = 0;
    public int maxv = 0;
    public boolean mainjar;
    public Jar (){

    }
    public Jar (int v, int maxv, String id, boolean mainjar){
        this.v = v;
        this.maxv = maxv;
        this.mainjar = mainjar;
    }

    public int takewater (){
        if (!mainjar) {
            int v1 = v;
            v = 0;
            return v1;
        }else {return 0;}
    }
    public int givewater(int water){
       if ((v+water)>maxv){
           int v1 = maxv-v;
           v = maxv;
           return v1;
       } else {
           v=v+water;
           return 0;
       }
    }
}
