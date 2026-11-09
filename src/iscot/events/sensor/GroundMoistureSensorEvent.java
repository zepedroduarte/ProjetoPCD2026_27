package iscot.events.sensor;

import iscot.enums.Areas;

public class GroundMoistureSensorEvent extends SensorEvent {

    private final double moistureLevel;

    public GroundMoistureSensorEvent(Areas area, double moistureLevel) {
        super(area);
        this.moistureLevel = moistureLevel;
    }

    public double getMoistureLevel(){
        return this.moistureLevel;
    }

    @Override
    public String toString(){
        return "GroundMoistureSensorEvent [Ground Moisture=" + moistureLevel + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}
