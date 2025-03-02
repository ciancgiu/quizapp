package myquiz;
import java.util.ArrayList;


public class Quiz {
    String ID;
    String title;
    String summary;
    int totalPoints;
    String hostID;
    ArrayList<Question> questions;


    public Quiz(String ID, String title, String summary, int totalPoints, String hostID, ArrayList<Question> questions) {
        this.ID = ID;
        this.title = title;
        this.summary = summary;
        this.totalPoints = totalPoints;
        this.hostID = hostID;
        this.questions = questions;
    }


    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public String getHostID() {
        return hostID;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "Quiz Topic: " + getTitle() + "\n" + getSummary() + ". This quiz is worth " + getTotalPoints() + " points. ";
    }
}

