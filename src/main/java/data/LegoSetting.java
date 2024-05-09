package data;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents data that a robot uses to operate.
 */
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
    
    @Column(name="MOTORAPOWER")
    private int motorapower;
    
    @Column(name="MOTORBPOWER")
    private int motorbpower;
    
    @Column(name="MANUALMODE")
    private boolean manualmode;

    /**
     * Default constructor.
     */
    public LegoSetting() {
        super();
    }
    
    /**
     * Constructor with parameters.
     * @param id The ID of the LegoSetting.
     * @param colorvalue The color value.
     * @param time The timestamp.
     * @param motorapower The power of motor A.
     * @param motorbpower The power of motor B.
     */
    public LegoSetting(int id, float colorvalue, Timestamp time, int motorapower, int motorbpower) {
        super();
        this.id = id;
        this.colorvalue = colorvalue;
        this.time = time;
        this.motorapower = motorapower;
        this.motorbpower = motorbpower;
    }

    /**
     * Get the ID of the LegoSetting.
     * @return The ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the LegoSetting.
     * @param id The ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the color value.
     * @return The color value.
     */
    public double getColorvalue() {
        return colorvalue;
    }

    /**
     * Set the color value.
     * @param colorvalue The color value to set.
     */
    public void setColorvalue(double colorvalue) {
        this.colorvalue = colorvalue;
    }

    /**
     * Get the timestamp.
     * @return The timestamp.
     */
    public java.sql.Timestamp getTime() {
        return time;
    }

    /**
     * Set the timestamp.
     * @param time The timestamp to set.
     */
    public void setTime(java.sql.Timestamp time) {
        this.time = time;
    }
    
    /**
     * Get the power of motor A.
     * @return The power of motor A.
     */
    public int getMotorapower() {
        return motorapower;
    }

    /**
     * Set the power of motor A.
     * @param motorAPower The power of motor A to set.
     */
    public void setMotorapower(int motorAPower) {
        this.motorapower = motorAPower;
    }

    /**
     * Get the power of motor B.
     * @return The power of motor B.
     */
    public int getMotorbpower() {
        return motorbpower;
    }

    /**
     * Set the power of motor B.
     * @param motorBPower The power of motor B to set.
     */
    public void setMotorbpower(int motorBPower) {
        this.motorbpower = motorBPower;
    }
    
    /**
     * Check if the LegoSetting is in manual mode.
     * @return True if in manual mode, false otherwise.
     */
    public boolean isManualmode() {
        return manualmode;
    }

    /**
     * Set the manual mode of the LegoSetting.
     * @param manualmode The manual mode to set.
     */
    public void setManualmode(boolean manualmode) {
        this.manualmode = manualmode;
    }

    /**
     * Generate a string representation of the LegoSetting.
     * @return A string containing the ID, color value, and timestamp.
     */
    @Override
    public String toString() {
        return id + "#" + colorvalue + "#" + time;
    }
}
