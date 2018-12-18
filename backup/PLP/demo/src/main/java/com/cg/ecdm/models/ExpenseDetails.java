package com.cg.ecdm.models;


public class ExpenseDetails {
	private int expenseCode;

	private String expenseType;

	private String expenseDescription;
	public int getExpenseCode() {
		return expenseCode;
	}
	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseDescription() {
		return expenseDescription;
	}
	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
	@Override
	public String toString() {
		return "ExpenseDetails [expenseCode=" + expenseCode + ", expenseType="
				+ expenseType + ", expenseDescription=" + expenseDescription
				+ "]";
	}
	public ExpenseDetails(int expenseCode, String expenseType,
			String expenseDescription) {
		super();
		this.expenseCode = expenseCode;
		this.expenseType = expenseType;
		this.expenseDescription = expenseDescription;
	}
	public ExpenseDetails() {
		super();
	}
	
}
