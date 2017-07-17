package sanilk.com.quoteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class NewQuote extends AppCompatActivity {
    TextView currentQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_quote);

        String[] quotes=getResources().getStringArray(R.array.quotes);

        Random random=new Random();
        int i= random.nextInt(quotes.length);

        currentQuote=(TextView)findViewById(R.id.current_quote);
        currentQuote.setText(quotes[i]);
    }
}
