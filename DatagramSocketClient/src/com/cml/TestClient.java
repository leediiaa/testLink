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
		
		byte[] bys2 = new byte[60];//�����û����ص����ݰ�������
		DatagramPacket dp2 = new DatagramPacket(bys2,bys2.length);
		
		SocketAddress addr = new InetSocketAddress("localhost",9595);//Զ�̵�ַ
		try {
			DatagramSocket ds = new DatagramSocket(8888);
			ds.connect(addr);//����Զ�̵�ַ������
			ds.send(dp);//��Ŀ�ĵط������ݱ���
			ds.receive(dp2);//�������ݱ���
			bys2 = dp2.getData();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
	}

}
