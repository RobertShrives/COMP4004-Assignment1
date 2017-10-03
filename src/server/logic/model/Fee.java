package server.logic.model;

public class Fee {
	int userid;
	int fee;
	
	public Fee(int userid,int fee){
		this.userid=userid;
		this.fee=fee;
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getFee() {
		return fee;
	}
}
