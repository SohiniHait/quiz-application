package quiz;

import questions.Question;
import timer.QuizTimer;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Quiz {
    List<Question> questions;
    public  QuizTimer quizTimer;

    int totalScore=0;

    int yourScore =0;

    ScheduledExecutorService scheduler;

    Integer hour;
    Integer minutes;
    Integer seconds;

    public Quiz(List<Question> questions, QuizTimer quizTimer) {
        this.questions = questions;
        this.quizTimer = quizTimer;
        scheduler = Executors.newScheduledThreadPool(1);
    }

    private int getTotalScore(){
      for(Question q : questions){
          totalScore+=q.getMark();
      }
      return totalScore;
    }

    public void start() throws InterruptedException {
        quizTimer.startTimer();

        Runnable fetchCurrentTime = new Runnable() {
            @Override
            public void run() {
                hour = quizTimer.hours;
                minutes = quizTimer.minutes;
                seconds = quizTimer.seconds;

                if(quizTimer.timerStatus){
                    //System.out.print("\rTime Remaining -> "+hour+":"+minutes+":"+seconds);
                }
                else{
                    System.out.println("");
                    System.out.println(" Time Over");
                    scheduler.shutdown();
                    System.out.println("");
                    System.out.println("");
                    System.out.println("SCORE : "+yourScore+"/"+getTotalScore());
                    System.exit(1);
                }

            }
        };
        scheduler.scheduleAtFixedRate(fetchCurrentTime,1,1, TimeUnit.SECONDS);

        for(Question q:questions){
            if(quizTimer.timerStatus==true){
                System.out.println(q.getQuestion());
                System.out.println();
                for(Map.Entry<Integer,String> o:q.getOptions().entrySet()){
                    System.out.println(o.getKey()+" "+o.getValue());
                }

                System.out.println("Enter Answer");

                Scanner sc = new Scanner(System.in);
                Integer userInput=sc.nextInt();
                if(userInput ==q.getCorrectOption())yourScore+=q.getMark();
            }

        }


        System.out.println("");
        System.out.println("");
        System.out.println("SCORE : "+yourScore+"/"+getTotalScore());
        System.exit(1);

    }



}
