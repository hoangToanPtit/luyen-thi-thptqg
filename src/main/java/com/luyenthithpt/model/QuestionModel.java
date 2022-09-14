package com.luyenthithpt.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionModel {
	private int questionID, answer;
	private String description, selection1, selection2, selection3, selection4;

	public QuestionModel() {
	}

	public QuestionModel(String description, String selection1, String selection2, String selection3,
			String selection4, int answer) {
		this.description = description;
		this.selection1 = selection1;
		this.selection2 = selection2;
		this.selection3 = selection3;
		this.selection4 = selection4;
		this.answer = answer;
	}
	
	public QuestionModel(int questionID, String description, String selection1, String selection2, String selection3,
			String selection4, int answer) {
		this.questionID = questionID;
		this.description = description;
		this.selection1 = selection1;
		this.selection2 = selection2;
		this.selection3 = selection3;
		this.selection4 = selection4;
		this.answer = answer;
	}

	public int getQuestionID() {
		return questionID;
	}

	public String getDescription() {
		return description;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getSelection1() {
		return selection1;
	}

	public String getSelection2() {
		return selection2;
	}

	public String getSelection3() {
		return selection3;
	}

	public String getSelection4() {
		return selection4;
	}

	public int getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return questionID + " " + description;
	}

}
