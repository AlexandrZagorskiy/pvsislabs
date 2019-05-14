import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import controller.LoadFile;
import controller.SaveFile;
import labwork2.model.Student;

public class Controller {
	
    private List<Student> students;
    
    public Controller(Model model) {
    	this.students = model.getStudentsInTable();
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
	        saxParser.parse(fileDir, handler);
	        
	        students = handler.getStudentList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
		return students;	    
	}
	
	public void save(List<Student> students, String dir) {
		new SaveFile(students, dir);
	}
}
