package com.niker68.aquariuser_timekiller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;


public class Generator extends FragmentActivity {
    public int jar0_max;
    public int jar0_current;
    public int jar1_max;
    public int jar1_current;
    public int jar2_max;
    public int jar2_current;
    public int mainjar_max;
    public int mainjar_current;

    public int jar0_max_start;
    public int jar0_current_start;
    public int jar1_max_start;
    public int jar1_current_start;
    public int jar2_max_start;
    public int jar2_current_start;
    public int mainjar_max_start;
    public int mainjar_current_start;

    public int jar0_max_cancel;
    public int jar0_current_cancel;
    public int jar1_max_cancel;
    public int jar1_current_cancel;
    public int jar2_max_cancel;
    public int jar2_current_cancel;
    public int mainjar_max_cancel;
    public int mainjar_current_cancel;
    boolean fullwater = false;
    boolean endgame = false;
    int water=0;
    Button jar0;
    Button jar1;
    Button jar2;
    Button mainjar;
    Button drain;
    SharedPreferences mySettings1;
    TextView watertext;
    Button fill;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity_generator);


        mySettings1 = PreferenceManager.getDefaultSharedPreferences(this);
        Button main_menu = (Button)findViewById(R.id.main_menu);
        Button restart= (Button)findViewById(R.id.restart);
        cancel = (Button)findViewById(R.id.cancel);
        fill = (Button)findViewById(R.id.fill);
        jar0= findViewById(R.id.jarfr0);
        jar1= findViewById(R.id.jarfr1);
        jar2= findViewById(R.id.jarfr2);
        mainjar=findViewById(R.id.jarfr3);
        drain = (Button)findViewById(R.id.drain);
        watertext = (TextView)findViewById(R.id.watertext);






        boolean cancancel = false;
//загрузка данных

//стартовые значения данной партии
        jar0_max_start = Integer.parseInt(mySettings1.getString("jar0_max_start","2"));
        jar0_current_start=Integer.parseInt(mySettings1.getString("jar0_current_start","0"));
        jar1_max_start=Integer.parseInt(mySettings1.getString("jar1_max_start","7"));
        jar1_current_start=Integer.parseInt(mySettings1.getString("jar1_current_start","0"));
        jar2_max_start=Integer.parseInt(mySettings1.getString("jar2_max_start","11"));
        jar2_current_start=Integer.parseInt(mySettings1.getString("jar2_current_start","0"));
        mainjar_max_start=Integer.parseInt(mySettings1.getString("mainjar_max_start","16"));
        mainjar_current_start=Integer.parseInt(mySettings1.getString("mainjar_current_start","0"));
//текущий прогресс партии
        jar0_max = Integer.parseInt(mySettings1.getString("jar0_max","2"));
        jar0_current=Integer.parseInt(mySettings1.getString("jar0_current","0"));
        jar1_max=Integer.parseInt(mySettings1.getString("jar1_max","7"));
        jar1_current=Integer.parseInt(mySettings1.getString("jar1_current","0"));
        jar2_max=Integer.parseInt(mySettings1.getString("jar2_max","11"));
        jar2_current=Integer.parseInt(mySettings1.getString("jar2_current","0"));
        //mainjar_max=Integer.parseInt(mySettings1.getString("mainjar_max","16"));
        mainjar_current=Integer.parseInt(mySettings1.getString("mainjar_current","0"));
// cancel предыдущее состояние
        String defaultjar0 = mySettings1.getString("jar0_max","000");
        jar0_max_cancel = Integer.parseInt(mySettings1.getString("jar0_max_cancel",defaultjar0));
        jar0_current_cancel=Integer.parseInt(mySettings1.getString("jar0_current_cancel",mySettings1.getString("jar0_current","000")));
        jar1_max_cancel=Integer.parseInt(mySettings1.getString("jar1_max_cancel",mySettings1.getString("jar1_max","000")));
        jar1_current_cancel=Integer.parseInt(mySettings1.getString("jar1_current_cancel",mySettings1.getString("jar1_current","000")));
        jar2_max_cancel=Integer.parseInt(mySettings1.getString("jar2_max_cancel",mySettings1.getString("jar2_max","000")));
        jar2_current_cancel=Integer.parseInt(mySettings1.getString("jar2_current_cancel",mySettings1.getString("jar2_current","000")));
//        mainjar_max_cancel=Integer.parseInt(mySettings1.getString("mainjar_max_cancel",mySettings1.getString("mainjar_max","000")));
        mainjar_current_cancel=Integer.parseInt(mySettings1.getString("mainjar_current_cancel",mySettings1.getString("mainjar_current","000")));
//
        String str0 = jar0_current+" / "+jar0_max;
        jar0.setText(str0);
        String str1 = jar1_current+" / "+jar1_max;
        jar1.setText(str1);
        String str2 = jar2_current+" / "+jar2_max;
        jar2.setText(str2);
        String str3 = mainjar_current+" / "+mainjar_max;
        mainjar.setText(str3);

        Editor editor = mySettings1.edit();

        editor.putString("jar0_current_cancel", String.valueOf(0));
        editor.putString("jar1_current_cancel", String.valueOf(0));
        editor.putString("jar2_current_cancel", String.valueOf(0));
        editor.putString("mainjar_current_cancel", String.valueOf(0));
        editor.putString("jartank_current", String.valueOf(0));
        editor.putString("jartank_max", String.valueOf(0));
        editor.putString("jartank_current_start", String.valueOf(0));
        editor.putString("jartank_max_start", String.valueOf(0));


        editor.commit();
        jar0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endgame){
                    if (fullwater){
                        Editor editor = mySettings1.edit();
                        editor.putString("jar0_current_cancel",mySettings1.getString("jar0_current","0"));
                        int resulttank0 = Integer.parseInt(mySettings1.getString("jartank_current","0")) -Integer.parseInt(mySettings1.getString("jar0_max","0"))+Integer.parseInt(mySettings1.getString("jar0_current","0"));
                        editor.putString("jartank_current",String.valueOf(resulttank0));
                        editor.putString("jar0_current",mySettings1.getString("jar0_max","0"));
                        editor.commit();
                        String strfill0 = mySettings1.getString("jar0_current","0")+" / "+mySettings1.getString("jar0_max","0");
                        jar0.setText(strfill0);
                        fullwater = false;
                        save("watertext","0");
                        watertext.setText(load("watertext"));
                    } else if (watertext.getText().equals("0")){
                        save("watertext",load("jar0_current"));
                        save("jar0_current","0");
                        String str00 = mySettings1.getString("jar0_current","0")+" / "+mySettings1.getString("jar0_max","0");
                        jar0.setText(str00);
                        watertext.setText(load("watertext"));
                    } else {//заливание из watertext в кувшин
                        if ((Integer.parseInt(load("watertext"))+Integer.parseInt(load("jar0_current")))<=Integer.parseInt(load("jar0_max"))) {

                           // System.out.println("залили все в условии watertext "+load("watertext")+" jar0_current = "+load("jar0_current"));
                            int num0 = Integer.parseInt(load("jar0_current"))+Integer.parseInt(load("watertext"));
                            save("jar0_current",String.valueOf(num0));
                            save("watertext","0");
                            String str00 = load("jar0_current")+" / "+mySettings1.getString("jar0_max","0");
                            jar0.setText(str00);
                            watertext.setText(load("watertext"));
                        } else if(Integer.parseInt(load("watertext"))+Integer.parseInt(load("jar0_current"))>Integer.parseInt(load("jar0_max"))) {
                            int empty = Integer.parseInt(load("jar0_max"))-Integer.parseInt(load("jar0_current"));
                            int remainswater = Integer.parseInt(load("watertext"))-empty;
                            save("jar0_current",load("jar0_max"));
                            save("watertext",String.valueOf(remainswater));
                            //System.out.println("remain = "+remainswater);
                            watertext.setText(load("watertext"));
                            String str00 = mySettings1.getString("jar0_current","0")+" / "+mySettings1.getString("jar0_max","0");
                            jar0.setText(str00);
                            watertext.setText(load("watertext"));
                        }
                    }
                }}
        });

        jar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endgame){
                    if (fullwater){
                        Editor editor = mySettings1.edit();
                        editor.putString("jar1_current_cancel",mySettings1.getString("jar1_current","0"));
                        int resulttank1 = Integer.parseInt(mySettings1.getString("jartank_current","0")) -Integer.parseInt(mySettings1.getString("jar1_max","0"))+Integer.parseInt(mySettings1.getString("jar1_current","0"));
                        editor.putString("jartank_current",String.valueOf(resulttank1));
                        editor.putString("jar1_current",mySettings1.getString("jar1_max","0"));
                        editor.commit();
                        String strfill1 = mySettings1.getString("jar1_current","0")+" / "+mySettings1.getString("jar1_max","0");
                        jar1.setText(strfill1);
                        fullwater = false;
                        save("watertext","0");
                        watertext.setText(load("watertext"));
                    } else if (watertext.getText().equals("0")){
                        save("watertext",load("jar1_current"));
                        save("jar1_current","0");
                       // System.out.println("забрали");
                        String str11 = mySettings1.getString("jar1_current","0")+" / "+mySettings1.getString("jar1_max","0");
                        jar1.setText(str11);
                        watertext.setText(load("watertext"));
                    } else {//заливание из watertext в кувшин
                        if (Integer.parseInt(load("watertext"))+Integer.parseInt(load("jar1_current"))<=Integer.parseInt(load("jar1_max"))) {
                            int num1 = Integer.parseInt(load("jar1_current"))+Integer.parseInt(load("watertext"));
                            save("jar1_current",String.valueOf(num1));
                            save("watertext","0");
                            String str11 = mySettings1.getString("jar1_current","0")+" / "+mySettings1.getString("jar1_max","0");
                            jar1.setText(str11);
                            watertext.setText(load("watertext"));
                        } else if(Integer.parseInt(load("watertext"))+Integer.parseInt(load("jar1_current"))>Integer.parseInt(load("jar1_max"))) {
                            int empty = Integer.parseInt(load("jar1_max"))-Integer.parseInt(load("jar1_current"));
                            int remainswater = Integer.parseInt(load("watertext"))-empty;
                            save("jar1_current",load("jar1_max"));
                            save("watertext",String.valueOf(remainswater));
                            watertext.setText(load("watertext"));
                            String str11 = mySettings1.getString("jar1_current","0")+" / "+mySettings1.getString("jar1_max","0");
                            jar1.setText(str11);
                            watertext.setText(load("watertext"));
                        }
                    }
                }}
        });
        save("mainjar_max",load("jar2_current"));
        jar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!endgame){
                    if (fullwater){
                        Editor editor = mySettings1.edit();
                        editor.putString("jar2_current_cancel",mySettings1.getString("jar2_current","0"));
                        int resulttank2 = Integer.parseInt(mySettings1.getString("jartank_current","0")) -Integer.parseInt(mySettings1.getString("jar2_max","0"))+Integer.parseInt(mySettings1.getString("jar2_current","0"));
                        editor.putString("jartank_current",String.valueOf(resulttank2));
                        editor.putString("jar2_current",mySettings1.getString("jar2_max","0"));
                        editor.commit();
                        String strfill2 = mySettings1.getString("jar2_current","0")+" / "+mySettings1.getString("jar2_max","0");

                        jar2.setText(strfill2);
                        fullwater = false;
                        save("watertext","0");
                        watertext.setText(load("watertext"));


                    } else if (watertext.getText().equals("0")){
                        save("watertext",load("jar2_current"));
                        save("jar2_current","0");
                        //System.out.println("забрали");
                        String str22 = mySettings1.getString("jar2_current","0")+" / "+mySettings1.getString("jar2_max","0");
                        jar2.setText(str22);
                        watertext.setText(load("watertext"));
                    } else {//заливание из watertext в кувшин
                        if ((Integer.parseInt(load("watertext"))+Integer.parseInt(load("jar2_current")))<=Integer.parseInt(load("jar2_max"))) {
                            int num2 = Integer.parseInt(load("jar2_current"))+Integer.parseInt(load("watertext"));
                           // System.out.println("залили все");
                            save("jar2_current",String.valueOf(num2));
                            save("watertext","0");
                            String str22 = mySettings1.getString("jar2_current","0")+" / "+mySettings1.getString("jar2_max","0");
                            jar2.setText(str22);
                            watertext.setText(load("watertext"));
                        } else if(Integer.parseInt(load("watertext"))+Integer.parseInt(load("jar2_current"))>Integer.parseInt(load("jar2_max"))) {
                            int empty = Integer.parseInt(load("jar2_max"))-Integer.parseInt(load("jar2_current"));
                            int remainswater = Integer.parseInt(load("watertext"))-empty;
                            //System.out.println("remains = "+remainswater);
                            save("jar2_current",load("jar2_max"));
                            save("watertext",String.valueOf(remainswater));
                            watertext.setText(load("watertext"));
                            String str22 = mySettings1.getString("jar2_current","0")+" / "+mySettings1.getString("jar2_max","0");
                            jar2.setText(str22);
                            watertext.setText(load("watertext"));
                        }
                    }
                }}
        });

        mainjar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endgame){
                    if (fullwater){
                        fullwater = false;
                        watertext.setText("0");
                        save("watertext","0");
                        //заливание из watertext в кувшин
                    } else if (!load("watertext").equals("0")) {
                            int num2 = Integer.parseInt(load("mainjar_max")) + Integer.parseInt(load("watertext"));
                            save("mainjar_max", String.valueOf(num2));
                            save("watertext", "0");
                            String str22 = mySettings1.getString("mainjar_max", "0");
                            mainjar.setText(str22);
                            watertext.setText(load("watertext"));
                        }
                    }
                }
        });
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endgame){
                    if (watertext.getText().equals("0")) {
                        fullwater = true;
                        watertext.setText("Full");
                        save("watertext", "Full");
                    }
                }}
        });

        drain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endgame){
                    if (!watertext.getText().equals("0")) {
                        fullwater = false;
                        watertext.setText("0");
                        save("watertext", "0");
                    }
                }}
        });

        //Генерация кликов по кнопкам

        int difficulty=10;
        System.out.println("сложность = "+load("Difficulty"));
        if (load("Difficulty").equals("Easy level")) {
            difficulty = (int) (Math.random() * 3 + 9);
            System.out.println("Легкая");
        }
        if (load("Difficulty").equals("Medium level")) {
            difficulty = (int) (Math.random() * 3 + 7);
            System.out.println("Средняя");
        }
        if (load("Difficulty").equals("Hard level")) {
            difficulty = (int) (Math.random() * 4 + 9);
            System.out.println("Сложная");
        }

        int index = 0;
        for (int i = 0; i<=difficulty;i++){
            index=(int)(Math.random()*16);
            //System.out.println(index);
            /*if (index < 2) {
            jar0.performClick();

            }
            if (index > 1 && index <4) {
                jar1.performClick();
            }
            if (index > 3 && index <6) {
            jar2.performClick();
            }
            if (index ==6) {
            mainjar.performClick();
            }
            if (index > 6 && index <9) {
            drain.performClick();
            }*/
            if (-1<index && index<2 ) {
                fill.performClick();
                jar2.performClick();
                jar2.performClick();
                jar1.performClick();
                mainjar.performClick();

            }
            if (1<index && index<4) {
                fill.performClick();
                jar1.performClick();
                jar1.performClick();
                jar0.performClick();
                mainjar.performClick();
            }
            if (3<index && index<6 ) {
                fill.performClick();
                jar0.performClick();
                jar0.performClick();
                jar2.performClick();
                fill.performClick();
                jar1.performClick();
                jar1.performClick();
                jar2.performClick();
                jar2.performClick();
                mainjar.performClick();
            }
            if (5<index && index<8) {
                fill.performClick();
                jar2.performClick();
                jar2.performClick();
                jar0.performClick();
                mainjar.performClick();
            }
            if (7<index && index<10) {
                fill.performClick();
                jar2.performClick();
                jar2.performClick();
                jar0.performClick();
                jar2.performClick();
                jar1.performClick();
                jar2.performClick();
                mainjar.performClick();
            }
            if (9<index && index<12) {//отсюда нумеровать
                fill.performClick();
                jar2.performClick();
                jar2.performClick();
                jar0.performClick();
                jar2.performClick();
                jar0.performClick();
                jar2.performClick();
                mainjar.performClick();

            }
            if (index ==12) {
                fill.performClick();
                jar0.performClick();
                jar0.performClick();
                mainjar.performClick();
            }
            if (index ==13) {
                fill.performClick();
                jar1.performClick();
                jar1.performClick();
                mainjar.performClick();

            }
            if (index ==14) {
                fill.performClick();
                jar2.performClick();
                jar2.performClick();
                mainjar.performClick();


            }


        }
        //

        save("jar0_current","0");
        save("jar1_current","0");
        save("jar2_current","0");
        save("mainjar_current","0");
        save("mainjar_start_max",load("mainjar_max"));
        int resultofinversion = Integer.parseInt(load("jartank_current"))*(-1);
        save("jartank_max_start",String.valueOf(resultofinversion));
        save("jartank_current_start",String.valueOf(resultofinversion));
        save("jartank_current",String.valueOf(resultofinversion));
        save("jartank_max",String.valueOf(resultofinversion));
        jar0.setVisibility(View.INVISIBLE);
        jar1.setVisibility(View.INVISIBLE);
        jar2.setVisibility(View.INVISIBLE);
        mainjar.setVisibility(View.INVISIBLE);
        System.out.println("СГЕНЕРИРОВАНО "+load("mainjar_max"));
        Intent intent = new Intent(Generator.this, GameActivity.class);
        startActivity(intent);

    }

    public String load (String str){
        return mySettings1.getString(str,"0");
    }
    public void save (String key, String str){
        Editor editor = mySettings1.edit();
        editor.putString(key,str);
        editor.commit();
    }

    public void endOfGame (){
        drain.setVisibility(View.INVISIBLE);
        fill.setVisibility(View.INVISIBLE);
        jar0.setVisibility(View.INVISIBLE);
        jar1.setVisibility(View.INVISIBLE);
        jar2.setVisibility(View.INVISIBLE);
    }
}

