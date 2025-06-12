package com.example.m2tmdbapp2025

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m2tmdbapp2025.databinding.ActivitySensorDemoBinding

class SensorDemoActivity : AppCompatActivity() , OnSensorItemClickListener {
    private val LOGTAG = SensorDemoActivity::class.simpleName
    lateinit var binding: ActivitySensorDemoBinding
    lateinit var sensorListAdapter: SensorListAdapter
    lateinit var sensorManager: SensorManager
    private val sensors: ArrayList<Sensor> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySensorDemoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // init sensor list recycler view
        binding.sensorListRv.setHasFixedSize(true)
        binding.sensorListRv.layoutManager = LinearLayoutManager(this)
        sensorListAdapter = SensorListAdapter(sensors, this)
        binding.sensorListRv.adapter = sensorListAdapter

        // get device's available sensors list
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensors.addAll(sensorManager.getSensorList(Sensor.TYPE_ALL))
        sensorListAdapter.notifyDataSetChanged()

    }

    override fun onSensorItemClicked(position: Int) {
        Log.i(LOGTAG, "clicked at sensor position=$position")
    }
}