package iscot.events.order;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public class HighLevelOrderEvent extends Event {

    protected HighLevelOrderEvent(Areas area) {
        super(area, Type.DECIDER);
    }
}
