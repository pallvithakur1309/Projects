package com.ust.mailsimulator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mailinfo {
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
  private int Id;
	private int To_id;
private String Subject;
  private String Message;
  private String Status;
  private String sentto;
  private String sentby;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public int getTo_id() {
	return To_id;
}
public void setTo_id(int to_id) {
	To_id = to_id;
}
public String getSubject() {
	return Subject;
}
public void setSubject(String subject) {
	Subject = subject;
}
public String getMessage() {
	return Message;
}
public void setMessage(String message) {
	Message = message;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public String getSentto() {
	return sentto;
}
public void setSentto(String sentto) {
	this.sentto = sentto;
}
public String getSentby() {
	return sentby;
}
public void setSentby(String sentby) {
	this.sentby = sentby;
}
  
  

}
