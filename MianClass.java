package com.student;
import java.util.*;
public class MianClass {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
StudentInterface s=new StudentImplementation();
System.out.println("1:save students//2:delete students//3:updateStudents//4:getAllStudents");
while(true)
{
	System.out.println("enter choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:s.saveStudent();
	System.out.println("-----------------");
	break;
	case 2:s.deleteStudent();
	System.out.println("-----------------");
	break;
	case 3:s.updateStudent();
	System.out.println("------------------");
	break;
	case 4:s.getAllStudent();
	break;
	case 5:System.out.println("thank you ");
	System.exit(1);
	default:System.out.println("enter  valid choice");
	}
}
	}

}
