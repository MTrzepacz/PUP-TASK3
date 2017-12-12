package mtrzepacz.activitylifecycle;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Button buttonCloseApplication, buttonGotoSecondActivity;
    Chronometer chronometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        buttonCloseApplication = (Button) findViewById(R.id.buttonCloseApp);
        buttonCloseApplication.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
               finish();
            }
        });
        buttonGotoSecondActivity = (Button) findViewById(R.id.buttonGoToSecondActivity);
        buttonGotoSecondActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                gotoSecondActivity();
            }
        });

        chronometer = (Chronometer) findViewById(R.id.chronometer2);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        chronometer.setFormat("Time running: %s");
    }

    private void gotoSecondActivity()
    {
        Intent intent = new Intent(this, SecondActivity.class);
        this.finish();
        startActivity(intent);
    }

    public void onBackPressed()
    {
        this.finish();
    }

}

