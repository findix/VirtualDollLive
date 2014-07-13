package com.litpo.virtualdolllive.pojos;

public class Weather {
	private String city;

	public Weather() {
	}

	public Weather(String city) {
		this.city = city;
	}

	private String temperature1 = "";
	private String temperature2 = "";
	private String status1 = "";
	private String status2 = "";
	private String zwx = "";
	private String direction1 = "";
	private String direction2 = "";
	private String power1 = "";
	private String power2 = "";
	private String pm2_5 = "";

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTemperature1() {
		return temperature1;
	}

	public void setTemperature1(String temperature1) {
		this.temperature1 = temperature1;
	}

	public String getTemperature2() {
		return temperature2;
	}

	public void setTemperature2(String temperature2) {
		this.temperature2 = temperature2;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
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

	public String getDirection2() {
		return direction2;
	}

	public void setDirection2(String direction2) {
		this.direction2 = direction2;
	}

	public String getPower1() {
		return power1;
	}

	public void setPower1(String power1) {
		this.power1 = power1;
	}

	public String getPower2() {
		return power2;
	}

	public void setPower2(String power2) {
		this.power2 = power2;
	}

	public String getPm2_5() {
		return pm2_5;
	}

	public void setPm2_5(String pm2_5) {
		this.pm2_5 = pm2_5;
	}


}
