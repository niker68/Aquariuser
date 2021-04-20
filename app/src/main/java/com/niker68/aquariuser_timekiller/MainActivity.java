package com.niker68.aquariuser_timekiller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences.Editor;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mySettings;
    int j0;
    int j1;
    int j2;
    int random0;
    int random1;
    int random2;
    int jartank_start;

    protected void randomGenerate(){
        j0 = 0;
        j1 = 0;
        j2 = 0;
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
            random0 = (int) (Math.random() * 3);
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
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySettings = PreferenceManager.getDefaultSharedPreferences(this);
        Button new_game = (Button)findViewById(R.id.new_game);
        Button continue_game = (Button)findViewById(R.id.continue_game);
        jartank_start = Integer.parseInt(mySettings.getString("jartank_max_start","0")); ///сюда передать генератором значение
        final Button level = (Button)findViewById(R.id.freebutton);

        if (load("Difficulty").equals("0")){
            save("Difficulty","Easy level");
        }
        level.setText(mySettings.getString("Difficulty","Easy level"));
        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Рандомная генерация чисел уровня
                randomGenerate();

                Editor editor = mySettings.edit();
                //int mainj=(int)(Math.random()*10+17);
                editor.putString("jar0_max_start", String.valueOf(j0));
                editor.putString("jar1_max_start", String.valueOf(j1));
                editor.putString("jar2_max_start", String.valueOf(j2));
                editor.putString("jartank_max_start", String.valueOf(jartank_start));

                //editor.putString("mainjar_max_start", String.valueOf(mainj));

                Intent intent1 = new Intent(MainActivity.this, Generator.class);
                startActivity(intent1);
                if (load("mainjar_max").equals("0")){
                    Intent intent = new Intent(MainActivity.this, Generator.class);
                    startActivity(intent);
                }
                editor.putString("jar0_current", String.valueOf(0));
                editor.putString("jar1_current", String.valueOf(0));
                editor.putString("jar2_current", String.valueOf(0));
                editor.putString("mainjar_current", String.valueOf(0));
                editor.putString("jar0_max", mySettings.getString("jar0_max_start","0"));
                editor.putString("jar1_max", mySettings.getString("jar1_max_start","0"));
                editor.putString("jar2_max", mySettings.getString("jar2_max_start","0"));

                //editor.putString("mainjar_max", mySettings.getString("mainjar_max_start","0"));
                editor.commit();
            }
        });
        continue_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (level.getText().equals("Hard level")){
                    level.setText("Easy level");
                    save ("Difficulty","Easy level");
                } else if (level.getText().equals("Easy level")){
                    level.setText("Medium level");
                    save ("Difficulty","Medium level");
                } else if (level.getText().equals("Medium level")){
                    level.setText("Hard level");
                    save ("Difficulty","Hard level");
                }
            }
        });

    }
    public String load (String str){
        return mySettings.getString(str,"0");
    }
    public void save (String key, String str){
        Editor editor = mySettings.edit();
        editor.putString(key,str);
        editor.commit();
    }
}
