package ua.prog.java.lesson4;

public class Student extends Human {

	private static final long serialVersionUID = 1L;

	public Student(String name, String surname, String sex, int age) {
		super(name, surname, sex, age);
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Студент [Имя:" + getName() + ", Фамилия:" + getSurname() + ", Пол:" + getSex() + ", Возраст:" + getAge()
				+ "]";
	}

}
