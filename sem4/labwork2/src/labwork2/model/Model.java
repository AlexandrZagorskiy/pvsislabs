package labwork2.model;
import java.util.List;

import labwork2.model.*;

public class Model {

	private List<Student> studentsInTable;
	
	public Model(List<Student> studentsInTable) {
		this.studentsInTable = studentsInTable;
	}

	public List<Student> getStudentsInTable() {
		return studentsInTable;
	}
	
	
	
	
	public void setStudentsInTable(List<Student> studentsInTable) {
		this.studentsInTable = studentsInTable;
	}	
}
