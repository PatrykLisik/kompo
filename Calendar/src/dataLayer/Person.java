package dataLayer;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable{
	String name;
	String surname;

	public Person(String _name, String _surname) {
		name = _name;
		surname = _surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurName(String surName) {
		this.surname = surName;
	}

	Person() {
		name = "No Name";
		surname = "No Surname";
	}

	public boolean equals(Person p) {
		if (p == null)
			return false;

		return this.name.equals(p.getName()) && this.surname.equals(p.getSurname());
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}

}
