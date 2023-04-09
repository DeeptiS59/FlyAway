package adminUserlogin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "adminUser")
public class AdminUser {
private String username;
private String pwd;
 public AdminUser() {}
 public AdminUser(String username,String pwd) {
	 this.username=username;
	 this.pwd=pwd;
 }
 @Id
 @Column(name="USERNAME")
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Column(name="PASSWORD")
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
}
