package timer;

public class SecondTimer implements Timer {

    int seconds;
    SecondTimer(Integer seconds){
        this.seconds = seconds;
    }

    @Override
    public Integer getSeconds() {
        return seconds;
    }
}
