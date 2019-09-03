package com.ifi.profile.model;

import java.util.List;

public class Node {
	private String typeNode;
	
	private String labelNode;
	
	private List<Field> listFields;
	
	private String relation;
	
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getLabelNode() {
		return labelNode;
	}

	public void setLabelNode(String labelNode) {
		this.labelNode = labelNode;
	}

	public String getTypeNode() {
		return typeNode;
	}

	public void setTypeNode(String typeNode) {
		this.typeNode = typeNode;
	}

	public List<Field> getListFields() {
		return listFields;
	}

	public void setListFields(List<Field> listFields) {
		this.listFields = listFields;
	}
}
