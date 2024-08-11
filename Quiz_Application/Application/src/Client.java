import questions.Question;
import quiz.Quiz;
import timer.QuizTimer;
import timer.TimerType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        //1. Create a list to keep questions in it
        List<Question> questions = new ArrayList<>();

        // 2.create a question
        Question question1 = new Question();
        question1.setQuestion("Who is the prime minister of INDIA");
           //1.1 set options
           Map<Integer,String> optionsForQ1 = new HashMap<>();
           optionsForQ1.put(1,"Rahul Gandhi");
           optionsForQ1.put(2,"Akhiles Yadav");
           optionsForQ1.put(3,"Narendra Modi");
           optionsForQ1.put(4,"Mamta Baneerjee");
        question1.setOptions(optionsForQ1);
        question1.setCorrectOption(3);
        question1.setMark(5);

        Question question2 = new Question();
        question2.setQuestion("Who is the national animal of India>");
        //1.1 set options
        Map<Integer,String> optionsForQ2 = new HashMap<>();
        optionsForQ2.put(1,"Fox");
        optionsForQ2.put(2,"Peacock");
        optionsForQ2.put(3,"Mouse");
        optionsForQ2.put(4,"Tiger");
        question2.setOptions(optionsForQ2);
        question2.setCorrectOption(4);
        question2.setMark(5);

        //Add question to the list
        questions.add(question1);

        //Add question to the list
        questions.add(question2);


        //3. Create Timer for Quiz
        QuizTimer timer = new QuizTimer(10,TimerType.SECOND);


        //4. Create a Quiz
        Quiz quiz = new Quiz(questions,timer);
        quiz.start();


    }
}
