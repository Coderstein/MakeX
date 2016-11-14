package de.freshmaninandroid.app_programmierung.makex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameMainActivity extends AppCompatActivity implements View.OnClickListener {
    public int clickNumber1;
    public int clickNumber2;
    int points;
    Button[] buttons = new Button[8]; // Create an Array of Buttons
    Button buttonOff;
    TextView pointView;
    TextView titleView;
    TextView subtitleView1;
    TextView subtitle_view;

    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);
        System.out.print("it is alive");
        pointView = (TextView) findViewById(R.id.point_view);   //Now we determine findViewById
        //  for textView(s)
        titleView = (TextView) findViewById(R.id.title_view);
        subtitle_view = (TextView) findViewById(R.id.subtitle_view);
        subtitleView1 = (TextView) findViewById(R.id.subtitle1_view);

        buttons[0] = (Button) findViewById(R.id.btn_click1);    // and buttons
        buttons[1] = (Button) findViewById(R.id.btn_click2);
        buttons[2] = (Button) findViewById(R.id.btn_click3);
        buttons[3] = (Button) findViewById(R.id.btn_click4);
        buttons[4] = (Button) findViewById(R.id.btn_click5);
        buttons[5] = (Button) findViewById(R.id.btn_click6);
        buttons[6] = (Button) findViewById(R.id.btn_click7);
        buttons[7] = (Button) findViewById(R.id.btn_click8);
        buttons[8] = (Button) findViewById(R.id.btn_click9);
        buttonOff = (Button) findViewById(R.id.btn_turnoff);
        for (int i = 0; i < 9; i++) {
            buttons[i].setOnClickListener(this);
            buttons[i].setEnabled(false);


        }

    }


    public void stopTheGame(View v) {   // stop the game method 
     
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
                buttons[i].setText(R.string.button_digit);
                pointView.setText((R.string.points));
                result = 0;
                points = 0;
                subtitle_view.setText(R.string.subtitle_text);
                subtitleView1.setText(R.string.subtitle1_text);
            

        }
    }

    public void generateNumbers() {
        Random r = new Random();
        for (int i = 0; i < 9; i++) {
            buttons[i].setText(String.valueOf(r.nextInt(9)));
            buttons[i].setEnabled(true);
        }
    }

    public void startTheGame(View v) {   // start the game method
        generateNumbers();
        pointView.setText(String.valueOf(0));


    }


    @Override
    public void onClick(View v) { // OnClickListeners method implementation
        clickNumber1++;
            Button button = (Button) v;
            int buttonText = Integer.parseInt(button.getText().toString());
            result += buttonText;
            if (clickNumber1 == 1) {
                subtitle_view.setText(buttonText + "" + "    +    ");
            } else {
                subtitleView1.setText(buttonText + "");
            }
            if (clickNumber1 == 2 && result == 10) {
                Log.v("Result from Button", String.valueOf(result));
                generateNumbers();
                clickNumber1 = 0;
                points++;
                pointView.setText(points + "");
                Log.v("points", points + "");
                result = 0;

            } else if (clickNumber1 == 2 && result != 10) {
                clickNumber1 = 0;
                result = 0;
                generateNumbers();
                Log.v("Clicks", String.valueOf(clickNumber1));
                points--;
                pointView.setText(points + "");
            }      
    }
}
