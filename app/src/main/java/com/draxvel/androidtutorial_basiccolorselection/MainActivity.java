package com.draxvel.androidtutorial_basiccolorselection;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private int red;
    private int green;
    private int blue;

    private int maxColor = 255;

    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

    private ImageView imageView;
    private TextView textView;

    private Button buttonRed;
    private Button buttonOrange;
    private Button buttonYellow;
    private Button buttonGreen;
    private Button buttonBlue;
    private Button buttonIndigo;
    private Button buttonViolet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents() {
        red = 0;
        green = 0;
        blue = 0;

        seekBarRed = (SeekBar) findViewById(R.id.seekBarRed);
        seekBarRed.setMax(maxColor);
        seekBarGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        seekBarGreen.setMax(maxColor);
        seekBarBlue = (SeekBar) findViewById(R.id.seekBarBlue);
        seekBarBlue.setMax(maxColor);

        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);
        seekBarBlue.setOnSeekBarChangeListener(this);

        imageView  = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);

        buttonRed = (Button) findViewById(R.id.buttonRed);
        buttonOrange = (Button) findViewById(R.id.buttonOrange);
        buttonYellow = (Button) findViewById(R.id.buttonYellow);
        buttonGreen = (Button) findViewById(R.id.buttonGreen);
        buttonBlue = (Button) findViewById(R.id.buttonBlue);
        buttonIndigo = (Button) findViewById(R.id.buttonIndigo);
        buttonViolet = (Button) findViewById(R.id.buttonViolet);

        buttonRed.setOnClickListener(this);
        buttonOrange.setOnClickListener(this);
        buttonYellow.setOnClickListener(this);
        buttonGreen.setOnClickListener(this);
        buttonBlue.setOnClickListener(this);
        buttonIndigo.setOnClickListener(this);
        buttonViolet.setOnClickListener(this);
    }

    private void setDateToUI(int red, int green, int blue){
        imageView.setBackgroundColor(Color.argb(255, red, green, blue));

        String hexColor = String.format("#%06X", (0xFFFFFF & Color.argb(255, red, green, blue)));
        textView.setText(red+", "+green+", "+blue+" | "+hexColor);
    }

    private  void setSeekBarValue(int red, int green, int blue){
        seekBarRed.setProgress(red);
        seekBarGreen.setProgress(green);
        seekBarBlue.setProgress(blue);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonRed: {
                red = 255;
                green = 0;
                blue = 0;
                break;
            }

            case R.id.buttonOrange: {
                red = 255;
                green = 127;
                blue = 0;
                break;
            }

            case R.id.buttonYellow: {
                red = 255;
                green = 255;
                blue = 0;
                break;
            }

            case R.id.buttonGreen: {
                red = 0;
                green = 255;
                blue = 0;
                break;
            }

            case R.id.buttonBlue: {
                red = 0;
                green = 0;
                blue = 255;
                break;
            }

            case R.id.buttonIndigo: {
                red = 74;
                green = 0;
                blue = 130;
                break;
            }

            case R.id.buttonViolet: {
                red = 148;
                green = 0;
                blue = 211;
                break;
            }
        }
        setDateToUI(red, green, blue);
        setSeekBarValue(red, green, blue);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId())
        {
            case R.id.seekBarRed:
            {
                red = seekBar.getProgress();
                break;
            }
            case R.id.seekBarGreen:
            {
                green = seekBar.getProgress();
                break;
            }
            case R.id.seekBarBlue:
            {
                blue = seekBar.getProgress();
                break;
            }
        }
        setDateToUI(red, green, blue);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
