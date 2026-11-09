package iscot.events.sensor;

import iscot.enums.Areas;

public class HumiditySensorEvent extends SensorEvent{

    private final double humidityLevel;

    public HumiditySensorEvent(Areas area, double humidityLevel) {
        super(area);
        this.humidityLevel = humidityLevel;
    }

    public double getHumidityLevel(){
        return this.humidityLevel;
    }

    @Override
    public String toString(){
        return "HumiditySensorEvent [Humidity Sensor=" + humidityLevel + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}
