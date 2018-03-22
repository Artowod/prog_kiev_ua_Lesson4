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

		System.out.println("\n Зададим параметры студента вручную:");
		newGroup.createStudentManually();

		System.out.println("\n --------- Состав группы студентов ---------");
		System.out.print(newGroup.toString());
		System.out.println(" -------------------------------------------\n");

		System.out.println("\n --------- Попытаемся удалить студента ---------");
		newGroup.deleteStudent(new Student("CXAXA4", "Lopata", "m", 39));
		System.out.println(" -------------------------------------------------\n");

		System.out.println("\n --------- Состав группы студентов ---------");
		System.out.print(newGroup.toString());
		System.out.println(" -------------------------------------------\n");

		String studentSurname = "Vladimenko";

		System.out.println("Найти студентов с фамилией " + studentSurname + ":");
		for (Student foundStudent : newGroup.getStudentsBySurname(studentSurname)) {
			System.out.println(foundStudent);
		}

		System.out.println("\nСортируем студентов по их фамилиям, используя интерфейс: ");
		newGroup.sortStudentsBySurnameUsingInterface();

		System.out.println("\nСортируем студентов по заданному параметру, используя интерфейс: ");
		newGroup.sortStudentsByParameterUsingInterface("name");

		System.out.println("\nСортируем студентов по их фамилиям: ");
		newGroup.sortStudentsBySurname();

		System.out.println("\nИщем подходящих для защиты Родины парней старше 18ти: ");
		for (Student soldier : newGroup.getStudentsForVoenkom()) {
			System.out.println(soldier);
		}

	}
}
