package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserLog implements Comparable<UserLog>{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

	
	private String userName;
	private Date moment;
	
	public UserLog(String userName, Date moment) {
		this.userName = userName;
		this.moment = moment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getMomentum() {
		return moment;
	}

	public void setMomentum(Date momentum) {
		this.moment = momentum;
	}
	
	@Override
	public int compareTo(UserLog other) {
		return userName.compareTo(other.getUserName());
	}
	
	
}
