package com.vignesh.annauniv;

import java.util.Date;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SensorRecognition extends Activity implements SensorEventListener {
	public Date earlier;
	public SensorManager sensorManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor);
		
		
		sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(SensorRecognition.this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(SensorRecognition.this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL);
        earlier=new Date();
	}
	@Override
    public void onAccuracyChanged(Sensor arg0, int arg1){}
	@Override
	protected void onStop() {
	  super.onPause();
	  sensorManager.unregisterListener(SensorRecognition.this);
	  Log.i("finishing activity on stop()","finish()");
	  finish();
	}
	
	@Override
	public void onBackPressed()
	{
		sensorManager.unregisterListener(SensorRecognition.this);
		Log.i("finishing activity from on back","finish()");
	    finish();  
	}
    @Override
    public void onSensorChanged(SensorEvent event){
    	if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
    		String sensorReading;
    		sensorReading= "x="+Math.round(event.values[0])+" y="+Math.round(event.values[1])+"z="+Math.round(event.values[2]);
    		TextView sensorTextView=(TextView)findViewById(R.id.sensor_text);
    		
    		Date now=new Date();
    		
    		if(((now.getTime()-earlier.getTime())/1000)>.2){
    			earlier=now;
    			sensorReading+=" sec:"+(now.getTime()-earlier.getTime())/1000;
    			sensorTextView.setText(sensorReading);
    			if(event.values[0]<(-5)){
    				sendData("right");
    			} else if(event.values[0]>5){
    				sendData("left");
    			} else if(event.values[1]>5){
    				sendData("up");
    			} else if(event.values[1]<(-5)){
    				sendData("down");
    			}
    		}
    	}
    	//Toast.makeText(this, "event 0:"+event.values[0], Toast.LENGTH_SHORT).show();
    	
    	if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
    		if(event.values[0]<4){
    			sendData("enter");
    		}
    	}
    	
    }
    public void sendData(String data){
    	new SendMessageAsync().execute(new String[] {""+data});
    }
}
