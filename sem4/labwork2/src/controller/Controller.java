package controller;
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
	
	public void load(String fileDir) {
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
	}
	
	public void save(List<Student> students, String dir) {
		new SaveFile(students, dir);
	}

	public Model getModel() {
		return this.model;
	}

}
