package shop.dongguktime.web.dto;

public class MemberDTO {

	
	private String id;
	private String pw;
	private String name;
	private String eMail;
	private boolean isAuthenticated;
	
	public MemberDTO(String id, String pw,String name, String eMail,boolean isAuthenticated) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.eMail = eMail;
		this.isAuthenticated = isAuthenticated;	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.id = name;
	}
	
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public boolean getIsAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	
	
	
}
