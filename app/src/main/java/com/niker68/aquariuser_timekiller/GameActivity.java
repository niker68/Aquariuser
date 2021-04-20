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

public class GameActivity extends FragmentActivity {

    public int jartank_max;
    public int jartank_current;
    public int jar0_max;
    public int jar0_current;
    public int jar1_max;
    public int jar1_current;
    public int jar2_max;
    public int jar2_current;
    public int mainjar_max;
    public int mainjar_current;

    public int jartank_max_start;
    public int jartank_current_start;
    public int jar0_max_start;
    public int jar0_current_start;
    public int jar1_max_start;
    public int jar1_current_start;
    public int jar2_max_start;
    public int jar2_current_start;
    public int mainjar_max_start;
    public int mainjar_current_start;

    public int jartank_max_cancel;
    public int jartank_current_cancel;
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
    TextView jartank;
    Button fill;
    Button cancel;
    int jartank_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);


        mySettings1 = PreferenceManager.getDefaultSharedPreferences(this);

        jartank_start = Integer.parseInt(mySettings1.getString("jartank_max_start","0")); //передать сюда значение генератором
        //final SharedPreferences mySettings1 = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        //final SharedPreferences mySettings1 = MainActivity.getPreferencies();
        Button main_menu = (Button)findViewById(R.id.main_menu);
        Button restart= (Button)findViewById(R.id.restart);
        cancel = (Button)findViewById(R.id.cancel);
        fill = (Button)findViewById(R.id.fill);
        jartank = (TextView)findViewById(R.id.jartank);
        jar0= findViewById(R.id.jarfr0);
        jar1= findViewById(R.id.jarfr1);
        jar2= findViewById(R.id.jarfr2);
        mainjar=findViewById(R.id.jarfr3);
        drain = (Button)findViewById(R.id.drain);
        watertext = (TextView)findViewById(R.id.watertext);
        /*Jar classjar0 = new Jar0(Integer.parseInt(load("jar0_current_start")),Integer.parseInt(load("jar0_current_max")),"0",false);
        Jar classjar1 = new Jar1(Integer.parseInt(load("jar1_current_start")),Integer.parseInt(load("jar1_current_max")),"1",false);
        Jar classjar2 = new Jar2(Integer.parseInt(load("jar2_current_start")),Integer.parseInt(load("jar2_current_max")),"2",false);
        Jar classjar3 = new Jar3(Integer.parseInt(load("mainjar_current_start")),Integer.parseInt(load("mainjar_current_max")),"3",true);*/





        boolean cancancel = false;
//загрузка данных

//стартовые значения данной партии
        jartank_max_start = Integer.parseInt(mySettings1.getString("jartank_max_start","30"));
        jartank_current_start=Integer.parseInt(mySettings1.getString("jartank_current_start","10"));

        jar0_max_start = Integer.parseInt(mySettings1.getString("jar0_max_start","2"));
        jar0_current_start=Integer.parseInt(mySettings1.getString("jar0_current_start","0"));
        jar1_max_start=Integer.parseInt(mySettings1.getString("jar1_max_start","7"));
        jar1_current_start=Integer.parseInt(mySettings1.getString("jar1_current_start","0"));
        jar2_max_start=Integer.parseInt(mySettings1.getString("jar2_max_start","11"));
        jar2_current_start=Integer.parseInt(mySettings1.getString("jar2_current_start","0"));
        mainjar_max_start=Integer.parseInt(mySettings1.getString("mainjar_max_start","16"));
        mainjar_current_start=Integer.parseInt(mySettings1.getString("mainjar_current_start","0"));
//текущий прогресс партии
        jartank_max = Integer.parseInt(mySettings1.getString("jartank_max","30"));
        jartank_current=Integer.parseInt(mySettings1.getString("jartank_current","10"));
        jar0_max = Integer.parseInt(mySettings1.getString("jar0_max","2"));
        jar0_current=Integer.parseInt(mySettings1.getString("jar0_current","0"));
        jar1_max=Integer.parseInt(mySettings1.getString("jar1_max","7"));
        jar1_current=Integer.parseInt(mySettings1.getString("jar1_current","0"));
        jar2_max=Integer.parseInt(mySettings1.getString("jar2_max","11"));
        jar2_current=Integer.parseInt(mySettings1.getString("jar2_current","0"));
        mainjar_max=Integer.parseInt(mySettings1.getString("mainjar_max","16"));
        mainjar_current=Integer.parseInt(mySettings1.getString("mainjar_current","0"));
// cancel предыдущее состояние
        jartank_max_cancel = Integer.parseInt(mySettings1.getString("jartank_max_cancel","30"));
        jartank_current_cancel=Integer.parseInt(mySettings1.getString("jartank_current_cancel","10"));
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

        String str0 = load("jar0_current")+" / "+load("jar0_max");
        jar0.setText(str0);
        String str1 = load("jar1_current")+" / "+load("jar1_max");
        jar1.setText(str1);
        String str2 = load("jar2_current")+" / "+load("jar2_max");
        jar2.setText(str2);
        String str3 = load("mainjar_current")+" / "+load("mainjar_max");
        mainjar.setText(str3);
        String str4 =load("jartank_max_start");
        jartank.setText(str4);

/*
        Editor editor = mySettings1.edit();
        editor.putString("jar0_max_cancel", mySettings1.getString("jar0_max","0"));
        editor.putString("jar1_max_cancel", mySettings1.getString("jar1_max","0"));
        editor.putString("jar2_max_cancel", mySettings1.getString("jar2_max","0"));
        editor.putString("mainjar_max_cancel", mySettings1.getString("mainjar_max","0"));

        editor.putString("jar0_current_cancel", String.valueOf(0));
        editor.putString("jar1_current_cancel", String.valueOf(0));
        editor.putString("jar2_current_cancel", String.valueOf(0));
        editor.putString("mainjar_current_cancel", String.valueOf(0));



        editor.commit();
 */
        Jar classjar0 = new Jar0(Integer.parseInt(load("jar0_current_start")),Integer.parseInt(load("jar0_current_max")),"0",false);
        Jar classjar1 = new Jar1(Integer.parseInt(load("jar1_current_start")),Integer.parseInt(load("jar1_current_max")),"1",false);
        Jar classjar2 = new Jar2(Integer.parseInt(load("jar2_current_start")),Integer.parseInt(load("jar2_current_max")),"2",false);
        Jar classjar3 = new Jar3(Integer.parseInt(load("mainjar_current_start")),Integer.parseInt(load("mainjar_current_max")),"3",true);

        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editor editor = mySettings1.edit();

                editor.putString("jartank_max", mySettings1.getString("jartank_max","0"));
                editor.putString("jar0_max", mySettings1.getString("jar0_max","0"));
                editor.putString("jar1_max", mySettings1.getString("jar1_max","0"));
                editor.putString("jar2_max", mySettings1.getString("jar2_max","0"));
                editor.putString("mainjar_max", mySettings1.getString("mainjar_max","0"));

                editor.putString("jartank_current", mySettings1.getString("jartank_max_start","0"));
                editor.putString("jar0_current", String.valueOf(0));
                editor.putString("jar1_current", String.valueOf(0));
                editor.putString("jar2_current", String.valueOf(0));
                editor.putString("mainjar_current", String.valueOf(0));
                editor.commit();

                Intent intent = new Intent(GameActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });



        jar0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (load("jar0_current").equals("0")&&load("watertext").equals("0")){
                    fullwater = true;
                }
                if (!endgame){

                if (fullwater){
                    Editor editor = mySettings1.edit();
                    int resulttank0 = Integer.parseInt(mySettings1.getString("jartank_current","0")) -Integer.parseInt(mySettings1.getString("jar0_max","0"))+Integer.parseInt(mySettings1.getString("jar0_current","0"));
                    if (resulttank0>=0) {
                    editor.putString("jar0_current_cancel",mySettings1.getString("jar0_current","0"));

                    editor.putString("jartank_current",String.valueOf(resulttank0));
                    editor.putString("jar0_current",mySettings1.getString("jar0_max","0"));
                    editor.commit();
                    String strfill0 = mySettings1.getString("jar0_current","0")+" / "+mySettings1.getString("jar0_max","0");
                    jar0.setText(strfill0);
                    fullwater = false;
                    save("watertext","0");
                    watertext.setText(load("watertext"));
                    jartank.setText(load("jartank_current"));}
                } else if (watertext.getText().equals("0")){
                    save("watertext",load("jar0_current"));
                    save("jar0_current","0");
                    String str00 = mySettings1.getString("jar0_current","0")+" / "+mySettings1.getString("jar0_max","0");
                    jar0.setText(str00);
                    watertext.setText(load("watertext"));
                } else {//заливание из watertext в кувшин
                    if ((Integer.parseInt(load("watertext"))+Integer.parseInt(load("jar0_current")))<=Integer.parseInt(load("jar0_max"))) {

                        System.out.println("залили все в условии watertext "+load("watertext")+" jar0_current = "+load("jar0_current"));
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
                        System.out.println("remain = "+remainswater);
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
                if (load("jar1_current").equals("0")&&load("watertext").equals("0")){
                    fullwater = true;
                }
                if (!endgame){

                if (fullwater){
                    Editor editor = mySettings1.edit();
                    int resulttank1 = Integer.parseInt(mySettings1.getString("jartank_current","0")) -Integer.parseInt(mySettings1.getString("jar1_max","0"))+Integer.parseInt(mySettings1.getString("jar1_current","0"));
                    if (resulttank1>=0) {
                    editor.putString("jar1_current_cancel",mySettings1.getString("jar1_current","0"));

                    editor.putString("jartank_current",String.valueOf(resulttank1));
                    editor.putString("jar1_current",mySettings1.getString("jar1_max","0"));
                    editor.commit();
                    String strfill1 = mySettings1.getString("jar1_current","0")+" / "+mySettings1.getString("jar1_max","0");
                    jar1.setText(strfill1);
                    fullwater = false;
                    save("watertext","0");
                    watertext.setText(load("watertext"));
                    jartank.setText(load("jartank_current"));}
                } else if (watertext.getText().equals("0")){
                    save("watertext",load("jar1_current"));
                    save("jar1_current","0");
                    System.out.println("забрали");
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

        jar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (load("jar2_current").equals("0")&&load("watertext").equals("0")){
                    fullwater = true;
                }
                if (!endgame){
                if (fullwater){
                Editor editor = mySettings1.edit();
                    int resulttank2 = Integer.parseInt(mySettings1.getString("jartank_current", "0")) - Integer.parseInt(mySettings1.getString("jar2_max", "0")) + Integer.parseInt(mySettings1.getString("jar2_current", "0"));
                    if (resulttank2>=0) {
                        editor.putString("jar2_current_cancel", mySettings1.getString("jar2_current", "0"));


                        editor.putString("jartank_current", String.valueOf(resulttank2));
                        editor.putString("jar2_current", mySettings1.getString("jar2_max", "0"));
                editor.commit();
                String strfill2 = mySettings1.getString("jar2_current","0")+" / "+mySettings1.getString("jar2_max","0");

                jar2.setText(strfill2);
                fullwater = false;
                save("watertext","0");
                watertext.setText(load("watertext"));
                jartank.setText(load("jartank_current"));}

                } else if (watertext.getText().equals("0")){
                    save("watertext",load("jar2_current"));
                    save("jar2_current","0");
                    System.out.println("забрали");
                    String str22 = mySettings1.getString("jar2_current","0")+" / "+mySettings1.getString("jar2_max","0");
                    jar2.setText(str22);
                    watertext.setText(load("watertext"));
                } else {//заливание из watertext в кувшин
                    if ((Integer.parseInt(load("watertext"))+Integer.parseInt(load("jar2_current")))<=Integer.parseInt(load("jar2_max"))) {
                        int num2 = Integer.parseInt(load("jar2_current"))+Integer.parseInt(load("watertext"));
                        System.out.println("залили все");
                        save("jar2_current",String.valueOf(num2));
                        save("watertext","0");
                        String str22 = mySettings1.getString("jar2_current","0")+" / "+mySettings1.getString("jar2_max","0");
                        jar2.setText(str22);
                        watertext.setText(load("watertext"));
                    } else if(Integer.parseInt(load("watertext"))+Integer.parseInt(load("jar2_current"))>Integer.parseInt(load("jar2_max"))) {
                        int empty = Integer.parseInt(load("jar2_max"))-Integer.parseInt(load("jar2_current"));
                        int remainswater = Integer.parseInt(load("watertext"))-empty;
                        System.out.println("remains = "+remainswater);
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
                } else {//заливание из watertext в кувшин
                    if ((Integer.parseInt(load("watertext"))+Integer.parseInt(load("mainjar_current")))<Integer.parseInt(load("mainjar_max"))) {
                        int num2 = Integer.parseInt(load("mainjar_current"))+Integer.parseInt(load("watertext"));
                        System.out.println("залили все");
                        save("mainjar_current",String.valueOf(num2));
                        save("watertext","0");
                        String str22 = mySettings1.getString("mainjar_current","0")+" / "+mySettings1.getString("mainjar_max","0");
                        mainjar.setText(str22);
                        watertext.setText(load("watertext"));
                    } else if(Integer.parseInt(load("watertext"))+Integer.parseInt(load("mainjar_current"))>Integer.parseInt(load("mainjar_max"))) {
                        int numberfinal = Integer.parseInt(load("watertext"))+Integer.parseInt(load("mainjar_current"));
                        save("mainjar_current",String.valueOf(numberfinal));
                        save("watertext","Game Over");
                        endgame = true;
                        watertext.setText(load("watertext"));
                        String str22 = mySettings1.getString("mainjar_current","0")+" / "+mySettings1.getString("mainjar_max","0");
                        mainjar.setText(str22);
                        watertext.setText(load("watertext"));
                        endOfGame();
                    } else if ((Integer.parseInt(load("watertext"))+Integer.parseInt(load("mainjar_current")))==Integer.parseInt(load("mainjar_max"))) {
                        save("mainjar_current",load("mainjar_max"));
                        save("watertext","You Win");
                        endgame = true;
                        String str22 = mySettings1.getString("mainjar_current","0")+" / "+mySettings1.getString("mainjar_max","0");
                        watertext.setText(load("watertext"));
                        mainjar.setText(str22);
                        endOfGame();
                    }
                }
            }}
        });


        int j0;
        int j1;
        int j2;
        int random0;
        int random1;
        int random2;
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Рандомная генерация чисел уровня
                Editor editor = mySettings1.edit();
                int j0 = 0;
                int j1 = 0;
                int j2 = 0;
                // Рандомная генерация в заданных пределах

                if (load("Difficulty").equals("Easy level")) {
                    j0 = (int) (Math.random() * 4 + 2);
                    j1 = (int) (Math.random() * 4 + 7);
                    j2 = (int) (Math.random() * 4 + 12);
                } else {
                    // Рандомная генерация из заданных чисел
                    j0 = (int) (Math.random() * 6 + 3);
                    j1 = (int) (Math.random() * 6 + 10);
                    j2 = (int) (Math.random() * 6 + 17);

                    //изменение четных чисел
                    int random0 = (int) (Math.random() * 3);
                    int countofchetnye = 0;
                    if (j0%2==0){
                        countofchetnye++;
                    }
                    if (j1%2==0){
                        countofchetnye++;
                    }
                    if (j2%2==0){
                        countofchetnye++;
                    }
                    if (countofchetnye>2) { //если четных три то делаем одно четное
                        if (j0 % 2 == 0) {
                            j0++;
                        }
                        if (j2 % 2 == 0) {
                            j2++;
                        }


                    }
                }
                editor.putString("jar0_max_start", String.valueOf(j0));
                editor.putString("jar1_max_start", String.valueOf(j1));
                editor.putString("jar2_max_start", String.valueOf(j2));
                Intent intent1 = new Intent(GameActivity.this, Generator.class);
                startActivity(intent1);

                editor.putString("jar0_current", String.valueOf(0));
                editor.putString("jar1_current", String.valueOf(0));
                editor.putString("jar2_current", String.valueOf(0));
                editor.putString("mainjar_current", String.valueOf(0));
                editor.putString("jar0_max", mySettings1.getString("jar0_max_start","0"));
                editor.putString("jar1_max", mySettings1.getString("jar1_max_start","0"));
                editor.putString("jar2_max", mySettings1.getString("jar2_max_start","0"));
                editor.commit();

                //

                //Intent intent = new Intent(MainActivity.this, GameActivity.class);
                //startActivity(intent);
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
