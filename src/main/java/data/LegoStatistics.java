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
@Table(name="LEGOSTATISTICS")
public class LegoStatistics {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ON_LINE_TIME")
	private int on_line_time;
	
	@Column(name="BATTERY_VOLTAGE")
	private float battery_voltage;
	
	@Column(name="TIME")
	private java.sql.Timestamp time = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());

	public LegoStatistics(int id, int on_line_time, float battery_voltage, Timestamp time) {
		super();
		this.id = id;
		this.on_line_time = on_line_time;
		this.battery_voltage = battery_voltage;
		this.time = time;
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

	public float getBattery_voltage() {
		return battery_voltage;
	}

	public void setBattery_voltage(float battery_voltage) {
		this.battery_voltage = battery_voltage;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "LegoStatistics [id=" + id + ", on_line_time=" + on_line_time + ", battery_voltage=" + battery_voltage
				+ ", time=" + time + "]";
	}
	
	
}
