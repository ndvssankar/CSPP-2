import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main to demonstrate quiz.
     * @param  args      command line args.
     * @throws Exception throws exception.
     */
    public static void main(final String[] args) throws Exception {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        boolean flag = false;
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                try {
                    loadQuestions(s, q, Integer.parseInt(tokens[1]));
                    System.out.println(q.size() + " are added to the quiz");
                    flag = true;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                if (flag) {
                    startQuiz(s, q, Integer.parseInt(tokens[1]));
                }
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                if (flag) {
                    displayScore(q);
                }
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     * @throws Exception throws exception.
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz,
                                     final int questionCount) throws Exception {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount == 0) {
            throw new Exception("Quiz does not have questions");
        }
        for (int i = 0; i < questionCount; i++) {
            quiz.addQuestion(isValidQuestion(s.nextLine()));
        }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input.
     * @param      quiz         The quiz object.
     * @param      answerCount  The answer count.
     * @throws Exception throws exception.
     */
    public static void startQuiz(final Scanner s, final Quiz quiz,
                                 final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.getQuestion(i));
            String choice = s.nextLine();
            String[] choices = quiz.getQuestion(i).getChoices();
            String str = choices[quiz.getQuestion(i).getCorrectAnswer() - 1];
            if (choice.equals(str)) {
                quiz.getQuestion(i).setResponse(quiz.getQuestion(i)
                                                .getCorrectAnswer());
            }
        }
    }

    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object.
     * @throws Exception throws exception.
     */
    public static void displayScore(final Quiz quiz) {
        int totalScore = 0;
        for (int i = 0; i < quiz.size(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println(question.getQuestionText());
            if (question.getCorrectAnswer()
                == question.getResponse()) {
                System.out.println(" Correct Answer! - Marks Awarded: "
                                   + question.getMaxMarks());
                totalScore += question.getMaxMarks();
            } else {
                System.out.println(" Wrong Answer! - Penalty: "
                                   + question.getPenalty());
                totalScore += question.getPenalty();
            }
        }
        System.out.println("Total Score: " + totalScore);
    }

    /**
     * check if the question is valid or not.
     * @param  question  question.
     * @return Question  question object.
     * @throws Exception throws exception.
     */
    private static Question isValidQuestion(final String question)
    throws Exception {
        String[] tokens = question.split(":");
        if (tokens.length < 2 + 2 + 1) {
            throw new Exception("Error! Malformed question");
        }
        String qText = tokens[0];
        String[] choices = tokens[1].split(",");
        int correctAnswer = Integer.parseInt(tokens[2]);
        int maxMarks = Integer.parseInt(tokens[2 + 1]);
        int penalty = Integer.parseInt(tokens[2 + 2]);
        if (qText.length() == 0) {
            throw new Exception("Error! Malformed question");
        } else if (choices.length < 2) {
            throw new Exception(tokens[0]
                + " does not have enough answer choices");
        } else if (correctAnswer < 1 || correctAnswer > choices.length) {
            throw new Exception(
                "Error! Correct answer choice number is out of range for "
                + qText);
        } else if (maxMarks < 0) {
            throw new Exception("Invalid max marks for " + qText);
        } else if (penalty > 0) {
            throw new Exception("Invalid penalty for " + qText);
        }
        return new Question(qText, choices, correctAnswer,
                            maxMarks, penalty);
    }
}
