package studentdatabase;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;

	// Constructor: prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		this.firstName = in.nextLine();
		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();
		System.out.println("Press 1 for Freshman\nPress 2 for Sophmore\nPress 3 for Junion\nPress 4 for Senior");
		this.gradeYear = in.nextInt();
		setStudentId();
		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentId);

	}

	// Generate Id
	private void setStudentId() {
		// Grade level + id
		id++;
		this.studentId = gradeYear + "" + id;
	}

	// Enroll in courses
	public void enroll() {
		// Get inside a loop, user hits 0
		do {
			System.out.println("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equalsIgnoreCase("q")) {
				courses = courses + "\n" + course;
				tuitionBalance += costOfCourse;
			} else {
				break;
			}
		} while (1 != 0);
		System.out.println("Enrolled in: " + courses);
		System.out.println("Tuition balance: " + tuitionBalance);
	}

	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: " + tuitionBalance);
	}

	// Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.println("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of " + payment);
		System.out.println("Tuition balance: " + tuitionBalance);
	}

	// Show status
	public String showInfo() {
		return "Name: " + firstName + " " + lastName + "\nGrade Level: " + gradeYear + "\nStudent ID: " + studentId
				+ "\nCourses Enrolled: " + courses + "\nBalance: " + tuitionBalance;
	}

}

// change ints to doubles, figure out how to format for money
// modify for tests