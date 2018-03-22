package ua.prog.java.lesson4;

public class Main {

	public static void main(String[] args) {
		Group newGroup = new Group(1);
		Student newStudent = new Student("Vasya", "Rudenko", "male", 39);
		newGroup.addStudent(new Student("Rita", "Molarenko", "female", 33));
		newGroup.addStudent(new Student("Kostya", "Bukavenko", "male", 12));
		newGroup.addStudent(new Student("Bogdan", "Vladimenko", "male", 45));
		newGroup.addStudent(new Student("Anna", "Makarenko", "female", 17));
		newGroup.addStudent(new Student("Taras", "Killer", "male", 19));
		newGroup.addStudent(newStudent);

		System.out.println("\n ������� ��������� �������� �������:");
		newGroup.createStudentManually();

		System.out.println("\n --------- ������ ������ ��������� ---------");
		System.out.print(newGroup.toString());
		System.out.println(" -------------------------------------------\n");

		System.out.println("\n --------- ���������� ������� �������� ---------");
		newGroup.deleteStudent(new Student("CXAXA4", "Lopata", "m", 39));
		System.out.println(" -------------------------------------------------\n");

		System.out.println("\n --------- ������ ������ ��������� ---------");
		System.out.print(newGroup.toString());
		System.out.println(" -------------------------------------------\n");

		String studentSurname = "Vladimenko";

		System.out.println("����� ��������� � �������� " + studentSurname + ":");
		for (Student foundStudent : newGroup.getStudentsBySurname(studentSurname)) {
			System.out.println(foundStudent);
		}

		System.out.println("\n��������� ��������� �� �� ��������, ��������� ���������: ");
		newGroup.sortStudentsBySurnameUsingInterface();

		System.out.println("\n��������� ��������� �� ��������� ���������, ��������� ���������: ");
		newGroup.sortStudentsByParameterUsingInterface("name");

		System.out.println("\n��������� ��������� �� �� ��������: ");
		newGroup.sortStudentsBySurname();

		System.out.println("\n���� ���������� ��� ������ ������ ������ ������ 18��: ");
		for (Student soldier : newGroup.getStudentsForVoenkom()) {
			System.out.println(soldier);
		}

	}
}
