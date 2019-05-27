package controller;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import labwork2.model.Model;
import labwork2.model.Student;

public class Controller {
	
    private Model model;
    
    public Controller(Model model) {
    	this.model = model;
    }
	
	public void addStudentInTable(Student student) {
		this.model.getStudentsInTable().add(student);
	}
	
	public List<Student> findStudentInTable(Student student) {
		
		List<Student> foundStudents = new ArrayList<Student>();
		List<Student> studentsInTable = this.model.getStudentsInTable();
		
		if (student.getName() == null &&
		student.getSurname() == null &&
		student.getPatronymic() == null &&
		student.getCourse()	== null &&
		student.getGroup() == null &&
		student.getWorks() == null &&
		student.getProgLanguage() == null) {
			for (Student currStud : studentsInTable) {
				foundStudents.add(currStud);
			}			
		} else {
			for (Student currStud : studentsInTable) {
				Student studentFromTable = currStud;
				
				if(student.getName() != null) {
					if (studentFromTable.getName().equals(student.getName())) {
						foundStudents.add(currStud);
					}
				} else if (student.getCourse() != null) {
					if (studentFromTable.getCourse().getCourseNumber() == student.getCourse().getCourseNumber()) {
						foundStudents.add(currStud);
					}				
				} else if (student.getGroup() != null) {
					if (studentFromTable.getGroup().getGroupNumber().equals(student.getGroup().getGroupNumber())) {
						foundStudents.add(currStud);
					}					
				} else if (student.getWorks() != null ) {
					if (studentFromTable.getWorks().getWorksMax() == student.getWorks().getWorksMax()) {	
						foundStudents.add(currStud);
					}
					if (studentFromTable.getWorks().getWorksMade() == student.getWorks().getWorksMade()) {	
						foundStudents.add(currStud);
					}
				} else if (student.getProgLanguage() != null) {
					if (studentFromTable.getProgLanguage().equals(student.getProgLanguage())) {
						foundStudents.add(currStud);
					}				
				}				
			}
		}		
		return foundStudents;
	}
	
	public List<Student> deleteStudentFromTable(Student student) {
		List<Student> delStudents = new ArrayList<Student>();
		List<Student> studentsInTable = model.getStudentsInTable();
		
		delStudents = findStudentInTable(student);
		
		for (int i = 0; i < studentsInTable.size(); i++) {
			for(int x = 0; x < delStudents.size(); x++) {
				if(studentsInTable.get(i).equals(delStudents.get(x))) {
					studentsInTable.remove(i);
				}				
			}			
		}
		model.setStudentsInTable(studentsInTable);
		return delStudents;
	}
	
	public List<Student> load(String fileDir) {
		List<Student> students = model.getStudentsInTable();
		students.clear();
	    try {
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        factory.setValidating(false);
	        SAXParser saxParser = factory.newSAXParser();
	        LoadFile handler = new LoadFile();
	        saxParser.parse(fileDir, handler);
	        
	        students = handler.getStudentList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    model.setStudentsInTable(students);
		return students;	    
	}
	
	public void save(List<Student> students, String dir) {
		new SaveFile(students, dir);
	}

	public Model getModel() {
		return this.model;
	}

}
