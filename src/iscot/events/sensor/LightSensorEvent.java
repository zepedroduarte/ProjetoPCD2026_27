package iscot.events.sensor;

import iscot.enums.Areas;

public class LightSensorEvent extends SensorEvent{

    private final double light;

    public LightSensorEvent(Areas area, double light) {
        super(area);
        this.light = light;
    }

    public double getLight(){
        return this.light;
    }

    @Override
    public String toString(){
        return "LightSensorEvent [Light Level=" + light + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}
