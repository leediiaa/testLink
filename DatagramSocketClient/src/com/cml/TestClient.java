package com.cml;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class TestClient {

	public static void main(String[] args) {

		byte[] bys = new String("I am a chinese").getBytes();
		DatagramPacket dp = new DatagramPacket(bys,bys.length);
		
		byte[] bys2 = new byte[60];//接受用户返回的数据包缓冲区
		DatagramPacket dp2 = new DatagramPacket(bys2,bys2.length);
		
		SocketAddress addr = new InetSocketAddress("localhost",9595);//远程地址
		try {
			DatagramSocket ds = new DatagramSocket(8888);
			ds.connect(addr);//连接远程地址服务器
			ds.send(dp);//向目的地发送数据报包
			ds.receive(dp2);//接收数据报包
			bys2 = dp2.getData();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
	}

}
