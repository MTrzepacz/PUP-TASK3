package mtrzepacz.activitylifecycle;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {


    Integer counter;
    String message,keyMessage, keyCounter;
    private TextView textView;
    private EditText editText;

    @Override
    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            counter++;
            message = editText.getText().toString();
            textView.setText("");
            textView.setText("????");
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            counter++;
            message = editText.getText().toString();
            textView.setText("");
            textView.setText("xxx");
        }

    }
  /*  @Override
    protected  void onStart()
    {
            super.onStart();
            counter = 0;
    } */
    @Override
    protected void onSaveInstanceState( Bundle savedInstanceState)
    {
        savedInstanceState.putInt(keyCounter,counter);
        savedInstanceState.putString(keyMessage, message);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    protected  void onRestoreInstanceState( Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt(keyCounter);
        message = savedInstanceState.getString(keyMessage);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null)
        {
             savedInstanceState.clear();
             counter  = savedInstanceState.getInt(keyCounter);
             message = savedInstanceState.getString(keyMessage);
             //editText.setText(message);
           //  textView.setText(counter);
        }
        else
        {
            counter = -1;
        }
        setContentView(R.layout.activity_third);
        counter++;
        textView = (TextView) findViewById(R.id.textViewCounter);
        textView.setText(counter.toString());
        editText = (EditText) findViewById(R.id.editTextMessage);
    }
    public void onBackPressed()
    {
        this.finish();
    }
}
