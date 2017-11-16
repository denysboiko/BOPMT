package org.reach_info.ukraine_dev.bopmt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.reach_info.ukraine_dev.bopmt.R;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.geometry.ILatLng;
import android.widget.Toast;

import com.mapbox.mapboxsdk.maps.Projection;
//import com.mapbox.mapboxsdk.geometry.GeoPoint;
//package()

public class SimpleMapViewActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        Mapbox.getInstance(this, getString(R.string.access_token));

        // This contains the MapView in XML and needs to be called after the account manager
        setContentView(R.layout.activity_simple_map_view);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

                // Customize map with markers, polylines, etc.
                mapboxMap.setOnMapClickListener(new MapboxMap.OnMapClickListener() {

                    @Override
                    public void onMapClick(ILatLng point) {
                        Toast.makeText(getApplicationContext(),, "Click event: "+point.toString(), Toast.LENGTH_SHORT).show();
//                        mapboxMap.addMarker(new MarkerOptions()
//                                .icon(/* make a marker bubble icon */)
//                                .position(point));

                    }

                });
            }
        });
    }

//    @Override
//    public void onTapMap(MapView mapView, ILatLng iLatLng) {
//        Toast toast = Toast.makeText(getApplicationContext(), "Longitude: "+ 1 +" Latitude: "+ 2 , Toast.LENGTH_LONG);
//        toast.show();

//        return super.onTapMap(mapView, iLatLng);

//    }
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        int actionType = ev.getAction();
//        switch (actionType) {
//            case MotionEvent.ACTION_UP:
//
//                Projection proj = mapView.getProjection();
//                GeoPoint loc = proj.fromPixels((int)ev.getX(), (int)ev.getY());
//                String longitude = Double.toString(((double)loc.getLongitudeE6())/1000000);
//                String latitude = Double.toString(((double)loc.getLatitudeE6())/1000000);
//
//                Toast toast = Toast.makeText(getApplicationContext(), "Longitude: "+ 1 +" Latitude: "+ 2 , Toast.LENGTH_LONG);
//                toast.show();
//
//        }
//
//        return super.dispatchTouchEvent(ev);
//    }



    // Add the mapView lifecycle to the activity's lifecycle methods
    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
//
//
//    mapView.setMapViewListener(new MapViewListener() {
//
//    });



}

