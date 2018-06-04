package dataLayer;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * Class that represents person .
 *
 * @author plisik
 */
@SuppressWarnings("serial")
public class Person implements Serializable{
	
	/** The name. */
	String name;
	
	/** The surname. */
	String surname;

	/**
	 * Instantiates a new person.
	 *
	 * @param _name the name
	 * @param _surname the surname
	 */
	public Person(String _name, String _surname) {
		name = _name;
		surname = _surname;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the sur name.
	 *
	 * @param surName the new sur name
	 */
	public void setSurName(String surName) {
		this.surname = surName;
	}

	/**
	 * Instantiates a new person.
	 */
	public Person() {
		name = "No Name";
		surname = "No Surname";
	}

	/**
	 * Equals.
	 *
	 * @param p the p
	 * @return true, if successful
	 */
	public boolean equals(Person p) {
		if (p == null)
			return false;

		return this.name.equals(p.getName()) && this.surname.equals(p.getSurname());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " " + surname;
	}

}
