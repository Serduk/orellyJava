package edu.mainRun.quizCardGame;

/**
 * Quiz Card
 * Created by serdyuk on 5/29/17.
 */
public class QuizCard {
    public QuizCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    private String question = null;
    private String answer = null;
    
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
