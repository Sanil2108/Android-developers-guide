package sanilk.com.menuactivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. Create an instance of our fragment
        MenuFragment fragment=new MenuFragment();

        //2. get a fragment manager
        FragmentManager fragmentManager=getSupportFragmentManager();
        //3. then, we get an instance of FragmentTransaction from fragmentManager
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //4. We add the layout and the fragment to the transaction
        fragmentTransaction=fragmentTransaction.add(R.id.main_activity_fragment_container, fragment);
        //5. finally we commit the transaction.
        fragmentTransaction.commit();
    }
}