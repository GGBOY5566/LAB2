package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ed;
    private TextView tv_winner,tv_name,tv_text,tv_m_mora,tv_c_mora;
    private RadioButton paper,scissor,stone;
    private Button mora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.ed);
        tv_winner = findViewById(R.id.tv_winner);
        tv_name = findViewById(R.id.tv_name);
        tv_text = findViewById(R.id.tv_text);
        tv_m_mora = findViewById(R.id.tv_m_mora);
        tv_c_mora = findViewById(R.id.tv_c_mora);
        paper = findViewById(R.id.paper);
        scissor = findViewById(R.id.scissor);
        stone = findViewById(R.id.stone);
        mora = findViewById(R.id.mora);

        mora.setOnClickListener(view -> {
            if (ed.length() < 1){
                tv_text.setText("請輸入玩家姓名");
            }else {
                tv_name.setText(String.format("名字\n%s", ed.getText().toString()));

                if (scissor.isChecked()){
                    tv_m_mora.setText("我方出拳\n剪刀");
                } else if (stone.isChecked()){
                    tv_m_mora.setText("我方出拳\n石頭");
                } else if (paper.isChecked()){
                    tv_m_mora.setText("我方出拳\n布");
                }

                int computer_random = (int) (Math.random()*3);

                if (computer_random == 0) {
                    tv_c_mora.setText("電腦出拳\n剪刀");
                } else if (computer_random == 1) {
                    tv_c_mora.setText("電腦出拳\n石頭");
                } else if (computer_random == 2) {
                    tv_c_mora.setText("電腦出拳\n布");
                }

                if ((scissor.isChecked() && computer_random == 2) || (stone.isChecked() && computer_random == 0) || (paper.isChecked() && computer_random == 1)){
                    tv_winner.setText("勝利者\n" + ed.getText().toString());
                    tv_text.setText("恭喜您獲勝!!!");
                } else if ((scissor.isChecked() && computer_random == 1) || (stone.isChecked() && computer_random == 2) || (paper.isChecked() && computer_random == 0)){
                    tv_winner.setText("勝利者\n電腦" );
                    tv_text.setText("輸家!!!");
                } else {
                    tv_winner.setText("勝利者\n平手");
                    tv_text.setText("平手!!!");
                }
            }
        });
    }
}