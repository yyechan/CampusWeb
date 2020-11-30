package shop.dongguktime.web.dto;

public class TimeTableDTO {
	
	private String timeTableName;
	private String userId;
	private String classId;
	
	
	
	
	public TimeTableDTO() {}
	
	
	public TimeTableDTO(String timeTableName, String userId, String classId) {
		super();
		this.timeTableName = timeTableName;
		this.userId = userId;
		this.classId = classId;
	}
	
	
	
	public String getTimeTableName() {
		return timeTableName;
	}
	public void setTimeTableName(String timeTableName) {
		this.timeTableName = timeTableName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	
	
	
	
	

}
