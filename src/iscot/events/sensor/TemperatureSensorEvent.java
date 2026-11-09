package iscot.events.sensor;

import iscot.enums.Areas;

public class TemperatureSensorEvent extends SensorEvent{

    private final double temperature;

    public TemperatureSensorEvent(Areas area, double temperature) {
        super(area);
        this.temperature = temperature;
    }

    public double getTemperature(){
        return this.temperature;
    }

    @Override
    public String toString(){
        return "TemperatureSensorEvent [Temperature=" + temperature + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}
