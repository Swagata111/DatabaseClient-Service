package com.cloud.dbservice.model;

import javax.annotation.Generated;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="details")
public class Details {

	@Id
	public ObjectId _id;
	
	
	String username,age,gender;

	public Details() {
		super();
	}

	public Details(ObjectId _id, String username, String age, String gender) {
		super();
		this._id=_id;
		this.username = username;
		this.age = age;
		this.gender = gender;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	/**
	 * @return the id
	 */
	

	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
