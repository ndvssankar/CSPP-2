/**
 *  This class is used for creating a question object.
 * @author Siva Sankar
 */
class Question {
    private String questionText;
    private String[] choices;
    private int correctAnswer;
    private int maxMarks;
    private int penalty;
    private int response;

    public Question(final String questionText,
                    final String[] choices, final int correctAnswer,
                    final int maxMarks, final int penalty) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
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

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
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
        StringBuffer sb = new StringBuffer();
        sb.append(this.questionText + "(");
        sb.append(this.maxMarks + ")\n");
        for (int i = 0; i < this.choices.length-1; i++)
            sb.append(choices[i] + "\t");
        sb.append(this.choices[this.choices.length-1] + "\n");
        return sb.toString();
    }
}