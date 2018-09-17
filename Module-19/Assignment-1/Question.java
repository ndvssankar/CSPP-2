/**
 *  This class is used for creating a question object.
 * @author Siva Sankar
 */
class Question {
    private String questionText;
    private String[] choices;
    private int correctAnsower;
    private int maxMarks;
    private int penalty;
    private int response;

    public Question(final String questionText,
                    final String[] choices, final int correctAnsower,
                    final int maxMarks, final int penalty) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnsower = correctAnsower;
        this.maxMarks = maxMarks;
        this.penalty = penalty;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public int getCorrectAnsower() {
        return correctAnsower;
    }

    public void setCorrectAnsower(int correctAnsower) {
        this.correctAnsower = correctAnsower;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public String toString() {
        return null;
    }
}