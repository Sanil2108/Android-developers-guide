package sanilk.com.implicitintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Just declaring the objects we will use
    Button button;
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiating the new objects
        button=(Button)findViewById(R.id.submit_query);
        textField=(EditText)findViewById(R.id.edit_query);

        //View.OnClickListener is an interface and we can also do it like this -
//        View.OnClickListener listener=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        };
//        button.setOnClickListener(listener);
        //The above method is just a little longer but I wanted to explain it to you if you are not
        //completely clear on interfaces and anonymous classes
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String site=textField.getText().toString();

                //Checking if user typed "http:\\"
                if(!site.contains("http:\\\\")){
                    //If this part of code executes, that means that the user has not typed "http:\\"
                    site="http:\\\\"+site;
                }


                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(site));
//                intent.setData(Uri.parse(site));
//                startActivity(intent);

                //Starting this intent will force the user to choose a particular app every time
                Intent chooser = Intent.createChooser(intent, "Choose a browser");
                startActivity(chooser);
            }
        });
    }
}
