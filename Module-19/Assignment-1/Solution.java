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
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) throws Exception {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
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
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
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
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount)
    throws Exception {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount == 0) {
            throw new Exception("Quiz does not have questions");
        }
        for (int i = 0; i < questionCount; i++) {
            try {
                quiz.addQuestion(isValidQuestion(s.nextLine()));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object

    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }

    private static Question isValidQuestion(final String question)
    throws Exception {
        String[] tokens = question.split(":");
        if (tokens.length < 5) {
            throw new Exception("Error! Malformed question");
        }
        String questionText = tokens[0];
        String[] choices = tokens[1].split(",");
        int correctAnswer = Integer.parseInt(tokens[2]);
        int maxMarks = Integer.parseInt(tokens[3]);
        int penalty = Integer.parseInt(tokens[4]);
        if (questionText.length() == 0) {
            throw new Exception("Error! Malformed question");
        } else if (choices.length < 2) {
            throw new Exception(tokens[0] + " does not have enough answer choices");
        } else if (correctAnswer < 1 || correctAnswer > choices.length) {
            throw new Exception("Error! Correct answer choice number is out of range for " + questionText);
        } else if (maxMarks < 0) {
            throw new Exception("Invalid max marks for " + questionText);
        } else if (penalty > 0) {
            throw new Exception("Invalid penalty for " + questionText);
        }
        return new Question(questionText, choices, correctAnswer,
                            maxMarks, penalty);
    }
}
