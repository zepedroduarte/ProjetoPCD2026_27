package iscot.events.order;

import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent {
    private final AirConditioningMode mode;
    private final boolean state;

    protected AreaTemperatureOrderEvent(Areas area, AirConditioningMode mode, boolean state) {
        super(area);
        this.mode = mode;
        this.state = state;
    }

    public AirConditioningMode getMode(){
        return this.mode;
    }

    public boolean getState(){
        return this.state;
    }

    @Override
    public String toString(){
        return "AreaTemperatureOrderEvent [state=" + state + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}
