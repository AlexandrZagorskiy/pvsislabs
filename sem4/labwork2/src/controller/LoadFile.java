package controller;
import org.xml.sax.helpers.*;

import labwork2.model.Student;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.*; 
 
public class LoadFile extends DefaultHandler { 

	private String thisElement = "";
	private Student student;
	private List<Student> students;
 
	public List<Student> getStudentList() {
		return students;
	}
	
	
	
	@Override 
	public void startDocument() throws SAXException { 
	}
	
	@Override 
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {			
		this.thisElement = qName;

		if (thisElement.equalsIgnoreCase("students")) { 
			students = new ArrayList<Student>();
		}
	}		
 
	@Override 
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		  thisElement = "";
	} 
 
	@Override 
	public void characters(char[] ch, int start, int length) throws SAXException { 
		if (thisElement.equalsIgnoreCase("student")) { 
			student = new Student();
		}			
		if (thisElement.equalsIgnoreCase("surname")) { 
			String surname = new String(ch, start, length);
			student.setSurname(surname); 
		} 
		if (thisElement.equalsIgnoreCase("name")) { 
		     student.setName(new String(ch, start, length)); 
		} 
		if (thisElement.equalsIgnoreCase("patronymic")) { 
		     student.setPatronymic(new String(ch, start, length)); 
		} 
		if (thisElement.equalsIgnoreCase("course")) { 
		     student.getCourse().setCourseNumber(new Integer(new String(ch, start, length))); 
		} 
		if (thisElement.equalsIgnoreCase("group")) { 
		     student.getGroup().setGroupNumber(new String(ch, start, length)); 
		} 
		if (thisElement.equalsIgnoreCase("works_max")) { 
		     student.getWorks().setWorksMax(new Integer(new String(ch, start, length))); 
		} 
		if (thisElement.equalsIgnoreCase("works_made")) { 
		     student.getWorks().setWorksMade(new Integer(new String(ch, start, length))); 
		} 
		if (thisElement.equalsIgnoreCase("prog_lang")) { 
		     student.getProgLanguage().setProgLanguage(new String(ch, start, length)); 
		     this.students.add(student);
		}
	}
} 