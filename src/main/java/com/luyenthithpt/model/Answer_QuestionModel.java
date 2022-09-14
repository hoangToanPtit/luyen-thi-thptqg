package com.luyenthithpt.model;

public class Answer_QuestionModel {
	private int choice;
	private int isCorrect;
	private QuestionModel question;
	
	public Answer_QuestionModel() {
		super();
		question = new QuestionModel();
	}

	public int getChoice() {
		return choice;
	}

	public int getIsCorrect() {
		return isCorrect;
	}

	public QuestionModel getQuestion() {
		return question;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public void setIsCorrect(int isCorrect) {
		this.isCorrect = isCorrect;
	}

	public void setQuestion(QuestionModel question) {
		this.question = question;
	}
	
	
}
