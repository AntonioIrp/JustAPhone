package com.selfdevel.justaphone;

import java.util.ArrayList;
import java.util.List;

public class ContactBean {
	private String contactName;
	private String contactAddress;
	private String contactPhoto;
	private String contactId;
	private List<String> contactPhoneNumbers;
	private List<String> contactEmailAddress;
	
	
	public ContactBean(){
		this.contactName = null;
		this.contactAddress = null;
		this.contactPhoto = null;
		this.contactPhoneNumbers = new ArrayList<String>();
		this.contactEmailAddress = new ArrayList<String>();	
	}
	
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getContactPhoto() {
		return contactPhoto;
	}
	public void setContactPhoto(String contactPhoto) {
		this.contactPhoto = contactPhoto;
	}
	public List<String> getContactPhoneNumbers() {
		return contactPhoneNumbers;
	}
	public void setContactPhoneNumbers(List<String> contactPhoneNumbers) {
		this.contactPhoneNumbers = contactPhoneNumbers;
	}
	public List<String> getContactEmailAddress() {
		return contactEmailAddress;
	}
	public void setContactEmailAddress(List<String> contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}
	
	public void addContactPhoneNumber(String phoneNumber){
		String sanitizedPhoneNumber = phoneNumber.replaceAll("\\s+","");
		if(!this.contactPhoneNumbers.contains(sanitizedPhoneNumber)){
			this.contactPhoneNumbers.add(sanitizedPhoneNumber);
		}
	}
	
	public void addContactEmailAddress(String emailAddress){
		String sanitizedEmailAddress = emailAddress.replaceAll("\\s+","");
		if(!this.contactEmailAddress.contains(sanitizedEmailAddress)){
			this.contactEmailAddress.add(sanitizedEmailAddress);
		}
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

}
