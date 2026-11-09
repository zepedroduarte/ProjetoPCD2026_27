package iscot.events.sensor;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public class SensorEvent extends Event {

    public SensorEvent(Areas area){
        super(area, Type.SENSOR);
    }
}
