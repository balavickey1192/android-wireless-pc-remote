package com.vignesh.annauniv;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import android.os.AsyncTask;
public class SendMessageAsync extends AsyncTask<String, Void, String>
{
	public static String IPAddress = "192.168.164.1";
	@Override
	protected String doInBackground(String... data) {
		try {			
			DatagramSocket clientSocket = new DatagramSocket();
		    InetAddress IPAddress = InetAddress.getByName(SendMessageAsync.IPAddress);
		    byte[] sendData = new byte[1024];
		    sendData = data[0].getBytes();
		    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8010);
		    clientSocket.send(sendPacket);
		    clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "done";
	}
}