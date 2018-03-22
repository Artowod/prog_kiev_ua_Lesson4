package ua.prog.java.lesson4;

import java.awt.IllegalComponentStateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

public class Group implements Voenkom {
	private int groupNumber;
	private int groupSize = 10;
	private Student[] groupOfStudents = new Student[groupSize];

	public Group(int groupNumber) {
		super();
		this.groupNumber = groupNumber;
	}

	public Group() {
		super();
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

	public Student[] getGroupOfStudents() {
		return groupOfStudents;
	}

	public void setGroupOfStudents(Student[] groupOfStudents) {
		this.groupOfStudents = groupOfStudents;
	}

	public void createStudentManually() {
		String name;
		String surname;
		String sex;
		int age;
		try {
			// Scanner reader = new Scanner(System.in);
			// String s = reader.nextLine();

			name = String.valueOf(JOptionPane.showInputDialog("Please put the Student`s name"));
			System.out.println(name);
			surname = String.valueOf(JOptionPane.showInputDialog("Please put the Student`s surname"));
			System.out.println(surname);
			sex = String.valueOf(JOptionPane.showInputDialog("Male of Female ?"));
			System.out.println(sex);
			age = Integer.valueOf(JOptionPane.showInputDialog("How old is he/she ? (put full years)"));
			System.out.println(age);
			checkStudentParameters(name, surname, sex, age);

		} catch (InputDataErrorException ex) {
			System.out.println(ex.getMessage());
			return;
		} catch (NumberFormatException ex) {
			System.out.println("Возраст студента задан не верно.");
			return;
		}
		addStudent(new Student(name, surname, sex, age));
	}

	private void checkStudentParameters(String name, String surname, String sex, int age)
			throws InputDataErrorException {
		String sexInLowerCase = sex.toLowerCase();
		if (name.length() < 2) {
			throw new InputDataErrorException("Слишком короткое имя (или вообще забыли его ввести).");
		}
		if (name.contains(" ")) {
			throw new InputDataErrorException("В имени пробелы недопустимы.");
		}
		if (surname.length() < 2) {
			throw new InputDataErrorException("Слишком короткая фамилия (или вообще забыли её ввести).");
		}
		if (surname.contains(" ")) {
			throw new InputDataErrorException("В фамилии пробелы недопустимы.");
		}
		if (!(sexInLowerCase.equals("male")) && !(sexInLowerCase.equals("female"))) {
			throw new InputDataErrorException("Проверьте пол. Должно быть Male или Female.");
		}
		if (age > 80 || age < 8) {
			throw new InputDataErrorException("Возраст подозрительный, как для студента.");
		}
	}

	public Student[] sortStudentsBySurnameUsingInterface() {
		Student[] sortedStudentsBySurnameUsingInterface = getArrayWithoutNulls(groupOfStudents);
		Arrays.sort(sortedStudentsBySurnameUsingInterface);
		for (Student student : sortedStudentsBySurnameUsingInterface)
			System.out.println(student.toString());
		return sortedStudentsBySurnameUsingInterface;

	}

	public Student[] sortStudentsByParameterUsingInterface(String parameter) {
		System.out.println(" Заданный параметр сортировки - " + parameter);
		Student[] sortedStudentsByParameterUsingInterface = getArrayWithoutNulls(groupOfStudents);
		if (parameter == "name") {
			Arrays.sort(sortedStudentsByParameterUsingInterface, new Comparator<Student>() {
				public int compare(Student st1, Student st2) {
					return st1.getName().compareToIgnoreCase(st2.getName());
				}
			});
		}
		if (parameter == "surname") {
			Arrays.sort(sortedStudentsByParameterUsingInterface, new Comparator<Student>() {
				public int compare(Student st1, Student st2) {
					return st1.getSurname().compareToIgnoreCase(st2.getSurname());
				}
			});
		}
		if (parameter == "age") {
			Arrays.sort(sortedStudentsByParameterUsingInterface, new Comparator<Student>() {
				public int compare(Student st1, Student st2) {
					return st1.getAge() - st2.getAge();
				}
			});
		}
		if (parameter == "sex") {
			Arrays.sort(sortedStudentsByParameterUsingInterface, new Comparator<Student>() {
				public int compare(Student st1, Student st2) {
					return st1.getSex().compareToIgnoreCase(st2.getSex());
				}
			});
		}
		for (Student student : sortedStudentsByParameterUsingInterface) {
			System.out.println(student.toString());
		}
		return sortedStudentsByParameterUsingInterface;
	}

	public Student[] sortStudentsBySurname() {
		Student[] sortedStudentsBySurname = getArrayWithoutNulls(groupOfStudents);
		Student tempStudent;
		/*
		 * String.compareTo(String) : Abbaa Gamma = -6 Gamma Betta = 5
		 */
		for (int y = sortedStudentsBySurname.length - 1; y > 0; y--) {
			for (int x = 0; x < y; x++) {
				int i = sortedStudentsBySurname[x].getSurname().compareTo(sortedStudentsBySurname[x + 1].getSurname());
				if (i > 0) {
					tempStudent = sortedStudentsBySurname[x + 1];
					sortedStudentsBySurname[x + 1] = sortedStudentsBySurname[x];
					sortedStudentsBySurname[x] = tempStudent;
				}
			}
		}
		for (Student student : sortedStudentsBySurname)
			System.out.println(student.toString());
		return sortedStudentsBySurname;
	}

	private Student[] getArrayWithoutNulls(Student[] arrayWithNulls) {
		int arrayWithoutNullsLength = 0;
		for (Student st : arrayWithNulls) {
			if (st != null) {
				arrayWithoutNullsLength++;
			}
		}
		Student[] arrayWithoutNulls = new Student[arrayWithoutNullsLength];
		int y = 0;
		for (int x = 0; x < arrayWithNulls.length; x++) {
			if (arrayWithNulls[x] != null) {
				arrayWithoutNulls[y++] = arrayWithNulls[x];
			}
		}
		return arrayWithoutNulls;
	}

	public List<Student> getStudentsBySurname(String surname) {
		List<Student> foundStudentsBySurname = new ArrayList<Student>();
		Boolean isStudentsDetected = false;
		for (Student student : groupOfStudents) {
			if (student != null) {
				if (student.getSurname() == surname) {
					foundStudentsBySurname.add(student);
					isStudentsDetected = true;
				}
			}
		}
		if (!isStudentsDetected) {
			System.out.println("Студентов по заданному параметру не обнаружено.");
		}
		return foundStudentsBySurname;
	}

	public void addStudent(Student newStudent) {
		if (isStudentAlreadyIn(newStudent)) {
			System.out.println("Cтудент " + newStudent.toString() + " уже есть в группе.");
		} else {
			try {
				putUniqueStudentToGroup(newStudent);
			} catch (ManyStudentsException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private Boolean isStudentAlreadyIn(Student checkedStudent) {
		for (Student student : groupOfStudents) {
			if (student != null) {
				if (student.equals(checkedStudent)) {
					return true;
				}
			}
		}
		return false;
	}

	private void putUniqueStudentToGroup(Student newStudent) throws ManyStudentsException {
		int counterFirstFreeSpaceInGroup = -1;
		int counterStudentInGroup = 0;
		for (Student student : groupOfStudents) {
			counterFirstFreeSpaceInGroup += 1;
			if (student == null) {
				groupOfStudents[counterFirstFreeSpaceInGroup] = newStudent;
				break;
			} else {
				counterStudentInGroup += 1;
			}
		}
		if (counterStudentInGroup == groupSize)
			throw new ManyStudentsException();
	}

	public void deleteStudent(Student deletingStudent) {
		int counterStudentPositionInGroup = -1;
		for (Student student : groupOfStudents) {
			counterStudentPositionInGroup += 1;
			if (student != null) {
				if (student.equals(deletingStudent)) {
					groupOfStudents[counterStudentPositionInGroup] = null;
					System.out.println("Cтудент " + deletingStudent + " успешно удалён.");
					break;
				}
			}
		}
		if (counterStudentPositionInGroup == groupSize - 1) {
			System.out.println("Заданный студент (" + deletingStudent + ") не числится в данной группе.");
		}
	}

	public List<Student> getStudentsForVoenkom() {
		return getSoldiers(getArrayWithoutNulls(groupOfStudents));
	}

	@Override
	public String toString() {
		String groupOfStudent = "";
		for (Student student : groupOfStudents) {
			if (student != null) {
				groupOfStudent += student.toString() + "\n";
			}
		}
		return groupOfStudent;
	}
}
