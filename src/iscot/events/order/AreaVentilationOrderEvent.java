package iscot.events.order;

import iscot.enums.Areas;

public class AreaVentilationOrderEvent extends HighLevelOrderEvent{

    private final boolean state;


    protected AreaVentilationOrderEvent(Areas area, boolean state) {
        super(area);
        this.state = state;
    }

    public boolean getState(){
        return this.state;
    }

    @Override
    public String toString(){
        return "AreaVentilationOrderEvent [state=" + state + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}
