package data;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LEGOSETTING")
public class LegoSetting {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="COLORVALUE")
	private double colorvalue;
	@Column(name="DISTANCEVALUE")
    private double distancevalue;
	@Column(name="TIME")
	private java.sql.Timestamp time = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	@Column(name="MOTORAPOWER")
	private int motorapower;
	@Column(name="MOTORBPOWER")
	private int motorbpower;

	public LegoSetting() {
		super();
	}
	
	public LegoSetting(int id, float colorvalue, double distancevalue, Timestamp time, int motorapower, int motorbpower) {
		super();
		this.id = id;
		this.colorvalue = colorvalue;
		this.distancevalue = distancevalue;
		this.time = time;
		this.motorapower = motorapower;
		this.motorbpower = motorbpower;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getColorvalue() {
		return colorvalue;
	}

	public void setColorvalue(double colorvalue) {
		this.colorvalue = colorvalue;
	}
	
	public double getDistancevalue() {
	        return distancevalue;
	}

	public void setDistancevalue(double distancevalue) {
	        this.distancevalue = distancevalue;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
	
	public int getMotorapower() {
		return motorapower;
	}

	public void setMotorapower(int motorAPower) {
		this.motorapower = motorAPower;
	}

	public int getMotorbpower() {
		return motorbpower;
	}

	public void setMotorbpower(int motorBPower) {
		this.motorbpower = motorBPower;
	}
	
	@Override
	public String toString() {
		return id+"#"+colorvalue+"#"+time;
	}
	
}
