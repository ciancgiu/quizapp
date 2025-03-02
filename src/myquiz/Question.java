package myquiz;

import java.util.Scanner;
import java.util.ArrayList;

enum QuestionType{ToF, MultipleChoice}
enum Level{Easy,Medium,Hard}

public class Question {
    String quizID;
    QuestionType type;
    Level level;
    int points;
    String questionText;
    ArrayList<Answer> answer;

    public Question(String quizID, QuestionType type, Level level, int points, String questionText, ArrayList<Answer> answer) {
        this.quizID = quizID;
        this.type = type;
        this.level = level;
        this.points = points;
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuizID() {
        return quizID;
    }

    public QuestionType getType() {
        return type;
    }

    public Level getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<Answer> getAnswer() {
        return answer;
    }

    public void printInstructor() {

        if (getType() == QuestionType.MultipleChoice) {
            System.out.println(questionText);
            char option = 'A';
            for (Answer answer : answer) {
                System.out.println(option + "." + answer.getAnswerText());
                option++;
            }
        } else if (getType() == QuestionType.ToF) {
                System.out.println("True or False: " + questionText);
                char option = 'T';
                for (Answer answer : answer) {
                    System.out.println(option + "." + answer.getAnswerText());
                    option = 'F';
                }
            }

        for (Answer answer : answer) {
            if (answer.isCorrect()) {
                System.out.println("Correct Answer:" + answer.getAnswerText());
                break;
            }
        }
    }
}