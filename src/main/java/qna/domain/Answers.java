package qna.domain;

import qna.CannotDeleteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Answers {

	private final List<Answer> answers;

	public Answers() {
		this.answers = new ArrayList<>();
	}

	public Answers(Answer answer) {
		List<Answer> answers = new ArrayList<>();
		answers.add(answer);
		this.answers = answers;
	}

	public Answers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answers add(Answer answer) {
		answers.add(answer);
		return this;
	}

	public void validateAnswersOwner(User loginUser) throws CannotDeleteException {
		for (Answer answer : answers) {
			answer.validateAnswerOwner(loginUser);
		}
	}

	public DeleteHistories deleteAnswers(User loginUser) throws CannotDeleteException {
		return deleteAnswers(loginUser, new DeleteHistories());
	}

	public DeleteHistories deleteAnswers(User loginUser, DeleteHistories deleteHistories) throws CannotDeleteException {
		for (Answer answer : answers) {
			answer.delete(loginUser, deleteHistories);
		}
		return deleteHistories;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Answers answers1 = (Answers) o;
		return answers.equals(answers1.answers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(answers);
	}
}
