package com.example.buoi4;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button button;
    private Button button2;
    private EditText editText;
    private RelativeLayout relativeLayout;
    public Timer timer = new Timer();
    public MyTimer myTimer = new MyTimer();
    private GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =(TextView) findViewById(R.id.tvw);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(this);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Anh yêu em");
            }
        });*/
        button2 =(Button)findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        relativeLayout =(RelativeLayout) findViewById(R.id.view);
        gifImageView = (GifImageView) findViewById(R.id.gif);

    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(MainActivity.this,"hacker",Toast.LENGTH_LONG).show();
        AlertDialog.Builder alDlog = new AlertDialog.Builder(MainActivity.this);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.summertime);
        MediaPlayer mediaPlayer2 = MediaPlayer.create(this,R.raw.eren);
        MediaPlayer mediaPlayer3 = MediaPlayer.create(this,R.raw.mii);
        alDlog.setIcon(R.drawable.ic_baseline_favorite_24);
        alDlog.setTitle("Mình muốn hỏi là:");
        alDlog.setMessage("Bạn đồng ý làm bạn gái mình nhééééé!!!!");
        alDlog.setPositiveButton("Mình đồng ý!!!!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                textView.setText("I love you :>");
                textView.setTextColor(Color.RED);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,40);
                relativeLayout.setBackgroundColor(Color.rgb(253,166,253));
                startAnimation();
                timer.schedule(myTimer,500,500);
                button.setVisibility(button.INVISIBLE);
                mediaPlayer.start();
                gifImageView.setBackgroundResource(R.drawable.gif);


            }
        });
        alDlog.setNegativeButton("Chê", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textView.setText("Hu hu T_T");
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,40);
                relativeLayout.setBackgroundColor(Color.GRAY);
                startAnimation2();
                button.setVisibility(button.INVISIBLE);
                mediaPlayer2.start();
                gifImageView.setBackgroundResource(R.drawable.erenyeager);

            }
        });
        alDlog.setNeutralButton("Hông biết nữa :)))", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Ơ kìa, nói gì đi chứ :(((", Toast.LENGTH_LONG).show();
                textView.setTypeface(Typeface.DEFAULT);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,40);
                textView.setTextColor(Color.BLACK);
                relativeLayout.setBackgroundColor(Color.WHITE);
                textView.setText("????????????");
                mediaPlayer3.start();

            }
        });
        alDlog.show();

    }
    private void startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        textView.startAnimation(animation);

    }
    private void startAnimation2(){
        Animation animationIN = AnimationUtils.loadAnimation(this, R.anim.anim_in);
        textView.startAnimation(animationIN);
    }
    private class MyTimer extends TimerTask{
        @Override
        public void run(){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    textView.setTextColor(Color.rgb(255,random.nextInt(256),random.nextInt(256)));
                }
            });
        }
    }
    /*public void doitext(View view) {
        textView.setText("Anh yêu eam");
    }*/
}