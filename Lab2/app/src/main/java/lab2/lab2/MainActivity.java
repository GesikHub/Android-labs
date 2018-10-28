package lab2.lab2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mHelloTextView;
    private Boolean stateKitty;
    private EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mHelloTextView = (TextView)findViewById(R.id.textView);
        mNameEditText = (EditText) findViewById(R.id.editText);
        stateKitty = Boolean.TRUE;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickMainButton(View view) {
        if (stateKitty) {
            stateKitty = Boolean.FALSE;
            if (mNameEditText.getText().length() == 0) {
                mHelloTextView.setText("Hello Kitty!");
            } else {
                mHelloTextView.setText("Привет, " + mNameEditText.getText());
            }
        }
        else {
            stateKitty = Boolean.TRUE;
            if (mNameEditText.getText().length() == 0) {
                mHelloTextView.setText("Goodbye Kitty!");
            } else {
                mHelloTextView.setText("Пока, " + mNameEditText.getText());
            }
        }
    }
}
