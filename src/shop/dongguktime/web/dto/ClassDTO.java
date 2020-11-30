package shop.dongguktime.web.dto;

public class ClassDTO {
	
	private String classId;
	private String className;
	private String professorName;
	private String classLocation;
	private String classDay;
	private String startTime;
	private String endTime;
	private int classScore;
	
	
	
	
	public ClassDTO() {};
	
	public ClassDTO(String classId, String className, String professorName, String classLocation, String classDay,
			String startTime, String endTime, int classScore) {
		super();
		this.classId = classId;
		this.className = className;
		this.professorName = professorName;
		this.classLocation = classLocation;
		this.classDay = classDay;
		this.startTime = startTime;
		this.endTime = endTime;
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
	public String getClassLocation() {
		return classLocation;
	}
	public void setClassLocation(String classLocation) {
		this.classLocation = classLocation;
	}
	public String getClassDay() {
		return classDay;
	}
	public void setClassDay(String classDay) {
		this.classDay = classDay;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getClassScore() {
		return classScore;
	}
	public void setClassScore(int classScore) {
		this.classScore = classScore;
	}
	
	
	
	
	
	
	
}
