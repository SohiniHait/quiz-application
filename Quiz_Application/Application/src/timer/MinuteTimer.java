package timer;

import java.util.concurrent.atomic.AtomicInteger;

public class MinuteTimer implements Timer {
    Integer  minutes;

    MinuteTimer(Integer minutes){
       this.minutes = minutes;
    }
    @Override
    public Integer getSeconds() {
        return minutes*60;
    }
}
