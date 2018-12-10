package org.plate.json;

public class ProfileJson {
	private String contact;
	private String email;
	private String phone;
	private String password;
	
	public ProfileJson()
	{
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ProfileJson [contact=" + contact + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	
}
