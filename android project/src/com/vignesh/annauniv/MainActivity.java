package com.vignesh.annauniv;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

/**
 * Created by sibhi on 04/04/15.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Animation animBou_left = AnimationUtils.loadAnimation(this, R.anim.bounce_left);
        final Animation animBou_right = AnimationUtils.loadAnimation(this, R.anim.bounce_right);
        final Animation animBou_fromdown = AnimationUtils.loadAnimation(this, R.anim.bounce_fromdown);

        ImageButton but_mouse = (ImageButton) findViewById(R.id.but_mouse);
        ImageButton but_keyb = (ImageButton) findViewById(R.id.but_keyb);
        ImageButton but_multi = (ImageButton) findViewById(R.id.but_multi);
        ImageButton but_motion = (ImageButton) findViewById(R.id.but_motion);

        but_mouse.startAnimation(animBou_left);
        but_motion.startAnimation(animBou_fromdown);
        but_keyb.startAnimation(animBou_right);
        but_multi.startAnimation(animBou_fromdown);


    }

public void open_keyb(View view)
{
    Intent i = new Intent(getApplicationContext(), KeyboardActivity.class);
    startActivity(i);
}
    public void open_multi(View view)
    {
        Intent i = new Intent(getApplicationContext(), MediaPlayerControllActivity.class);
        startActivity(i);
    }
 
    public void mouse_activity(View v){
    	Intent i = new Intent(getApplicationContext(), MouseActivity.class);
    	new SendMessageAsync().execute(new String[] {"mouse_starts"});
        startActivity(i);
    }
    
   
    public void sensorcontroll(View view){
		Intent intent=new Intent(this, SensorRecognition.class);
    	startActivity(intent);
	}
    
    public void sendData(String data){
    	new SendMessageAsync().execute(new String[] {""+data});
    }
}
