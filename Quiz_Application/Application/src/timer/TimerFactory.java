package timer;

import timer.MinuteTimer;
import timer.SecondTimer;
import timer.Timer;

public class TimerFactory {
    static public Timer getTimer(int duration , TimerType timerType){
       if(timerType.equals(TimerType.MINUTE))return new MinuteTimer(duration);
       if(timerType.equals(TimerType.SECOND))return new SecondTimer(duration);
       return null;
    }
}
