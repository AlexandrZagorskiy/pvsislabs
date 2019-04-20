package controller;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import labwork2.model.Student;

public class SaveFile {

	private List<Student> students;
	String dir = "students.xml";
	
	public SaveFile(List<Student> students) {
		this.students = students;
		writeStudentsXML();
	}
	
	private void writeStudentsXML()
	{
		DocumentBuilderFactory dbf = null;
		DocumentBuilder db  = null;
		Document doc = null;
		
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			doc = db.newDocument();

			Element e_root = doc.createElement("students");
			
			for(Student student : students) {
				e_root.appendChild(getStudent(doc, student));
			}
			
			doc.appendChild(e_root);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult file = new StreamResult(new File(dir));

            transformer.transform(source, file);
        } 
		catch (Exception e) {
            e.printStackTrace();
        }
	}

	
    private Node getStudent(Document doc, Student student) {
        Element e_student = doc.createElement("student");
        
        e_student.appendChild(getStudentElements(doc, e_student, "surname", student.getSurname()));
        e_student.appendChild(getStudentElements(doc, e_student, "name", student.getName()));
        e_student.appendChild(getStudentElements(doc, e_student, "patronymic", student.getPatronymic()));
        e_student.appendChild(getStudentElements(doc, e_student, "course", Integer.toString(student.getCourse().getCourseNumber())));
        e_student.appendChild(getStudentElements(doc, e_student, "group", student.getGroup().getGroupNumber()));
        e_student.appendChild(getStudentElements(doc, e_student, "works_max", Integer.toString(student.getWorks().getWorksMax())));
        e_student.appendChild(getStudentElements(doc, e_student, "works_made", Integer.toString(student.getWorks().getWorksMade())));
        e_student.appendChild(getStudentElements(doc, e_student, "prog_lang", student.getProgLanguage().getProgLanguage()));
        
        return e_student;
    }

    private Node getStudentElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
	
}
