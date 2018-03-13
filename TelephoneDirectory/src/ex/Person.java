package ex;

import java.util.Comparator;

public class Person extends Object implements Comparable<Person>, Comparator<Person> {
	String name;
	String surName;
	static int id = 0;

	Person(String _name, String _surName) {
		name = _name;
		surName = _surName;
		id++;
	}

	Person() {
		name = "No Name";
		surName = "No Surname";
		id++;
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

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Person o) {
		return id - o.getId();
	}

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getId() - o2.getId();
	}

	@Override
	public String toString() {
		return name+" "+surName;

	}
}
