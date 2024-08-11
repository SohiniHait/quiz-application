package questions;

import java.util.Map;

public class Question {
    String question;
    Map<Integer, String> options;
    int correctOption;
    int mark;

    public Question(){

    }

    public Question(String question, Map<Integer, String> options, int correctOption, int mark) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
        this.mark = mark;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<Integer, String> getOptions() {
        return options;
    }

    public void setOptions(Map<Integer, String> options) {
        this.options = options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", options=" + options +
                ", correctOption=" + correctOption +
                ", mark=" + mark +
                '}';
    }
}
