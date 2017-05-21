package com.tshop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPTest {
	@Test
	public void testFTPClient(){
		FTPClient client = new FTPClient();
		try {
			client.connect("192.168.40.128", 21);
			client.login("ftpuser1", "ftpuser1");
			//上传文件
			FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\11984\\Pictures\\hello.jpg"));
			client.changeWorkingDirectory("/home/ftpuser1/Pictures");
			client.setFileType(FTP.BINARY_FILE_TYPE);
			//第一个参数：服务器端文档名。第二个参数：上传文档的inputstream
			client.storeFile("hello.jpg", inputStream);
			client.logout();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
