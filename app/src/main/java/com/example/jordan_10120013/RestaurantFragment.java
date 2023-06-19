package com.example.jordan_10120013;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jordan_10120013.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

// NIM : 10120013
// NAMA : JORDAN JANUAR ILHAMI G
// KELAS : IF 1
public class RestaurantFragment extends Fragment {

    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restauran, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.my_map);

        getLocation();
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(location -> {
            if(location != null){
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        LatLng lokasi1 = new LatLng(-6.876804874248837, 107.55995128945929);
                        MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Nangkring Seblak (Cimahi)");
                        googleMap.addMarker(options1);
                        LatLng lokasi2 = new LatLng(-6.877697355988882, 107.55927707720492);
                        MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("MIELIA ( Mie level & Dimsum Premium )");
                        googleMap.addMarker(options2);
                        LatLng lokasi3 = new LatLng(-6.875418040757273, 107.56031526966805);
                        MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Donat menak");
                        googleMap.addMarker(options3);
                        LatLng lokasi4 = new LatLng(-6.876758436021692, 107.55764330260237);
                        MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Baso Aci Moikafood");
                        googleMap.addMarker(options4);
                        LatLng lokasi5 = new LatLng(-6.876427082209436, 107.56000712878564);
                        MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Three Roots Barber and Coffeeshop");
                        googleMap.addMarker(options5);
                        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi2,16));
                    }
                });
            }
        });
    }
}