package controller;

import java.util.List;
import java.util.Random;

import labwork2.model.*;

public class GenerateRandomStudent {
	private static String[] surnameList = {
			"������", "�������", "��������", "�������", "�������", "��������", "��������", "�����", "������", "�������", "���������", "�������", "������", "�������", "�������", "������", "�����", "�������", "������", "���������", "�������", "������", "����������", "��������", "�����", "��������", "�������", "��������", "��������", "��������", "�����", "������", "��������", "�������", "��������", "�����", "�������", "�����", "�������", "��������", "��������", "�����", "������", "�������", "��������", "������", "���������", "�������", "������", "�������� ", "�����", "����", "������", "�������", "������"
	},
	nameList = {
			"�����", "������", "����", "�������", "������", "���������", "���������", "������", "�������", "������", "������", "�����", "����", "�����", "����", "�������", "������", "�������", "�������", "�����", "���������", "����", "������", "������", "���������", "���������", "����������", "��������", "�����", "�������", "�������", "�����", "������", "�����", "�����", "���������", "���", "�����"
	},
    patronymicList = {
    		"�����������", "��������", "�������", "�������", "��������", "��������", "��������", "����������", "�������", "��������", "��������", "��������", "������", "��������", "���������", "��������", "�������", "������", "������", "��������", "��������", "��������", "��������", "���������"
    },
    progLangList = {
    		"Java", "JavaScript", "C++", "C#", "C", "Python", "Go", "Rust", "Ruby", "PHP"
    };
	
	public GenerateRandomStudent(int studentsCount, List<Student> students) {
		for(int currStudent = 0; currStudent < studentsCount; currStudent++) {
			students.add(generateStudent());
		}
	}

    private Student generateStudent() {
    	int temp = nameList.length;
    	String surname = getSurname();
    	String name = getName();
    	String patronymic = getPatronymic();
    	for(int nameNumber = 0; nameNumber < nameList.length; nameNumber++) {
    		
    		if (nameList[nameNumber].equals("�������")) {
    			temp = nameNumber;
    		}
    		
    		if (nameList[nameNumber].equals(name)) {
    			if (nameNumber <= temp) {
    				patronymic += "��";
    			} else {
    				surname += "�";
    				patronymic += "��";
    			}
    		}
    	}
    	
    	Student student = new Student(surname, name, patronymic, getCourse(), getGroup(), getWorks(), getProgLangList());
    	
		return student;
	}

    private static StudGroup getGroup() {
    	String groupName = Integer.toString(generateRandomNumberInRange(4,8)) +
    			Integer.toString(generateRandomNumberInRange(10,21)) +
    			Integer.toString(generateRandomNumberInRange(4,9)) +
    			"0" +
    			Integer.toString(generateRandomNumberInRange(1,4));
    	return new StudGroup(groupName);
    }
    
    private static String getSurname() {
        return surnameList[new Random().nextInt(surnameList.length)];
    }

    private static String getName() {
        return nameList[new Random().nextInt(nameList.length)];
    }

    private static String getPatronymic() {
        return patronymicList[new Random().nextInt(patronymicList.length)];
    }

    private static Course getCourse() {
        return new Course(generateRandomNumberInRange(1,6));
    }
    
    private static ProgLanguage getProgLangList() {
        return new ProgLanguage(progLangList[new Random().nextInt(progLangList.length)]);
    }

    public static int generateRandomNumberInRange(int min, int max) {
    	Random r = new Random();
    	return r.nextInt((max - min) + 1) + min;
    }
    
    private static Works getWorks() {
    	int workMax = generateRandomNumberInRange(10,20);
    	int workMade = generateRandomNumberInRange(0, workMax);    	
    	return new Works(workMax, workMade);
    }
}
