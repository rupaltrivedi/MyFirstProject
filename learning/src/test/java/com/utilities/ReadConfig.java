package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public static Properties pro;
	

	public ReadConfig() {
		pro = new Properties();
		
		try {
		File propertyFile = new File("./Configuration/config.properties");
		
			FileInputStream fis = new FileInputStream(propertyFile);
			pro.load(fis);
			
		}catch(IOException i) {
			i.getMessage();
		}
			
	}

	public String getUrl() {
		
		String baseUrl= pro.getProperty("url");
		return baseUrl;
	}
	
	public String getEmail() {
		String emailID= pro.getProperty("email");
		return emailID;
	}
	
	public String getUsername() {
		String username= pro.getProperty("username");
		return username;
	}
	
	
	public String getPassword() {
		String password= pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chromePath= pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxPath() {
		String firefoxPath= pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	public String getIEPath() {
		String IEPath= pro.getProperty("IEpath");
		return IEPath;
	}
	
	
	
	
	
}
