package iscot.events.order;

import iscot.enums.Areas;

public class AreaIrrigationOrderEvent extends HighLevelOrderEvent {

    private final boolean state;

    public AreaIrrigationOrderEvent(Areas area, boolean state) {
        super(area);
        this.state = state;
    }

    public boolean getState(){
        return this.state;
    }

    @Override
    public String toString(){
        return "AreaIrrigationOrderEvent [state=" + state + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}
