package sanilk.com.menuactivity;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    TextView detailTextView;
    TextView titleTextView;
    ImageView imageView;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        detailTextView = (TextView)view.findViewById(R.id.detail_description);
        titleTextView = (TextView)view.findViewById(R.id.detail_title);
        imageView = (ImageView)view.findViewById(R.id.detail_image);

        //Get the String arrays
        String[] names = getResources().getStringArray(R.array.item_names);
        String[] descriptions = getResources().getStringArray(R.array.item_descriptions);
        String[] images = getResources().getStringArray(R.array.item_images);

        //Get the bundle passed into the fragment by getArguments
        Bundle bundle = getArguments();
        //Find the integer by using the String key
        int buttonNumber = bundle.getInt("buttonNumber");

        //Now we have the button number that was clicked.
        //We use that like an index. We have to subtract 1 from
        //the buttonNumber because our String arrays are zero-indexed
        //(that means that the first item is at number 0)
        // and the integer buttonNumber is one-indexed.
        buttonNumber-=1;
        titleTextView.setText(names[buttonNumber]);
        detailTextView.setText(descriptions[buttonNumber]);

        //First we need the resource id of the image
        int resourceId = getResources().getIdentifier(images[buttonNumber], "drawable", getActivity().getPackageName());
        //Put the image in the ImageView
        imageView.setImageResource(resourceId);

        return view;
    }

}
