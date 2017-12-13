package mtrzepacz.activitylifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button buttonGotoThirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonGotoThirdActivity = (Button) findViewById(R.id.buttonGotoThird);
        buttonGotoThirdActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                gotoThirdActivity();
            }
        });
    }

    public void onBackPressed()
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.finish();
        startActivity(intent);
    }

    public void gotoThirdActivity()
    {
        Intent intent = new Intent(this,ThirdActivity.class);
        this.finish();
        startActivity(intent);

    }


}
