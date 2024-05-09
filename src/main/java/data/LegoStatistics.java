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
 * Entity class representing LegoStatistics, which stores data sent from a robot to a server.
 * This class is designed to be compatible with Java Persistence API (JPA).
 */
@Entity
@Table(name="LEGOSTATISTICS")
public class LegoStatistics {
    
    /** The unique identifier for each LegoStatistics entry. */
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    /** The time in milliseconds the robot was online. */
    @Column(name="ON_LINE_TIME")
    private int on_line_time;
    
    /** The voltage of the robot's battery. */
    @Column(name="BATTERY_VOLTAGE")
    private double battery_voltage; 
    
    /** The distance from the robot to an obstacle. */
    @Column(name="OBSTACLE_DISTANCE")
    private int obstacle_distance;
    
    /** The timestamp representing the time when the data was recorded. */
    @Column(name="TIME")
    private java.sql.Timestamp time = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
    
    /**
     * Constructs a LegoStatistics object with specified attributes.
     * @param id The unique identifier for the LegoStatistics entry.
     * @param on_line_time The time in milliseconds the robot was online.
     * @param battery_voltage The voltage of the robot's battery.
     * @param time The timestamp representing the time when the data was recorded.
     */
    public LegoStatistics(int id, int on_line_time, double battery_voltage, Timestamp time) {
        super();
        this.id = id;
        this.on_line_time = on_line_time;
        this.battery_voltage = battery_voltage;
        this.time = time;
    }

    /**
     * Default constructor for LegoStatistics.
     */
    public LegoStatistics() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves the unique identifier for the LegoStatistics entry.
     * @return The unique identifier for the LegoStatistics entry.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the LegoStatistics entry.
     * @param id The unique identifier to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the time in milliseconds the robot was online.
     * @return The time in milliseconds the robot was online.
     */
    public int getOn_line_time() {
        return on_line_time;
    }

    /**
     * Sets the time in milliseconds the robot was online.
     * @param on_line_time The time in milliseconds to be set.
     */
    public void setOn_line_time(int on_line_time) {
        this.on_line_time = on_line_time;
    }

    /**
     * Retrieves the voltage of the robot's battery.
     * @return The voltage of the robot's battery.
     */
    public double getBattery_voltage() {
        return battery_voltage;
    }

    /**
     * Sets the voltage of the robot's battery.
     * @param d The voltage to be set.
     */
    public void setBattery_voltage(double d) {
        this.battery_voltage = d;
    }

    /**
     * Retrieves the timestamp representing the time when the data was recorded.
     * @return The timestamp representing the time when the data was recorded.
     */
    public java.sql.Timestamp getTime() {
        return time;
    }

    /**
     * Sets the timestamp representing the time when the data was recorded.
     * @param time The timestamp to be set.
     */
    public void setTime(java.sql.Timestamp time) {
        this.time = time;
    }

    /**
     * Retrieves the distance from the robot to an obstacle.
     * @return The distance from the robot to an obstacle.
     */
    public int getObstacle_distance() {
        return obstacle_distance;
    }

    /**
     * Sets the distance from the robot to an obstacle.
     * @param obstacle_distance The distance to be set.
     */
    public void setObstacle_distance(int obstacle_distance) {
        this.obstacle_distance = obstacle_distance;
    }

    /**
     * Generates a string representation of the LegoStatistics object.
     * @return A string representation of the LegoStatistics object.
     */
    @Override
    public String toString() {
        return "LegoStatistics [id=" + id + ", on_line_time=" + on_line_time + ", battery_voltage=" + battery_voltage
                + ", time=" + time + "]";
    }
}
