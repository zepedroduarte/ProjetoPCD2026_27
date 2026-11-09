package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class RegistrationEvent extends Event{

    protected RegistrationEvent(Areas area, Type type) {
        super(area, type);
    }

    @Override
    public String toString(){
        return "RegistrationEvent [area=" + getArea() + ", type=" + getType() + "]";
    }
}
