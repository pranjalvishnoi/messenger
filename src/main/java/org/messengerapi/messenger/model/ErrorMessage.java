package org.messengerapi.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
private int errorCode;
private String errorMessage;
private String doc;

public ErrorMessage() {
	
}

public ErrorMessage(int errorCode, String errorMessage, String doc) {
	super();
	this.errorCode = errorCode;
	this.errorMessage = errorMessage;
	this.doc = doc;
}
public int getErrorCode() {
	return errorCode;
}
public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public String getDoc() {
	return doc;
}
public void setDoc(String doc) {
	this.doc = doc;
}
}
