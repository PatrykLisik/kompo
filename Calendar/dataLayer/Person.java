package dataLayer;

public class Person {
	String name;
	String surName;

	Person(String _name, String _surName) {
		name = _name;
		surName = _surName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	Person() {
		name = "No Name";
		surName = "No Surname";
	}

}
