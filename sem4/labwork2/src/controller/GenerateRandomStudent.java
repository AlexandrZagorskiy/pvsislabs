package controller;

import java.util.List;
import java.util.Random;

import labwork2.model.*;

public class GenerateRandomStudent {
	private static String[] surnameList = {
			"Авдеев", "Андреев", "Анисимов", "Антонов", "Баранов", "Белозёров", "Богданов", "Быков", "Волков", "Воронов", "Герасимов", "Гордеев", "Громов", "Денисов", "Ермаков", "Жданов", "Жуков", "Захаров", "Иванов", "Терентьев", "Кабанов", "Киселёв", "Колесников", "Корнилов", "Котов", "Кузнецов", "Лихачёв", "Михайлов", "Молчанов", "Нестеров", "Носов", "Орехов", "Панфилов", "Поляков", "Прохоров", "Рябов", "Селезнёв", "Силин", "Соболев", "Субботин", "Тимофеев", "Титов", "Уваров", "Федотов", "Филиппов", "Хохлов", "Харитонов", "Шарапов", "Шашков", "Шестаков ", "Щукин", "Юдин", "Чернов", "Цветков", "Фролов"
	},
	nameList = {
			"Артем", "Максим", "Иван", "Алексей", "Никита", "Александр", "Владислав", "Даниил", "Дмитрий", "Михаил", "Кирилл", "Павел", "Илья", "Роман", "Егор", "Тимофей", "Андрей", "Ярослав", "Ульфрик", "Дарья", "Анастасия", "Анна", "Полина", "Ксения", "Елизавета", "Екатерина", "Александра", "Виктория", "София", "Валерия", "Варвара", "Арина", "Ульяна", "Алиса", "Алина", "Маргарита", "Яна", "Мария"
	},
    patronymicList = {
    		"Александров", "Алексеев", "Андреев", "Артемов", "Валериев", "Васильев", "Викторов", "Вячеславов", "Данилов", "Дмитриев", "Богданов", "Николаев", "Олегов", "Георгиев", "Григорьев", "Евгеньев", "Романов", "Павлов", "Петров", "Кириллов", "Леонидов", "Максимов", "Эдуардов", "Ярославов"
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
    		
    		if (nameList[nameNumber].equals("Ульфрик")) {
    			temp = nameNumber;
    		}
    		
    		if (nameList[nameNumber].equals(name)) {
    			if (nameNumber <= temp) {
    				patronymic += "ич";
    			} else {
    				surname += "а";
    				patronymic += "на";
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
