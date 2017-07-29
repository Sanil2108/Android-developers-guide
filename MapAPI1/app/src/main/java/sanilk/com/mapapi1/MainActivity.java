package sanilk.com.mapapi1;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        MapFragment mapFragment=new MapFragment();
        transaction.add(R.id.linear_layout, mapFragment);
        transaction.commit();

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng=new LatLng(28.537810, 77.295428);

        Bitmap icon= BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("test01", "drawable", getPackageName())).copy(Bitmap.Config.ARGB_8888, true);
        if(Build.VERSION.SDK_INT>=19){
            icon.setWidth(10);
            icon.setHeight(10);
        }

        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        googleMap.addMarker(new MarkerOptions().title("Home").position(latLng).icon(BitmapDescriptorFactory.fromBitmap(icon)));
    }
}
