package ua.prog.java.lesson4;

import java.io.Serializable;

public class Human implements Comparable, Serializable {
	private String name;
	private String surname;
	private String sex;
	private int age;

	public Human(String name, String surname, String sex, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.age = age;
	}

	public Human() {

	}

	@Override
	public int compareTo(Object o) {
		if (o == null) {
			return -1;
		}
		Human anotherHuman = (Human) o;
		return this.surname.compareToIgnoreCase(anotherHuman.getSurname());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (age != other.age)
			return false;
		return true;
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

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [Name=" + name + ", Surname=" + surname + ", Sex=" + sex + ", age=" + age + "]";
	}

}
