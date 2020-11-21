package shop.dongguktime.web.dto;

public class TimeTableDTO {
	
	private String classId;
	private String className;
	private String professorName;
	private String dayOfWeekTime;
	private String classLocation;
	private int classScore;
	
	
	
	
	public TimeTableDTO(String classId, String className, String professorName, String dayOfWeekTime,
			String classLocation, int classScore) {
		
		this.classId = classId;
		this.className = className;
		this.professorName = professorName;
		this.dayOfWeekTime = dayOfWeekTime;
		this.classLocation = classLocation;
		this.classScore = classScore;
	}
	
	
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getDayOfWeekTime() {
		return dayOfWeekTime;
	}
	public void setDayOfWeekTime(String dayOfWeekTime) {
		this.dayOfWeekTime = dayOfWeekTime;
	}
	public String getClassLocation() {
		return classLocation;
	}
	public void setClassLocation(String classLocation) {
		this.classLocation = classLocation;
	}
	public int getClassScore() {
		return classScore;
	}
	public void setClassScore(int classScore) {
		this.classScore = classScore;
	}
	
	
	
	
	
	
	
	
	
	
}
