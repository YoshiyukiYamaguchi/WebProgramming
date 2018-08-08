package model;

public class UserBeans {

private int id;
private String loginId;
private String name;
private String birthDate;
private String password;
private String createDate;
private String updateDate;

public UserBeans(String loginId, String name) {
	this.loginId = loginId;
	this.name = name;

}
public UserBeans(int id) {
	this.id = id;
}
public UserBeans (int id, String loginId, String name,String birthDate, String password, String createDate,
		String updateDate) {
	this.id = id;
	this.loginId = loginId;
	this.name = name;
	this.birthDate = birthDate;
	this.password = password;
	this.createDate = createDate;
	this.updateDate = updateDate;

}
public UserBeans (String password,String name,String birthDate) {
	this.password = password;
	this.name = name;
	this.birthDate = birthDate;
}

public UserBeans (String loginId, String name,String birthDate, String password) {
	this.loginId = loginId;
	this.name = name;
	this.birthDate = birthDate;
	this.password = password;


}




public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBirthDate() {
	return birthDate;
}
public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCreateDate() {
	return createDate;
}
public void setCreateDate(String createDate) {
	this.createDate = createDate;
}
public String getUpdateDate() {
	return updateDate;
}
public void setUpdateDate(String updateDate) {
	this.updateDate = updateDate;
}
}

