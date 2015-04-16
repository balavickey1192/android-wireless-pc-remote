package com.vignesh.annauniv;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by sibhi on 05/04/15.
 */
public class MediaPlayerControllActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_player_controll);

        ImageView but_play = (ImageView) findViewById(R.id.but_play);
        ImageView but_stop = (ImageView) findViewById(R.id.but_stop);
        ImageView but_next = (ImageView) findViewById(R.id.but_next);
        ImageView but_previous = (ImageView) findViewById(R.id.but_previous);
        Animation bounce_left = AnimationUtils.loadAnimation(this, R.anim.bounce_left);
        Animation bounce_right = AnimationUtils.loadAnimation(this, R.anim.bounce_right);
        Animation bounce_top = AnimationUtils.loadAnimation(this, R.anim.bounce_top);
        Animation bounce_bottom = AnimationUtils.loadAnimation(this, R.anim.bounce_right);


        but_play.startAnimation(bounce_top);
        but_stop.startAnimation(bounce_bottom);
        but_previous.startAnimation(bounce_left);
        but_next.startAnimation(bounce_right);
    }
    public void play_button(View view){
    	new SendMessageAsync().execute(new String[] {"play"});
    }
    public void forward_button(View view){
    	new SendMessageAsync().execute(new String[] {"forward"});
    }
    public void backward_button(View view){
    	new SendMessageAsync().execute(new String[] {"backward"});
    }
    public void stop_button(View view){
    	new SendMessageAsync().execute(new String[] {"stop"});
    }
}
