package ex;

import java.util.Arrays;

public class TelephoneBook {
	Object[] data;
	TelephoneBook() {
		data = new Object[10];
	}

	TelephoneBook(int number, Object what) {
		data = new Object[10];
		Arrays.fill(data, what);
	}

	public void AddPerson(Object obj) {
		Object[] newData = new Object[data.length + 1];
		newData[data.length] = obj;
		data = newData;
	}

	public void RemovePerson(int pos) {
		Object[] ans = new Object[data.length];
		System.arraycopy(data, 0, ans, 0, pos - 1);
		System.arraycopy(data, pos, ans, pos - 1, data.length - pos - 1);
		data = ans;
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
