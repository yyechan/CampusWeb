package shop.dongguktime.web.dto;

import java.sql.Timestamp;

public class BoardDTO {
	
	private int bNum;
	private String bId;
	private String bTitle;
	private String bContent;
	private Timestamp bDate;
	private int bType; // 1 : 자유, 2 : 익명, 3 : 장터
	private String bImageUri;
	
	
	public BoardDTO() {}
	
	public BoardDTO(int bNum, String bId, String bTitle, String bContent, Timestamp bDate, int bType,
			String bImageUri) {
		
		this.bNum = bNum;
		this.bId = bId;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bType = bType;
		this.bImageUri = bImageUri;	
	}
	
	public int getbNum() {
		return bNum;
	}
	public String getbId() {
		return bId;
	}
	public String getbTitle() {
		return bTitle;
	} 
	public String getbContent() {
		return bContent;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public int getbType() {
		return bType;
	}
	public String getbImageUri() {
		return bImageUri;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public void setbType(int bType) {
		this.bType = bType;
	}
	public void setbImageUri(String bImageUri) {
		this.bImageUri = bImageUri;
	}
	
	
	
	
	
	
}
