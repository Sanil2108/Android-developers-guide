package sanilk.com.simpleapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.edit_query);

        //Code deleted from here
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            //The activity is restarted because of rotation of the device

            //Let's find the variable we stored
            String text = savedInstanceState.getString("editTextValue");
            editText.setText(text);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String text = editText.getText().toString();
        outState.putString("editTextValue", text);
    }
}
