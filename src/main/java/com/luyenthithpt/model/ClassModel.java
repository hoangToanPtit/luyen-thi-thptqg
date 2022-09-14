package com.luyenthithpt.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassModel {
	private int classID, amount;
	private String Name;
	private Date date;
	private List<ExamModel> examModels;
	
	public ClassModel(int classID, String name, String date, int amount) throws ParseException {
		this.classID = classID;
		this.amount = amount;
		Name = name;
		this.date = new SimpleDateFormat("dd/mm/yyyy").parse(date);
		examModels = new ArrayList<ExamModel>();
	}
	
	
}
