package com.vignesh.annauniv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class KeyboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
    }
    
    public void sendData(String data){
    	new SendMessageAsync().execute(new String[] {""+data});
    }

    public void a_clicked(View view)
    {
        sendData("VK_A");
    }
    public void b_clicked(View view)
    {
    	sendData("VK_B");
    }
    public void c_clicked(View view)
    {
    	sendData("VK_C");
    }
    public void d_clicked(View view)
    {
        sendData("VK_D");
    }
    public void e_clicked(View view)
    {
    	sendData("VK_E");
    }
    public void f_clicked(View view)
    {
    	sendData("VK_F");
    }
    public void g_clicked(View view)
    {
    	sendData("VK_G");
    }
    public void h_clicked(View view)
    {
    	sendData("VK_H");
    }
    public void i_clicked(View view)
    {
    	sendData("VK_I");
    }
    public void j_clicked(View view)
    {
    	sendData("VK_J");
    }
    public void k_clicked(View view)
    {
    	sendData("VK_K");
    }
    public void l_clicked(View view)
    {
    	sendData("VK_L");
    }
    public void m_clicked(View view)
    {
    	sendData("VK_M");
    }
    public void n_clicked(View view)
    {
    	sendData("VK_N");
    }
    public void o_clicked(View view)
    {
    	sendData("VK_O");
    }
    public void p_clicked(View view)
    {
    	sendData("VK_P");
    }
    public void q_clicked(View view)
    {
    	sendData("VK_Q");
    }
    public void r_clicked(View view)
    {
    	sendData("VK_R");
    }
    public void s_clicked(View view)
    {
    	sendData("VK_S");
    }
    public void t_clicked(View view)
    {
    	sendData("VK_T");
    }
    public void u_clicked(View view)
    {
    	sendData("VK_U");
    }
    public void v_clicked(View view)
    {
    	sendData("VK_V");
    }
    public void w_clicked(View view)
    {
    	sendData("VK_W");
    }
    public void x_clicked(View view)
    {
    	sendData("VK_X");
    }
    public void y_clicked(View view)
    {
    	sendData("VK_Y");
    }
    public void z_clicked(View view)
    {
    	sendData("VK_Z");
    }
    public void space_clicked(View view)
    {
    	sendData("space");
    }
    public void backspace_clicked(View view)
    {
    	sendData("back");
    }
    public void left_clicked(View view)
    {
    	sendData("left");
    }
    public void right_clicked(View view)
    {
    	sendData("right");
    }
    public void top_clicked(View view)
    {
    	sendData("up");
    }
    public void bottom_clicked(View view)
    {
    	sendData("down");
    }
    
    public void enter_clicked(View v){
    	sendData("enter");
    }
    public void back_clicked(View view)
    {
    	sendData("back");
    }
    public void close_clicked(View view)
    {
    	sendData("close");
    }
    public void shut_clicked(View view)
    {
    	sendData("shutdown");
    }
    public void sleep_clicked(View view)
    {
    	sendData("sleep");
    }
    public void logoff_clicked(View view)
    {
    	sendData("logoff");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
