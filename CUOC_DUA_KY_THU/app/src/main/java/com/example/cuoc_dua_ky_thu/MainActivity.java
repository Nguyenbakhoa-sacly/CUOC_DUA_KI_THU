package com.example.cuoc_dua_ky_thu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //khai bao cac element
TextView txtdiemso;
ImageButton btnplay;
CheckBox checkbox3,checkbox2,checkbox1;
SeekBar seekbar3,seekbar2,seekbar1;
int sodiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        seekbar1.setEnabled(false);
        seekbar2.setEnabled(false);
        seekbar3.setEnabled(false);
        txtdiemso.setText(sodiem + "");
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override

            //ontick la moi lan 300(la 3 phan 10 giay) chay
            public void onTick(long l) {

                //random toc do chay cua con vat
               int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                //kiem tra win
                if(seekbar1.getProgress() >= seekbar1.getMax()){
                    this.cancel();

                    //bam vao play thi an play
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "ONE WIN" ,Toast.LENGTH_SHORT).show();

                    //cong tru diem so
                    if(checkbox1.isChecked()){
                        sodiem  +=5;
                        Toast.makeText(MainActivity.this, "Bạn được cộng 5 điểm!" ,Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem  -= 5 ;
                        Toast.makeText(MainActivity.this, "Bạn bị trừ 5 điểm!" ,Toast.LENGTH_SHORT).show();
                    }
                    txtdiemso.setText(sodiem + "");

                    EnableCheckbox();
                }

                //kiem tra win
                if(seekbar2.getProgress() >= seekbar2.getMax()){
                    this.cancel();

                    //bam vao play thi an play
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "TWO WIN" ,Toast.LENGTH_SHORT).show();

                    //cong tru diem so
                    if(checkbox2.isChecked()){
                        sodiem  +=5;
                        Toast.makeText(MainActivity.this, "Bạn được cộng 5 điểm!" ,Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem  -= 5 ;
                        Toast.makeText(MainActivity.this, "Bạn bị trừ 5 điểm!" ,Toast.LENGTH_SHORT).show();
                    }
                    txtdiemso.setText(sodiem + "");
                    EnableCheckbox();
                }

                //kiem tra win
                if (seekbar3.getProgress() >= seekbar3.getMax()){
                    this.cancel();

                    //bam vao play thi an play
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "THREE WIN" ,Toast.LENGTH_SHORT).show();

                    //cong tru diem so
                    if(checkbox3.isChecked()){
                        sodiem  += 5;
                        Toast.makeText(MainActivity.this, "Bạn được cộng 5 điểm!" ,Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem  -= 5 ;
                        Toast.makeText(MainActivity.this, "Bạn bị trừ 5 điểm!" ,Toast.LENGTH_SHORT).show();
                    }
                    txtdiemso.setText(sodiem + "");
                    EnableCheckbox();
                }

                //random ngau nhien
                seekbar1.setProgress(seekbar1.getProgress() + one);
                seekbar2.setProgress(seekbar2.getProgress() + two);
                seekbar3.setProgress(seekbar3.getProgress() + three);

            }

            @Override

            //khi nao ket thuc 60 giay la 60000
            public void onFinish() {

            }
        };

        //Nut play
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reset lai van moi
                if(checkbox1.isChecked()||checkbox2.isChecked()||checkbox3.isChecked()){
                    seekbar1.setProgress(0);
                    seekbar2.setProgress(0);
                    seekbar3.setProgress(0);
                    btnplay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckbox();
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //chi duoc check 1 trong 3
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    //bo check  2 va 3
                    checkbox2.setChecked(false);
                    checkbox3.setChecked(false);

            }
        });
        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              //bo check 1 va 3
                checkbox1.setChecked(false);
                checkbox3.setChecked(false);

            }
        });
        checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               //bo check 1 va 2
                checkbox1.setChecked(false);
                checkbox2.setChecked(false);
            }
        });
    }
    // cho tuong tac voi man hinh
    private void EnableCheckbox(){
        checkbox1.setEnabled(true);
        checkbox3.setEnabled(true);
        checkbox2.setEnabled(true);
    }

    //khong cho tuong tac voi man hinh
    private void DisableCheckbox(){
        checkbox1.setEnabled(false);
        checkbox2.setEnabled(false);
        checkbox3.setEnabled(false);
    }
    //anh xa cac element
    private void addControls() {
        txtdiemso = (TextView) findViewById(R.id.txtdiemso);
        btnplay = (ImageButton) findViewById(R.id.btnplay);
        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        seekbar1 = (SeekBar)  findViewById(R.id.seekbar1);
        seekbar2 = (SeekBar)  findViewById(R.id.seekbar2);
        seekbar3 = (SeekBar)  findViewById(R.id.seekbar3);
    }
}