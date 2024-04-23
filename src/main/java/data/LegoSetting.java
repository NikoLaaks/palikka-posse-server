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
	@Column(name="TIME")
	private java.sql.Timestamp time = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	
	
	public LegoSetting() {
		super();
	}
	
	public LegoSetting(int id, float colorvalue, Timestamp time) {
		super();
		this.id = id;
		this.colorvalue = colorvalue;
		this.time = time;
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

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return id+"#"+colorvalue+"#"+time;
	}
	
}
