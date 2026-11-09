package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public abstract class Event{

    private final Areas area;
    private final Type type;

    public Event(Areas area, Type type) {
        this.area = area;
        this.type = type;
    }

    public Areas getArea() {
        return area;
    }

    public Type getType() {
        return type;
    }
}
