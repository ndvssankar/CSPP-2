
public class Quiz {
	List<Question> questions;

	public Quiz() {
		questions = new List<Question>();
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public Question getQuestion(int index) {
		return questions.get(index);
	}
}