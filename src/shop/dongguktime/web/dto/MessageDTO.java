package shop.dongguktime.web.dto;

public class MessageDTO {
	
	int mNum;
	String mToId;
	String mFromId;
	String mContent;
	
	
	public MessageDTO() {}


	public MessageDTO(int mNum, String mToId, String mFromId, String mContent) {
		
		this.mNum = mNum;
		this.mToId = mToId;
		this.mFromId = mFromId;
		this.mContent = mContent;
	}


	public int getmNum() {
		return mNum;
	}


	public void setmNum(int mNum) {
		this.mNum = mNum;
	}


	public String getmToId() {
		return mToId;
	}


	public void setmToId(String mToId) {
		this.mToId = mToId;
	}


	public String getmFromId() {
		return mFromId;
	}


	public void setmFromId(String mFromId) {
		this.mFromId = mFromId;
	}


	public String getmContent() {
		return mContent;
	}


	public void setmContent(String mContent) {
		this.mContent = mContent;
	};
	
	
	

}
