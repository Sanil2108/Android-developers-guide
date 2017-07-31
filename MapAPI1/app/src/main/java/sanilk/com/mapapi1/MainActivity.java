package sanilk.com.mapapi1;

import android.Manifest;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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

public class MainActivity extends Activity implements OnMapReadyCallback, LocationListener{
    GoogleMap googleMap;

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
        LatLng latLng=new LatLng(29.537810, 77.295428);
        Bitmap icon= BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("test01", "drawable", getPackageName())).copy(Bitmap.Config.ARGB_8888, true);

        this.googleMap=googleMap;
        this.googleMap.setMyLocationEnabled(true);

    }

    @Override
    public void onLocationChanged(Location location) {
        Marker marker = googleMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 9));
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
