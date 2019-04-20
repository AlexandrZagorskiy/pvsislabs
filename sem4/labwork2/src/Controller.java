import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import controller.LoadFile;
import controller.SaveFile;
import labwork2.model.Student;

public class Controller {
	
    private List<Student> students;
    String dir = "D:\\projects on Java\\LabPpvis\\sem4\\labwork2\\src\\controller\\";
    
    public Controller() {
    	students = new ArrayList<Student>();
    }

	public void generateStudents(int countStudents) {		
		
	}
	
	public List<Student> load(String fileDir) {
		students.clear();
	    try {
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        factory.setValidating(false);
	        SAXParser saxParser = factory.newSAXParser();
	        LoadFile handler = new LoadFile();
	        saxParser.parse("students.xml", handler);
	        
	        students = handler.getStudentList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
		return students;	    
	}
	
	public void save(List<Student> students) {
		new SaveFile(students);
	}
}
