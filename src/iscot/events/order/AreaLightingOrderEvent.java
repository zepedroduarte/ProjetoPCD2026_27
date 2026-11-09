package iscot.events.order;

import iscot.enums.Areas;

public class AreaLightingOrderEvent extends HighLevelOrderEvent {

    private final boolean state;

    public AreaLightingOrderEvent(Areas area, boolean state) {
        super(area);
        this.state = state;
    }

    public boolean getState(){
        return this.state;
    }

    @Override
    public String toString(){
        return "AreaLightingOrderEvent [state=" + state + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}
