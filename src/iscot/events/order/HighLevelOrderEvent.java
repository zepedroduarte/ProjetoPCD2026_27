package iscot.events.order;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public abstract class HighLevelOrderEvent extends Event {

    public HighLevelOrderEvent(Areas area) {
        super(area, Type.DECIDER);
    }
}
