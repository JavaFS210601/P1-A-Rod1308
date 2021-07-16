package com.revature.models;

public class Ers_Reimbursment_Status {
	public int reimb_status_id;
	public String reimb_status;
	
	
	
	
	public Ers_Reimbursment_Status(int reimb_status_id, String reimb_status) {
		super();
		this.reimb_status_id = reimb_status_id;
		this.reimb_status = reimb_status;
	}
	

	public Ers_Reimbursment_Status() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}


	public String getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}



	@Override
	public String toString() {
		return "Ers_Reimbursment_Status [reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status + "]";
	}
}
