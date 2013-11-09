package com.litpo.virtualdolllife.pojos;

public class Weather {
	private String city;

	public Weather() {
	}

	public Weather(String city) {
		this.city = city;
	}

	private String temperature="";
	private String status="";
	private String zwx="";
	private String direction1="";
	private String power1="";
	private String pm2_5="";

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getZwx() {
		return zwx;
	}

	public void setZwx(String zwx) {
		this.zwx = zwx;
	}

	public String getDirection1() {
		return direction1;
	}

	public void setDirection1(String direction1) {
		this.direction1 = direction1;
	}

	public String getPower1() {
		return power1;
	}

	public void setPower1(String power1) {
		this.power1 = power1;
	}

	public String getPm2_5() {
		return pm2_5;
	}

	public void setPm2_5(String pm2_5) {
		this.pm2_5 = pm2_5;
	}

}
