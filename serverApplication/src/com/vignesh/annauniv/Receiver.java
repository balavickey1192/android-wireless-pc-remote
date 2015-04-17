<<<<<<< HEAD
package com.vignesh.annauniv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Receiver extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextPane lblPossibleIpAddresses;
	public DatagramSocket serverSocket;
	public static int port;
	public static JFrame f;
	Point p;
	String decodedPath="";
    public static void main(String[] args) {
        port = 8010;
        f = new JFrame();
        Receiver receiver = new Receiver();
        receiver.setVisible(true);
        receiver.initiate_frame();
        receiver.run_receiver(8010);
    }
    public void initiate_frame(){

		URL url_path;
		try {
			String path = Receiver.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			try {
				decodedPath = URLDecoder.decode(path, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			url_path = (new File(decodedPath+"Spinner.gif").toURI().toURL());
			ImageIcon reel =  new ImageIcon(url_path);
            JLabel label = new JLabel(reel);
            reel.setImageObserver(label);
            f.getContentPane().add(label);
            f.setUndecorated(true);
            p = MouseInfo.getPointerInfo().getLocation();
            f.setBounds(p.x,p.y,55,55);
            f.setOpacity(0.55f);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    public Receiver(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setBackground(Color.WHITE);
    	setBounds(100,100,400,500);
    	setTitle("Java Server Application");
    	JPanel jp = new JPanel();
    	jp.setBorder(new EmptyBorder(5,5,5,5));
    	jp.setLayout(new BorderLayout(0,0));
    	setContentPane(jp);
    	jp.setBackground(Color.WHITE);
    	JLabel lblServerApplication = new JLabel("Server Application");
    	jp.add(lblServerApplication, BorderLayout.NORTH);
    	
    	lblPossibleIpAddresses = new JTextPane();
    	lblPossibleIpAddresses.setContentType("text/html");
    	jp.add(lblPossibleIpAddresses, BorderLayout.SOUTH);
    	
    }
    private void processCommand(String command) {
		try {
			Robot robot = new Robot();
			switch (command) {
	    	case "up":
	    		robot.keyPress(KeyEvent.VK_UP);
	    		System.out.println("UP");
	    		robot.keyRelease(KeyEvent.VK_UP);
	    		break;
	    	case "down":
	    		robot.keyPress(KeyEvent.VK_DOWN);
	    		System.out.println("DOWN");
	    		robot.keyRelease(KeyEvent.VK_DOWN);
	    		
	    		break;
	    	case "enter":
	    		robot.keyPress(KeyEvent.VK_ENTER);
	    		System.out.println("ENTER");
	    		robot.keyRelease(KeyEvent.VK_ENTER);
	    		break;
	    	case "back":
	    		robot.keyPress(KeyEvent.VK_BACK_SPACE);
	    		System.out.println("BACK");
	    		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	    		break;
	    	case "space":
	    		robot.keyPress(KeyEvent.VK_SPACE);
	    		System.out.println("space");
	    		robot.keyRelease(KeyEvent.VK_SPACE);
	    		break;
	    		
	    	case "VK_A":
	    		robot.keyPress(KeyEvent.VK_A);
	    		System.out.println("VK_A");
	    		robot.keyRelease(KeyEvent.VK_A);
	    		break;
	    	case "VK_B":
	    		robot.keyPress(KeyEvent.VK_B);
	    		System.out.println("VK_B");
	    		robot.keyRelease(KeyEvent.VK_B);
	    		break;
	    	case "VK_C":
	    		robot.keyPress(KeyEvent.VK_C);
	    		System.out.println("VK_C");
	    		robot.keyRelease(KeyEvent.VK_C);
	    		break;
	    	case "VK_D":
	    		robot.keyPress(KeyEvent.VK_D);
	    		System.out.println("VK_D");
	    		robot.keyRelease(KeyEvent.VK_D);
	    		break;
	    	case "VK_E":
	    		robot.keyPress(KeyEvent.VK_E);
	    		System.out.println("VK_E");
	    		robot.keyRelease(KeyEvent.VK_E);
	    		break;
	    	case "VK_F":
	    		robot.keyPress(KeyEvent.VK_F);
	    		System.out.println("VK_F");
	    		robot.keyRelease(KeyEvent.VK_F);
	    		break;
	    	case "VK_G":
	    		robot.keyPress(KeyEvent.VK_G);
	    		System.out.println("VK_G");
	    		robot.keyRelease(KeyEvent.VK_G);
	    		break;
	    	case "VK_H":
	    		robot.keyPress(KeyEvent.VK_H);
	    		System.out.println("VK_H");
	    		robot.keyRelease(KeyEvent.VK_H);
	    		break;
	    	case "VK_I":
	    		robot.keyPress(KeyEvent.VK_I);
	    		System.out.println("VK_I");
	    		robot.keyRelease(KeyEvent.VK_I);
	    		break;
	    	case "VK_J":
	    		robot.keyPress(KeyEvent.VK_J);
	    		System.out.println("VK_J");
	    		robot.keyRelease(KeyEvent.VK_J);
	    		break;
	    	case "VK_K":
	    		robot.keyPress(KeyEvent.VK_K);
	    		System.out.println("VK_K");
	    		robot.keyRelease(KeyEvent.VK_K);
	    		break;
	    	case "VK_L":
	    		robot.keyPress(KeyEvent.VK_L);
	    		System.out.println("VK_L");
	    		robot.keyRelease(KeyEvent.VK_L);
	    		break;
	    	case "VK_M":
	    		robot.keyPress(KeyEvent.VK_M);
	    		System.out.println("VK_M");
	    		robot.keyRelease(KeyEvent.VK_M);
	    		break;
	    	case "VK_N":
	    		robot.keyPress(KeyEvent.VK_N);
	    		System.out.println("VK_N");
	    		robot.keyRelease(KeyEvent.VK_N);
	    		break;
	    	case "VK_O":
	    		robot.keyPress(KeyEvent.VK_O);
	    		System.out.println("VK_O");
	    		robot.keyRelease(KeyEvent.VK_O);
	    		break;
	    	case "VK_P":
	    		robot.keyPress(KeyEvent.VK_P);
	    		System.out.println("VK_P");
	    		robot.keyRelease(KeyEvent.VK_P);
	    		break;
	    	case "VK_Q":
	    		robot.keyPress(KeyEvent.VK_Q);
	    		System.out.println("VK_Q");
	    		robot.keyRelease(KeyEvent.VK_Q);
	    		break;
	    	case "VK_R":
	    		robot.keyPress(KeyEvent.VK_R);
	    		System.out.println("VK_R");
	    		robot.keyRelease(KeyEvent.VK_R);
	    		break;
	    	case "VK_S":
	    		robot.keyPress(KeyEvent.VK_S);
	    		System.out.println("VK_S");
	    		robot.keyRelease(KeyEvent.VK_S);
	    		break;
	    	case "VK_T":
	    		robot.keyPress(KeyEvent.VK_T);
	    		System.out.println("VK_T");
	    		robot.keyRelease(KeyEvent.VK_T);
	    		break;
	    	case "VK_U":
	    		robot.keyPress(KeyEvent.VK_U);
	    		System.out.println("VK_U");
	    		robot.keyRelease(KeyEvent.VK_U);
	    		break;
	    	case "VK_V":
	    		robot.keyPress(KeyEvent.VK_V);
	    		System.out.println("VK_V");
	    		robot.keyRelease(KeyEvent.VK_V);
	    		break;
	    	case "VK_W":
	    		robot.keyPress(KeyEvent.VK_W);
	    		System.out.println("VK_W");
	    		robot.keyRelease(KeyEvent.VK_W);
	    		break;
	    	case "VK_X":
	    		robot.keyPress(KeyEvent.VK_X);
	    		System.out.println("VK_X");
	    		robot.keyRelease(KeyEvent.VK_X);
	    		break;
	    	case "VK_Y":
	    		robot.keyPress(KeyEvent.VK_Y);
	    		System.out.println("VK_Y");
	    		robot.keyRelease(KeyEvent.VK_Y);
	    		break;
	    	case "VK_Z":
	    		robot.keyPress(KeyEvent.VK_Z);
	    		System.out.println("VK_Z");
	    		robot.keyRelease(KeyEvent.VK_Z);
	    		break;
	    		
	    	case "play":
	    		robot.keyPress(KeyEvent.VK_SPACE);
	    		System.out.println("play");
	    		robot.keyRelease(KeyEvent.VK_SPACE);
	    		break;
	    		
	    	case "forward":
	    		robot.keyPress(KeyEvent.VK_CONTROL);
	    		robot.keyPress(KeyEvent.VK_RIGHT);
	    		System.out.println("forward");
	    		robot.keyRelease(KeyEvent.VK_RIGHT);
	    		robot.keyRelease(KeyEvent.VK_CONTROL);
	    		break;
	    	case "backward":
	    		robot.keyPress(KeyEvent.VK_CONTROL);
	    		robot.keyPress(KeyEvent.VK_LEFT);
	    		System.out.println("backward");
	    		robot.keyRelease(KeyEvent.VK_LEFT);
	    		robot.keyRelease(KeyEvent.VK_CONTROL);
	    		break;
	    	case "stop":
	    		robot.keyPress(KeyEvent.VK_S);
	    		System.out.println("stop");
	    		robot.keyRelease(KeyEvent.VK_S);
	    		break;
	    		
	    	case "left":
	    		robot.keyPress(KeyEvent.VK_LEFT);
	    		System.out.println("LEFT");
	    		robot.keyRelease(KeyEvent.VK_LEFT);
	    		break;
	    		
	    	case "right":
	    		robot.keyPress(KeyEvent.VK_RIGHT);
	    		System.out.println("RIGHT");
	    		robot.keyRelease(KeyEvent.VK_RIGHT);
	    		break;
	    	case "close":
	    		robot.keyPress(KeyEvent.VK_CONTROL);
	    		System.out.println("CLOSE");
	    		robot.keyPress(KeyEvent.VK_W);
	    		robot.keyRelease(KeyEvent.VK_W);
	    		robot.keyRelease(KeyEvent.VK_CONTROL);
	    		break;
	    		
	    	case "shutdown":
	    		Runtime.getRuntime().exec("shutdown -s");
	    		break;
	    	case "sleep":
	    		Runtime.getRuntime().exec("rundll32.exe powrprof.dll,SetSuspendState 0,1,0");
	    		break;
	    	case "logoff":
	    		Runtime.getRuntime().exec("shutdown -l");
	    		break;
	    		
	    	case "mouse_starts":
	    		boolean status=true;
	    		while(status)
	            {
	    			byte[] receiveData = new byte[1024];
	    	        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	                serverSocket.receive(receivePacket);
	                String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
	                System.out.println("RECEIVED: " + sentence);
	                if(sentence.equals("mouse_closed")){
	                	System.out.println("RECEIVED: " + sentence);
	                	status=false;
	                }else if(sentence.equals("long_press")){
	                	robot.keyPress(KeyEvent.VK_ENTER);
	    	    		System.out.println("long_pressed_enter");
	    	    		robot.keyRelease(KeyEvent.VK_ENTER);
	                }else if(sentence.equals("select")){
	                	robot.mousePress(InputEvent.BUTTON1_MASK);
	                	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                }else if(sentence.equals("drag_and_drop_start")){
	                	p = MouseInfo.getPointerInfo().getLocation();
	                	robot.mousePress(InputEvent.BUTTON1_MASK);
	                }else if(sentence.equals("drag_and_drop_stop")){
	                	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                }else if(sentence.equals("right_mouse_click")){
	                	robot.mousePress(InputEvent.BUTTON3_MASK);
	                	robot.mouseRelease(InputEvent.BUTTON3_MASK);
	                	
	                }else if(sentence.equals("four_finger_movement")){
	                	robot.keyPress(KeyEvent.VK_WINDOWS);
	                	robot.keyPress(KeyEvent.VK_D);
	                	robot.keyRelease(KeyEvent.VK_D);
	                	robot.keyRelease(KeyEvent.VK_WINDOWS);
	                	
	                	//maybe right click came. so press escape to escape from right click
	                	robot.keyPress(KeyEvent.VK_ESCAPE);
	                	robot.keyRelease(KeyEvent.VK_ESCAPE);
	                } else if(sentence.equals("scroll_down")){
	                	robot.mouseWheel(1);
	                } else if(sentence.equals("scroll_up")){
	                	robot.mouseWheel(-1);
	                } else{
	                	String[] xAndY = sentence.split(",");
	                	int x= Integer.parseInt(xAndY[0]);
	                	int y= Integer.parseInt(xAndY[1]);
	                	
	                	PointerInfo a = MouseInfo.getPointerInfo();
		        		Point b = a.getLocation();
		        		int curX = (int) b.getX();
		        		int curY = (int) b.getY();
		        		curX+=x;
		        		curY+=y;
	                	Robot robot_mouse = new Robot();
	                	robot_mouse.mouseMove(curX,curY);
	                }
	            }
	    		break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public static StringBuffer getIpAddress() { 
    	StringBuffer infoText = new StringBuffer();
    	try {
			Enumeration<NetworkInterface> nets = NetworkInterface
					.getNetworkInterfaces();
			infoText.append("<p style='color:E96B14'>10.0.2.2<br\\>");
			for (NetworkInterface netint : Collections.list(nets)) {
				Enumeration<InetAddress> inetAddresses = netint
						.getInetAddresses();
				for (InetAddress inetAddress : Collections.list(inetAddresses)) {
					String address = inetAddress.toString();
					if (address.compareTo("/127.0.0.1") != 0
							&& !address.contains(":")) {
						infoText.append(address.substring(1) + "<br\\>");
					}
				}
			}
			infoText.append("</p>");
		} catch (SocketException e) {
			infoText.append("Socket exception. Could not obtain IP addresses.");
		}

		return infoText;
    }
    public void run_receiver(int port) {    
      try {
        serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[1024];
        System.out.printf("Listening on udp:%s:%d%n",
                InetAddress.getLocalHost().getHostAddress(), port);     
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        StringBuffer ipaddresses= getIpAddress();
        lblPossibleIpAddresses.setText("Possible IP Addresses:<br\\>"+ipaddresses);
        while(true)
        {
              serverSocket.receive(receivePacket);
              String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
              System.out.println("RECEIVED: " + sentence);
              processCommand(sentence);
        }
      } catch (IOException e) {
              System.out.println(e);
      }
    }

=======
package com.vignesh.annauniv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Receiver extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextPane lblPossibleIpAddresses;
	public DatagramSocket serverSocket;
	public static int port;
	public static JFrame f;
	Point p;
	String decodedPath="";
    public static void main(String[] args) {
        port = 8010;
        f = new JFrame();
        Receiver receiver = new Receiver();
        receiver.setVisible(true);
        receiver.initiate_frame();
        receiver.run_receiver(8010);
    }
    public void initiate_frame(){

		URL url_path;
		try {
			String path = Receiver.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			try {
				decodedPath = URLDecoder.decode(path, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			url_path = (new File(decodedPath+"Spinner.gif").toURI().toURL());
			ImageIcon reel =  new ImageIcon(url_path);
            JLabel label = new JLabel(reel);
            reel.setImageObserver(label);
            f.getContentPane().add(label);
            f.setUndecorated(true);
            p = MouseInfo.getPointerInfo().getLocation();
            f.setBounds(p.x,p.y,55,55);
            f.setOpacity(0.55f);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    public Receiver(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setBackground(Color.WHITE);
    	setBounds(100,100,400,500);
    	setTitle("Java Server Application");
    	JPanel jp = new JPanel();
    	jp.setBorder(new EmptyBorder(5,5,5,5));
    	jp.setLayout(new BorderLayout(0,0));
    	setContentPane(jp);
    	jp.setBackground(Color.WHITE);
    	JLabel lblServerApplication = new JLabel("Server Application");
    	jp.add(lblServerApplication, BorderLayout.NORTH);
    	
    	lblPossibleIpAddresses = new JTextPane();
    	lblPossibleIpAddresses.setContentType("text/html");
    	jp.add(lblPossibleIpAddresses, BorderLayout.SOUTH);
    	
    }
    private void processCommand(String command) {
		try {
			Robot robot = new Robot();
			switch (command) {
	    	case "up":
	    		robot.keyPress(KeyEvent.VK_UP);
	    		System.out.println("UP");
	    		robot.keyRelease(KeyEvent.VK_UP);
	    		break;
	    	case "down":
	    		robot.keyPress(KeyEvent.VK_DOWN);
	    		System.out.println("DOWN");
	    		robot.keyRelease(KeyEvent.VK_DOWN);
	    		
	    		break;
	    	case "enter":
	    		robot.keyPress(KeyEvent.VK_ENTER);
	    		System.out.println("ENTER");
	    		robot.keyRelease(KeyEvent.VK_ENTER);
	    		break;
	    	case "back":
	    		robot.keyPress(KeyEvent.VK_BACK_SPACE);
	    		System.out.println("BACK");
	    		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	    		break;
	    	case "space":
	    		robot.keyPress(KeyEvent.VK_SPACE);
	    		System.out.println("space");
	    		robot.keyRelease(KeyEvent.VK_SPACE);
	    		break;
	    		
	    	case "VK_A":
	    		robot.keyPress(KeyEvent.VK_A);
	    		System.out.println("VK_A");
	    		robot.keyRelease(KeyEvent.VK_A);
	    		break;
	    	case "VK_B":
	    		robot.keyPress(KeyEvent.VK_B);
	    		System.out.println("VK_B");
	    		robot.keyRelease(KeyEvent.VK_B);
	    		break;
	    	case "VK_C":
	    		robot.keyPress(KeyEvent.VK_C);
	    		System.out.println("VK_C");
	    		robot.keyRelease(KeyEvent.VK_C);
	    		break;
	    	case "VK_D":
	    		robot.keyPress(KeyEvent.VK_D);
	    		System.out.println("VK_D");
	    		robot.keyRelease(KeyEvent.VK_D);
	    		break;
	    	case "VK_E":
	    		robot.keyPress(KeyEvent.VK_E);
	    		System.out.println("VK_E");
	    		robot.keyRelease(KeyEvent.VK_E);
	    		break;
	    	case "VK_F":
	    		robot.keyPress(KeyEvent.VK_F);
	    		System.out.println("VK_F");
	    		robot.keyRelease(KeyEvent.VK_F);
	    		break;
	    	case "VK_G":
	    		robot.keyPress(KeyEvent.VK_G);
	    		System.out.println("VK_G");
	    		robot.keyRelease(KeyEvent.VK_G);
	    		break;
	    	case "VK_H":
	    		robot.keyPress(KeyEvent.VK_H);
	    		System.out.println("VK_H");
	    		robot.keyRelease(KeyEvent.VK_H);
	    		break;
	    	case "VK_I":
	    		robot.keyPress(KeyEvent.VK_I);
	    		System.out.println("VK_I");
	    		robot.keyRelease(KeyEvent.VK_I);
	    		break;
	    	case "VK_J":
	    		robot.keyPress(KeyEvent.VK_J);
	    		System.out.println("VK_J");
	    		robot.keyRelease(KeyEvent.VK_J);
	    		break;
	    	case "VK_K":
	    		robot.keyPress(KeyEvent.VK_K);
	    		System.out.println("VK_K");
	    		robot.keyRelease(KeyEvent.VK_K);
	    		break;
	    	case "VK_L":
	    		robot.keyPress(KeyEvent.VK_L);
	    		System.out.println("VK_L");
	    		robot.keyRelease(KeyEvent.VK_L);
	    		break;
	    	case "VK_M":
	    		robot.keyPress(KeyEvent.VK_M);
	    		System.out.println("VK_M");
	    		robot.keyRelease(KeyEvent.VK_M);
	    		break;
	    	case "VK_N":
	    		robot.keyPress(KeyEvent.VK_N);
	    		System.out.println("VK_N");
	    		robot.keyRelease(KeyEvent.VK_N);
	    		break;
	    	case "VK_O":
	    		robot.keyPress(KeyEvent.VK_O);
	    		System.out.println("VK_O");
	    		robot.keyRelease(KeyEvent.VK_O);
	    		break;
	    	case "VK_P":
	    		robot.keyPress(KeyEvent.VK_P);
	    		System.out.println("VK_P");
	    		robot.keyRelease(KeyEvent.VK_P);
	    		break;
	    	case "VK_Q":
	    		robot.keyPress(KeyEvent.VK_Q);
	    		System.out.println("VK_Q");
	    		robot.keyRelease(KeyEvent.VK_Q);
	    		break;
	    	case "VK_R":
	    		robot.keyPress(KeyEvent.VK_R);
	    		System.out.println("VK_R");
	    		robot.keyRelease(KeyEvent.VK_R);
	    		break;
	    	case "VK_S":
	    		robot.keyPress(KeyEvent.VK_S);
	    		System.out.println("VK_S");
	    		robot.keyRelease(KeyEvent.VK_S);
	    		break;
	    	case "VK_T":
	    		robot.keyPress(KeyEvent.VK_T);
	    		System.out.println("VK_T");
	    		robot.keyRelease(KeyEvent.VK_T);
	    		break;
	    	case "VK_U":
	    		robot.keyPress(KeyEvent.VK_U);
	    		System.out.println("VK_U");
	    		robot.keyRelease(KeyEvent.VK_U);
	    		break;
	    	case "VK_V":
	    		robot.keyPress(KeyEvent.VK_V);
	    		System.out.println("VK_V");
	    		robot.keyRelease(KeyEvent.VK_V);
	    		break;
	    	case "VK_W":
	    		robot.keyPress(KeyEvent.VK_W);
	    		System.out.println("VK_W");
	    		robot.keyRelease(KeyEvent.VK_W);
	    		break;
	    	case "VK_X":
	    		robot.keyPress(KeyEvent.VK_X);
	    		System.out.println("VK_X");
	    		robot.keyRelease(KeyEvent.VK_X);
	    		break;
	    	case "VK_Y":
	    		robot.keyPress(KeyEvent.VK_Y);
	    		System.out.println("VK_Y");
	    		robot.keyRelease(KeyEvent.VK_Y);
	    		break;
	    	case "VK_Z":
	    		robot.keyPress(KeyEvent.VK_Z);
	    		System.out.println("VK_Z");
	    		robot.keyRelease(KeyEvent.VK_Z);
	    		break;
	    		
	    	case "play":
	    		robot.keyPress(KeyEvent.VK_SPACE);
	    		System.out.println("play");
	    		robot.keyRelease(KeyEvent.VK_SPACE);
	    		break;
	    		
	    	case "forward":
	    		robot.keyPress(KeyEvent.VK_CONTROL);
	    		robot.keyPress(KeyEvent.VK_RIGHT);
	    		System.out.println("forward");
	    		robot.keyRelease(KeyEvent.VK_RIGHT);
	    		robot.keyRelease(KeyEvent.VK_CONTROL);
	    		break;
	    	case "backward":
	    		robot.keyPress(KeyEvent.VK_CONTROL);
	    		robot.keyPress(KeyEvent.VK_LEFT);
	    		System.out.println("backward");
	    		robot.keyRelease(KeyEvent.VK_LEFT);
	    		robot.keyRelease(KeyEvent.VK_CONTROL);
	    		break;
	    	case "stop":
	    		robot.keyPress(KeyEvent.VK_S);
	    		System.out.println("stop");
	    		robot.keyRelease(KeyEvent.VK_S);
	    		break;
	    		
	    	case "left":
	    		robot.keyPress(KeyEvent.VK_LEFT);
	    		System.out.println("LEFT");
	    		robot.keyRelease(KeyEvent.VK_LEFT);
	    		break;
	    		
	    	case "right":
	    		robot.keyPress(KeyEvent.VK_RIGHT);
	    		System.out.println("RIGHT");
	    		robot.keyRelease(KeyEvent.VK_RIGHT);
	    		break;
	    	case "close":
	    		robot.keyPress(KeyEvent.VK_CONTROL);
	    		System.out.println("CLOSE");
	    		robot.keyPress(KeyEvent.VK_W);
	    		robot.keyRelease(KeyEvent.VK_W);
	    		robot.keyRelease(KeyEvent.VK_CONTROL);
	    		break;
	    		
	    	case "shutdown":
	    		Runtime.getRuntime().exec("shutdown -s");
	    		break;
	    	case "sleep":
	    		Runtime.getRuntime().exec("rundll32.exe powrprof.dll,SetSuspendState 0,1,0");
	    		break;
	    	case "logoff":
	    		Runtime.getRuntime().exec("shutdown -l");
	    		break;
	    	
	    	case "mouse_starts":
	    		boolean status=true;
	    		while(status)
	            {
	    			byte[] receiveData = new byte[1024];
	    	        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	                serverSocket.receive(receivePacket);
	                String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
	                System.out.println("RECEIVED: " + sentence);
	                if(sentence.equals("mouse_closed")){
	                	System.out.println("RECEIVED: " + sentence);
	                	status=false;
	                }else if(sentence.equals("long_press")){
	                	robot.keyPress(KeyEvent.VK_ENTER);
	    	    		System.out.println("long_pressed_enter");
	    	    		robot.keyRelease(KeyEvent.VK_ENTER);
	                }else if(sentence.equals("select")){
	                	robot.mousePress(InputEvent.BUTTON1_MASK);
	                	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                }else if(sentence.equals("drag_and_drop_start")){
	                	p = MouseInfo.getPointerInfo().getLocation();
	                	robot.mousePress(InputEvent.BUTTON1_MASK);
	                }else if(sentence.equals("drag_and_drop_stop")){
	                	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	                }else if(sentence.equals("right_mouse_click")){
	                	robot.mousePress(InputEvent.BUTTON3_MASK);
	                	robot.mouseRelease(InputEvent.BUTTON3_MASK);
	                	
	                }else if(sentence.equals("four_finger_movement")){
	                	robot.keyPress(KeyEvent.VK_WINDOWS);
	                	robot.keyPress(KeyEvent.VK_D);
	                	robot.keyRelease(KeyEvent.VK_D);
	                	robot.keyRelease(KeyEvent.VK_WINDOWS);
	                	
	                	//maybe right click came. so press escape to escape from right click
	                	robot.keyPress(KeyEvent.VK_ESCAPE);
	                	robot.keyRelease(KeyEvent.VK_ESCAPE);
	                }else{
	                	String[] xAndY = sentence.split(",");
	                	int x= Integer.parseInt(xAndY[0]);
	                	int y= Integer.parseInt(xAndY[1]);
	                	
	                	PointerInfo a = MouseInfo.getPointerInfo();
		        		Point b = a.getLocation();
		        		int curX = (int) b.getX();
		        		int curY = (int) b.getY();
		        		curX+=x;
		        		curY+=y;
	                	Robot robot_mouse = new Robot();
	                	robot_mouse.mouseMove(curX,curY);
	                }
	            }
	    		break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public static StringBuffer getIpAddress() { 
    	StringBuffer infoText = new StringBuffer();
    	try {
			Enumeration<NetworkInterface> nets = NetworkInterface
					.getNetworkInterfaces();
			infoText.append("<p style='color:E96B14'>10.0.2.2<br\\>");
			for (NetworkInterface netint : Collections.list(nets)) {
				Enumeration<InetAddress> inetAddresses = netint
						.getInetAddresses();
				for (InetAddress inetAddress : Collections.list(inetAddresses)) {
					String address = inetAddress.toString();
					if (address.compareTo("/127.0.0.1") != 0
							&& !address.contains(":")) {
						infoText.append(address.substring(1) + "<br\\>");
					}
				}
			}
			infoText.append("</p>");
		} catch (SocketException e) {
			infoText.append("Socket exception. Could not obtain IP addresses.");
		}

		return infoText;
    }
    public void run_receiver(int port) {    
      try {
        serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[1024];
        System.out.printf("Listening on udp:%s:%d%n",
                InetAddress.getLocalHost().getHostAddress(), port);     
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        StringBuffer ipaddresses= getIpAddress();
        lblPossibleIpAddresses.setText("Possible IP Addresses:<br\\>"+ipaddresses);
        while(true)
        {
              serverSocket.receive(receivePacket);
              String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
              System.out.println("RECEIVED: " + sentence);
              processCommand(sentence);
        }
      } catch (IOException e) {
              System.out.println(e);
      }
    }

>>>>>>> 03003a54d10d5dd23fba07b132f055ec74b8e019
}	