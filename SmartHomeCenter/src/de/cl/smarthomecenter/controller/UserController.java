/**
 class: UserController
 Task: Controller to manage user inputs
 Last modified: 05.06.2016
 copyright by cl @ 2016 
 **/
package de.cl.smarthomecenter.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import de.cl.smarthomecenter.model.UserBean;

@ManagedBean(name="userController")
@SessionScoped
public class UserController implements Serializable{

	private static final long serialVersionUID = 1L;
	private String enteredUsername = "";
	private String enteredPassword = "";
	private String userPermissions = "";
	
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
		
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public String getEnteredUsername() {
		return enteredUsername;
	}
	public void setEnteredUsername(String enteredUsername) {
		this.enteredUsername = enteredUsername;
	}
	public String getEnteredPassword() {
		return enteredPassword;
	}
	public void setEnteredPassword(String enteredPassword) {
		this.enteredPassword = enteredPassword;
	}
	public String getUserPermissions() {
		return userPermissions;
	}
	public void setUserPermissions(String userPermissions) {
		this.userPermissions = userPermissions;
	}
	
	public String checkCredentials(){
		
		if(this.enteredPassword.equals("admin") && this.enteredUsername.equals("admin"))
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("shc.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else{
			FacesContext.getCurrentInstance().addMessage("usernameInput", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Input error!", "Please enter Username and Password."));
		}
		return "success";
	}
}
