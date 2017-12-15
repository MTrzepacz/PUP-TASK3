package mtrzepacz.activitylifecycle;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {


    private static int counter = 0;
    private String message;
    private String keyMessage, keyCounter;
    private TextView textView;
    private EditText editText;

    @Override
    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context,"on config changed",Toast.LENGTH_SHORT);
        toast.show();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            counter++;
           // message = editText.getText().toString();
            textView.setText("" + counter);
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            counter++;
           // message = editText.getText().toString();
            textView.setText("" + counter);
        }

    }
    @Override
    protected  void onStart()
    {
            super.onStart();
          //  counter++;
            textView.setText("" + counter);

    }
  /*  @Override
    protected void onSaveInstanceState( Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(keyCounter,counter);
        savedInstanceState.putString(keyMessage, message);

    }
    @Override
    protected  void onRestoreInstanceState( Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt(keyCounter);
        message = savedInstanceState.getString(keyMessage);
        textView.setText("" + counter);
    } */
    @Override
    protected void onResume()
    {
        super.onResume();
       // counter++;
        textView.setText("" + counter);
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        textView.setText("" + counter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView = (TextView) findViewById(R.id.textViewCounter);
        editText = (EditText) findViewById(R.id.editTextMessage);
    }
    public void onBackPressed()
    {
        this.finish();
        counter = 0;
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
