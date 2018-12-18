package org.plate.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.plate.home.persistence.Home;

public class Services {
	private Home home;
	private String propertiesPath;
	private Properties prop;

	public Services()
	{
	}

	public void initServices()
	{	
		prop = new Properties();
		try {
			prop.load(new FileInputStream(propertiesPath));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(5);
		} 
	}
	
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public String getPropertiesPath() {
		return propertiesPath;
	}

	public void setPropertiesPath(String propertiesPath) {
		this.propertiesPath = propertiesPath;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
}
