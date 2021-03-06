package com.hqyj.erp.modules.account.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.util.MD5Util;

/**
 * 用户表
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String account;
	private String password;
	private String userName;
	private String userSex;
	private String userTelephone;
	private String userEmail;
	private String userAddress;
	// 学历
	private String userDiploma;
	// 入职时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userBirthday;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userEntrytime;
	private Integer positionId;
	private Integer departId;
	
	@Transient
	private String userPosition;
	@Transient
	private String userDepartement;
	@Transient
	private boolean rememberMe;
	
	@Transient
	private List<Role> roles;
	@Transient
	private Integer[] userRoles;
	
	public void initUserInfo() {
		this.setUserAddress("--");
		this.setUserBirthday(new Date());
		this.setUserDiploma("--");
		this.setUserEmail("--");
		this.setUserEntrytime(new Date());
		this.setUserName("--");
		this.setUserSex("男");
		this.setUserTelephone("--");
		this.setUserDepartement("--");
		this.setUserPosition("--");
	}
	
	public void initUserPassword() {
		this.setPassword(MD5Util.getMD5(this.getPassword()));
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserDiploma() {
		return userDiploma;
	}

	public void setUserDiploma(String userDiploma) {
		this.userDiploma = userDiploma;
	}

	public Date getUserEntrytime() {
		return userEntrytime;
	}

	public void setUserEntrytime(Date userEntrytime) {
		this.userEntrytime = userEntrytime;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserDepartement() {
		return userDepartement;
	}

	public void setUserDepartement(String userDepartement) {
		this.userDepartement = userDepartement;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer[] getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Integer[] userRoles) {
		this.userRoles = userRoles;
	}

	public boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Integer getDepartId() {
		return departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
}
