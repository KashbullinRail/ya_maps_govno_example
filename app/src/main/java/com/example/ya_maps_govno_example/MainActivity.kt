package com.example.ya_maps_govno_example

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MainActivity : AppCompatActivity() {

    private val TARGET_LOCATION = Point(55.763740752167465, 37.40582814075713)
    private var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Now MapView can be created.
        // Now MapView can be created.
        MapKitFactory.setApiKey("05ee083d-246d-421d-9956-0a76757d842a")
        MapKitFactory.initialize(this)
        setContentView(R.layout.map)

        mapView = findViewById<View>(R.id.mapview) as MapView
        // And to show what can be done with it, we move the camera to the center of Saint Petersburg.
        // And to show what can be done with it, we move the camera to the center of Saint Petersburg.
        mapView?.getMap()?.move(
            CameraPosition(TARGET_LOCATION, 17.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5f),
            null
        )
    }

    override fun onStop() {
        mapView?.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView?.onStart()
    }
}