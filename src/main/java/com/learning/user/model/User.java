package com.learning.user.model;

public class User extends GenericModel {
	
	private String userId;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userPassword;

	public String getUserId() {
		return userId;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}
	

	public String getUserPassword() {
		return userPassword;
	}	

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (!userLastName.equals(other.userLastName))
			return false;
		if (!userPassword.equals(other.userPassword))
			return false;
		if (!userEmail.equals(other.userEmail))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		}
	
	return false;
	}
		return false;
}
		return false;
}
}
