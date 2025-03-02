package myquiz;

public class Answer {
    String ID;
    String questionID;
    boolean isCorrect;
    String answerText;


    public Answer(String ID, String questionID, boolean isCorrect, String answerText) {
        this.ID = ID;
        this.questionID = questionID;
        this.isCorrect = isCorrect;
        this.answerText = answerText;
    }

    public String getID() {
        return ID;
    }

    public String getQuestionID() {
        return questionID;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getAnswerText() {
        return answerText;
    }

    @Override
    public String toString() {
        return answerText;
    }
}
