package sanilk.com.menuactivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {
    Button button1, button2, button3, button4, button5;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        button1 = (Button)view.findViewById(R.id.button1);
        button2 = (Button)view.findViewById(R.id.button2);
        button3 = (Button)view.findViewById(R.id.button3);
        button4 = (Button)view.findViewById(R.id.button4);
        button5 = (Button)view.findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pass in 1 as the button number
                startDetailsActivity(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pass in 2 as the button number
                startDetailsActivity(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pass in 3 as the button number
                startDetailsActivity(3);
            }
        });

        return view;
    }

    public void startDetailsActivity(int buttonNumber){
        //Create the intent
        Intent intent=new Intent(getActivity().getApplicationContext(), DetailActivity.class);

        //put the button number that was clicked
        intent.putExtra("buttonNumber", buttonNumber);

        //finally, start the activity
        startActivity(intent);
    }

}
