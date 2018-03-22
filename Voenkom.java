package ua.prog.java.lesson4;

import java.util.ArrayList;
import java.util.List;

public interface Voenkom {

	default List<Student> getSoldiers(Student[] studentsGroup) {
		List<Student> soldiers = new ArrayList<Student>();
		for (Student soldier : studentsGroup) {
			if (soldier.getSex().equals("male") && soldier.getAge() > 18) {
				soldiers.add(soldier);
			}
		}

		return soldiers;
	}

}
