package iscot.events.order;

import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent {
    private final AirConditioningMode mode;
    private final double temperature;

    public AreaTemperatureOrderEvent(Areas area, AirConditioningMode mode, double temperature) {
        super(area);
        this.mode = mode;
        this.temperature = temperature;
    }

    public AirConditioningMode getMode(){
        return this.mode;
    }


    @Override
    public String toString(){
        return "AreaTemperatureOrderEvent [mode=" + mode + ", temperature=" + temperature + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}
