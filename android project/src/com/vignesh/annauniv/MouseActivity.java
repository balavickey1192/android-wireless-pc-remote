package com.vignesh.annauniv;

import java.util.Date;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MouseActivity extends Activity implements OnTouchListener {
	
    // Message types sent from the BluetoothChatService Handler
    public int prevX,prevY;
    // Key names received from the BluetoothCommandService Handler
    public int touchPointX, touchPointY;
	public Date earlier;
	public TextView mouse_point;
	public Date press_date;
	boolean moveMouse=false;
	boolean dragAndDrop=false;
	boolean longPressed=false;
	int longPressTiming = 500;
	int totalPointers = 0;
	int waitingTimeForPointers = 70;
    //sensor
    public SensorManager sensorManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse);
        mouse_point = (TextView)findViewById(R.id.mouse_point);
        // Set up the custom title
		RelativeLayout rel=(RelativeLayout)findViewById(R.id.mouse_view);
		rel.setOnTouchListener(this);
        // If the adapter is null, then Bluetooth is not supported
	}
	
	final Handler handler = new Handler(); 
	Runnable mLongPressed = new Runnable() { 
	    public void run() { 
	    	Toast.makeText(getApplicationContext(), "Long press", Toast.LENGTH_SHORT).show();
	    	longPressed=true;
	    }   
	};
	
	final Handler handler_pointer = new Handler(); 
	Runnable mPointerRunnable = new Runnable() { 
	    public void run() { 
//	    	Toast.makeText(getApplicationContext(), "Total pointers: "+ totalPointers, Toast.LENGTH_SHORT).show();
	    	if (totalPointers ==2) {
				sendData("right_mouse_click");
				//send co ordinates
            } else if (totalPointers ==4) {
    			sendData("four_finger_movement");
            }
	    }   
	};
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		  int eventaction = event.getActionMasked();
		    int x,y;
		    x=(int) event.getX();
        	y=(int) event.getY();
		    switch (eventaction) {
		        case MotionEvent.ACTION_DOWN: 
		        	//touched the screen
		        	totalPointers = 1;
					
		        	press_date= new Date();
		        	handler.postDelayed(mLongPressed, longPressTiming);
		        	mouse_point.setText("X:"+x+" Y:"+y);
		        	moveMouse=false;
		        	prevX=x;
		        	prevY=y;
		            break;
		        case MotionEvent.ACTION_POINTER_DOWN:
		        	totalPointers++;
//		        	Toast.makeText(this, "Pointer down: "+event.getPointerCount(), Toast.LENGTH_SHORT).show();
		        	handler_pointer.removeCallbacks(mPointerRunnable);
		        	handler_pointer.postDelayed(mPointerRunnable, waitingTimeForPointers);
		        	break;
		            
		        case MotionEvent.ACTION_MOVE:
//		        	totalPointers = 0;
		            // finger moves on the screen
		        	handler.removeCallbacks(mLongPressed);
		        	mouse_point.setText("X:"+x+" Y:"+y);
		        	moveMouse=true;
		        	int moveX,moveY;
		        	moveX=x-prevX;
		        	prevX=x;
		        	moveY=y-prevY;
		        	prevY=y;
		        	
		        	if(longPressed){
		        			if(!dragAndDrop){
		        				sendData("drag_and_drop_start");
		        				dragAndDrop=true;
		        			}
				    	sendData(moveX+","+moveY);
				    	
		        	} else if(totalPointers==3){
		        		if(!dragAndDrop){
	        				sendData("drag_and_drop_start");
	        				dragAndDrop=true;
	        			}
		        		sendData(moveX+","+moveY);
		        	}
		        		else{
		    			sendData(moveX+","+moveY);
		        	}
		        	
		            break;
		        case MotionEvent.ACTION_UP:
//		        	totalPointers = 0;
		        	handler.removeCallbacks(mLongPressed);
		        	if(dragAndDrop){
						sendData("drag_and_drop_stop");
    				}
		        	longPressed=false;
					dragAndDrop=false;
					
		        	Date release_date = new Date();
		        	long second_lapsed=(release_date.getTime()-press_date.getTime())/1000;
		        	if(second_lapsed<.005 && !moveMouse){
		        		//new click arrived
//		        		Toast.makeText(this, "select time:"+second_lapsed, Toast.LENGTH_SHORT).show();
			    		sendData("select");
			    		
		        	}
		        	
		        	moveMouse=false;
		            break;
		    }
		    return true; 
	}
	public void sendData(String str) {
		new SendMessageAsync().execute(new String[] {""+str});
	}
	
	@Override
	public void onBackPressed()
	{
		sendData("mouse_closed");
	    finish();  
	}
}
