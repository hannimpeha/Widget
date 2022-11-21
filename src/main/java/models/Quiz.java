package models;

public class Quiz {
    private Integer QuizId;
    private String title;

    public Quiz(Integer QuizId, String title) {
        this.QuizId = QuizId;
        this.title = title;
    }


    public Integer getQuizId() {
        return QuizId;
    }

    public String getTitle() {
        return title;
    }

    public void setQuizId(Integer QuizId) {
        this.QuizId = QuizId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Quiz{" + "QuizId=" + QuizId + ", title=" + title + '}';
    }

}
