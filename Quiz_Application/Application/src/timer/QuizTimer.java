package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class QuizTimer {
    ScheduledExecutorService scheduler;

    Integer timeRemaing;
    public Integer hours;

    public Integer minutes;

    public Integer seconds;


    public boolean timerStatus = true;

    Timer timer;
    public QuizTimer(int duration , TimerType timerType){
        scheduler= Executors.newScheduledThreadPool(1);
        timer= TimerFactory.getTimer(duration,timerType);
        timeRemaing=timer.getSeconds();
        hours = (this.timeRemaing/60)/60;
        minutes=(this.timeRemaing/60);

    }
    public void startTimer(){

        Runnable task = new Runnable() {
            @Override
            public void run() {
                if(timeRemaing>-1){
                    seconds = timeRemaing%60;
                    if(seconds==0){
                        if(timeRemaing<60){
                            minutes=0;
                        }
                        else minutes--;
                        if(timeRemaing<3600){
                            hours =0;
                        }
                        else if (minutes==0){
                            hours--;
                        }
                    }

                    timeRemaing--;
                }
                else {
                    timerStatus=false;
                    scheduler.shutdown();
                }
            }
        };

        scheduler.scheduleAtFixedRate(task,1,1, TimeUnit.SECONDS);
    }
}
