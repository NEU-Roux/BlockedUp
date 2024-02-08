package edu.northeastern.blockedup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static boolean started = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtons();
    }

    protected void setButtons(){

        Button startButton = findViewById(R.id.buttonStart);
        Button stopButton = findViewById(R.id.buttonStop);
        TextView textView = findViewById(R.id.textOutput);

        startButton.setOnClickListener(view -> {

            int count = 0;

            while(started){

                textView.setText(Integer.toString(++count));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Log.d("Debugging",Integer.toString(count));

                //adding a break to prevent an infinite loop
                if (count == 10) break;

            }

        });

        stopButton.setOnClickListener(view -> {

            Toast toast = Toast.makeText(this, "Halt", Toast.LENGTH_LONG);
            toast.show();

            started = false;
        });

    }
}