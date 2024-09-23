package com.first.springproject.form;

public class UserForm {
	private String userId;
	private String name;
	private String email;
	private String password;
	private String description;
	private String profilePic;
	private String mobileNumber;

	public UserForm(String userId, String name, String email, String password, String description, String profilePic,
			String mobileNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.description = description;
		this.profilePic = profilePic;
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "UserForm [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", description=" + description + ", profilePic=" + profilePic + ", mobileNumber=" + mobileNumber
				+ "]";
	}

	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
