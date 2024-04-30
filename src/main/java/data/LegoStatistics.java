package data;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * This class needs to be "copy" of robot side "DataToDatabase" class
 * Meaning same variables with same names for jpa to work
 */

@Entity
@Table(name="LEGOSTATISTICS")
public class LegoStatistics {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ON_LINE_TIME")
	private int on_line_time;
	
	@Column(name="BATTERY_VOLTAGE")
	private double battery_voltage; 
	
	@Column(name="OBSTACLE_DISTANCE")
	private int obstacle_distance;
	
	@Column(name="TIME")
	private java.sql.Timestamp time = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	

	public LegoStatistics(int id, int on_line_time, double battery_voltage, Timestamp time) {
		super();
		this.id = id;
		this.on_line_time = on_line_time;
		this.battery_voltage = battery_voltage;
		this.time = time;
	}

	public LegoStatistics() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOn_line_time() {
		return on_line_time;
	}

	public void setOn_line_time(int on_line_time) {
		this.on_line_time = on_line_time;
	}

	public double getBattery_voltage() {
		return battery_voltage;
	}

	public void setBattery_voltage(double d) {
		this.battery_voltage = d;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
	

	public int getObstacle_distance() {
		return obstacle_distance;
	}

	public void setObstacle_distance(int obstacle_distance) {
		this.obstacle_distance = obstacle_distance;
	}

	@Override
	public String toString() {
		return "LegoStatistics [id=" + id + ", on_line_time=" + on_line_time + ", battery_voltage=" + battery_voltage
				+ ", time=" + time + "]";
	}
	
	
}
