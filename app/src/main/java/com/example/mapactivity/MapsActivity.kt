package com.example.mapactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var lstLatLang = mutableListOf<LatLongi>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

//        // Add a marker in Sydney and move the camera
//        val college = LatLng(27.7062581,85.3300012)
//        mMap.addMarker(MarkerOptions().position(college).title("Marker in College"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(college))

        lstLatLang.add(LatLongi(27.7062581,85.3300012, "Block E"));
        lstLatLang.add(LatLongi(27.7057244,85.3279674, "Block C"));

        for(location in lstLatLang){
            mMap.addMarker(
                    MarkerOptions().position(LatLng(location.lat, location.lang)).title(location.markerName)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            )
        }

        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(LatLng(27.7062581,85.3300012), 15F), 3000, null
        )
        mMap.uiSettings.isZoomControlsEnabled = true
    }
}