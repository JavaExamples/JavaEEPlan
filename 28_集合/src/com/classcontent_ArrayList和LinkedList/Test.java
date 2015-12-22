package com.classcontent_ArrayList和LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		// 数组装三个学生
		Student student[] = new Student[3];
		student[0] = new Student("A", 10);
		student[1] = new Student("B", 11);
		student[2] = new Student("C", 12);
		for (Student s : student) {
			System.out.println(s.getName());
		}

		// 链表存学生
		LinkedList<Student> llist = new LinkedList<Student>();
		llist.add(new Student("A", 10));
		llist.add(new Student("B", 10));
		llist.add(new Student("C", 10));
		for (int i = 0; i < llist.size(); i++) {
			Student s = llist.get(i);
			System.out.println(s.getName());
		}

		// 链表存学生
		ArrayList<Student> alist = new ArrayList<Student>();
		alist.add(new Student("A", 10));
		alist.add(new Student("B", 10));
		alist.add(new Student("C", 10));
		for (int i = 0; i < alist.size(); i++) {
			Student s = alist.get(i);
			System.out.println(s.getName());
		}

	}
}
