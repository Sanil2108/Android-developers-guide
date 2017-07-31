package sanilk.com.menuactivity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int buttonNumber = getIntent().getIntExtra("buttonNumber", -1);

        //Create the Bundle object
        Bundle bundle = new Bundle();
        //Put the number in it with String key as buttonNumber
        bundle.putInt("buttonNumber", buttonNumber);

        DetailFragment detailFragment = new DetailFragment();

        //Pass in the bundle object
        detailFragment.setArguments(bundle);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction().add(R.id.detail_activity_fragment_container, detailFragment);
        fragmentTransaction.commit();
    }
}
