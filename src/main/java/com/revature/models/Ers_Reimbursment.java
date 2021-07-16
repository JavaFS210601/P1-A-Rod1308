package com.revature.models;

public class Ers_Reimbursment {
	public int reimb_id;
	public int reimb_amount;
	public String reimb_submited;
	public String reimb_resolved;
	public String reimb_description;
	public String reimb_receipt;
	public int reimb_author;
	public int reimb_resolver;
	public int reimb_status_id;
	public int reimb_type_id;
	
	/**
	 * 
	 * @param reimb_id
	 * @param reimb_amount
	 * @param reimb_submited
	 * @param reimb_resolved
	 * @param reimb_description
	 * @param reimb_receipt
	 * @param reimb_author
	 * @param reimb_resolver
	 * @param reimb_status_id
	 * @param reimb_type_id
	 */
	public Ers_Reimbursment(int reimb_id, int reimb_amount, String reimb_submited, String reimb_resolved,
			String reimb_description, String reimb_receipt, int reimb_author, int reimb_resolver, int reimb_status_id,
			int reimb_type_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submited = reimb_submited;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}

	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_submited() {
		return reimb_submited;
	}
	public void setReimb_submited(String reimb_submited) {
		this.reimb_submited = reimb_submited;
	}

	public String getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(String reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	
	public String getReimb_receipt() {
		return reimb_receipt;
	}
	public void setReimb_receipt(String reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}

	public int getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}
	
	public int getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	
	public int getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}
	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	
	@Override
	public String toString() {
		return "Ers_Reimbursment [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submited="
				+ reimb_submited + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt=" + reimb_receipt + ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + ", reimb_status_id=" + reimb_status_id + ", reimb_type_id=" + reimb_type_id + "]";
	}
	
	
	
	
	
	
	
	

}
