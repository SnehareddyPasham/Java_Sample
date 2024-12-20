package com.qualizeal.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Test1 {
	@Test
	public static void test1 () throws IOException
	{
		 Properties properties = new Properties();
		 String rootDirectory = System.getProperty("user.dir");
		 String projectPath = "//src//test//resources//browser.properties";
		 String path = rootDirectory+projectPath;
		 try {
		 FileInputStream file = new FileInputStream(path);
		 properties.load(file);
		 System.out.println(properties.getProperty("url"));
		 
		 System.out.println(properties.getProperty("browser"));
		 System.out.println(properties.getProperty("timeout"));
		 }
		 catch(FileNotFoundException f) {
			 f.printStackTrace();
		 }
		 
	}
	
}
