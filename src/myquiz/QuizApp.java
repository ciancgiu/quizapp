package myquiz;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class QuizApp {


    public ArrayList<Question> createQuizQuestions() {

        ArrayList<Answer> quizAnswersQ1 = new ArrayList<Answer>();
        quizAnswersQ1.add(new Answer("quiz1", "quiz1q1", true, "Lydian"));
        quizAnswersQ1.add(new Answer("quiz1", "quiz1q1", false, "Locrian"));
        quizAnswersQ1.add(new Answer("quiz1", "quiz1q1", false, "Ionian"));
        quizAnswersQ1.add(new Answer("quiz1", "quiz1q1", false, "Minor"));

        ArrayList<Answer> quizAnswersQ2 = new ArrayList<Answer>();
        quizAnswersQ2.add(new Answer("quiz1", "quiz1q2", false, "True"));
        quizAnswersQ2.add(new Answer("quiz1", "quiz1q2", true, "False"));

        ArrayList<Answer> quizAnswersQ3 = new ArrayList<>();
        quizAnswersQ3.add(new Answer("quiz1", "quiz1q3", false, "1 3 5 b7"));
        quizAnswersQ3.add(new Answer("quiz1", "quiz1q3", false, "1 b3 5 7"));
        quizAnswersQ3.add(new Answer("quiz1", "quiz1q3", false, "1 b3 5 b7"));
        quizAnswersQ3.add(new Answer("quiz1", "quiz1q3", true, "1 b3 b5 b7"));

        ArrayList<Answer> quizAnswersQ4 = new ArrayList<>();
        quizAnswersQ4.add(new Answer("quiz1", "quiz1q4", false, "Amin7 - G7 - Cmaj7"));
        quizAnswersQ4.add(new Answer("quiz1", "quiz1q4", true, "Cmin7 - F7 - Bbmaj7"));
        quizAnswersQ4.add(new Answer("quiz1", "quiz1q4", false, "Cmin7 - Fmin7 - Bbmaj7"));
        quizAnswersQ4.add(new Answer("quiz1", "quiz1q4", false, "Fmin7 - Bb7 - Ebmaj7"));

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("quiz1", QuestionType.MultipleChoice, Level.Easy, 5, "What is the 4th mode of the major scale?", quizAnswersQ1));
        questions.add(new Question("quiz1", QuestionType.ToF, Level.Medium, 5, "C is the 7th scale degree in a D major scale.", quizAnswersQ2));
        questions.add(new Question("quiz1", QuestionType.MultipleChoice, Level.Medium, 5, "What are the notes of a Minor-7b5 chord", quizAnswersQ3));
        questions.add(new Question("quiz1", QuestionType.MultipleChoice, Level.Medium, 5, "What are the chords to a 2-5-1 in Bb?", quizAnswersQ4));

        return questions;
    }

    public void printStuHeader() {
        User user = new User("GC", "Giuliano", "Ciancaglini", "email@email.com", true);
        System.out.println(user + "\n");

    }

    public void printInsHead() {
        System.out.println("Host: GC \n");
        System.out.println("INSTRUCTOR VERSION");
    }

    public void quizAppTest() {
        QuizApp myquiz = new QuizApp();
        Scanner sc = new Scanner(System.in);

        ArrayList<Question> quiz1Questions = myquiz.createQuizQuestions();
        Collections.shuffle(quiz1Questions);

        Quiz quiz1 = new Quiz("quiz1", "Music Theory", "This quiz has multiple choice questions and True or False", 20, "GC", quiz1Questions);

        System.out.println("Host: " + quiz1.getHostID());
        myquiz.printStuHeader();

        System.out.println(quiz1 + "\n");

        int score = 0;
        int questionNumber = 0;


        for (Question q : quiz1Questions) {
            questionNumber++;
            System.out.println(questionNumber + ". (" + q.getPoints() + " Points) " + q.getQuestionText());
            char option = 'A';
            char optionToF = 'T';
            int correctIndex = 0;
            int userChoice = 0;


            ArrayList<Answer> answers = q.getAnswer();

            if (q.getType() == QuestionType.MultipleChoice) {
                for (int i = 0; i < answers.size(); i++) {
                    System.out.println(option + ". " + answers.get(i).getAnswerText());
                    if (answers.get(i).isCorrect()) {
                        correctIndex = i;
                    }
                    option++;
                }
            } else {
                for (int i = 0; i < answers.size(); i++) {
                    System.out.println(optionToF + ". " + answers.get(i).getAnswerText());
                    if (answers.get(i).isCorrect()) {
                        correctIndex = i;
                    }
                    optionToF = 'F';
                }

            }

            System.out.print("Enter your answer: ");
            String userInput = sc.next().toUpperCase();


            if (userInput.length() == 1 && q.getType() == QuestionType.MultipleChoice) {
                switch(userInput){
                    case "A" -> userChoice = 0;
                    case "B" -> userChoice = 1;
                    case "C" -> userChoice = 2;
                    case "D" -> userChoice = 3;
                    default -> System.out.println("Invalid Input. Answer not recognized");
                }
            } else if (userInput.length() == 1 && q.getType() == QuestionType.ToF) {
                if (userInput.equalsIgnoreCase("f")) {
                    userChoice = 1;
                } else {
                    userChoice = 0;
                }
            } else {
                System.out.println("Invalid Input. Answer not recognized");
            }


            if (userChoice == correctIndex) {
                System.out.println("Correct!\n");
                score += q.getPoints();
            } else {
                System.out.println("Incorrect. The correct answer is: " + answers.get(correctIndex).getAnswerText() + "\n");
            }

        }


        System.out.println("\n Your Score: " + score + "/" + quiz1.getTotalPoints());



        System.out.println("\n");
        myquiz.printInsHead();
        System.out.println(quiz1);

        int questionNumberIns = 0;

        for (Question q : quiz1Questions) {
            questionNumberIns++;
            System.out.print("\n" + questionNumberIns + ". ");
            q.printInstructor();
        }
    }
    public static void main(String[] args){
        QuizApp newQuiz = new QuizApp();
        newQuiz.quizAppTest();
    }
}