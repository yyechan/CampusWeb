package shop.dongguktime.web.dto;

public class TimeTableDTO {
	
	private String courseNum;
	private String courseName;
	private String courseTime;
	private String courseLecturer;
	private String courseLocation;
	private int courseScore;
	
	public TimeTableDTO(String courseNum, String courseName, String courseTime, String courseLecturer,
			String courseLocation, int courseScore) {
		
		this.courseNum = courseNum;
		this.courseName = courseName;
		this.courseTime = courseTime;
		this.courseLecturer = courseLecturer;
		this.courseLocation = courseLocation;
		this.courseScore = courseScore;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public String getCourseLecturer() {
		return courseLecturer;
	}

	public void setCourseLecturer(String courseLecturer) {
		this.courseLecturer = courseLecturer;
	}

	public String getCourseLocation() {
		return courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}

	public int getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(int courseScore) {
		this.courseScore = courseScore;
	}

	
	
	
}
