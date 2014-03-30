/**
 * 
 */
package edu.web.bean;

import java.io.Serializable;

/**
 * @author rohansabnis
 * 
 */
public class PatientInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String patient_id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private int gender;
	private String date_of_birth;
	private String race;
	private long phone;
	private String email_address;
	private String registration_date;
	private String street_address1;
	private String street_address2;
	private String city;
	private String state;
	private int zip_code;
	private String country;

	/**
	 * @return the patient_id
	 */
	public String getPatient_id() {
		return patient_id;
	}

	/**
	 * @param patient_id
	 *            the patient_id to set
	 */
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name
	 *            the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the middle_name
	 */
	public String getMiddle_name() {
		return middle_name;
	}

	/**
	 * @param middle_name
	 *            the middle_name to set
	 */
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name
	 *            the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * @return the date_of_birth
	 */
	public String getDate_of_birth() {
		return date_of_birth;
	}

	/**
	 * @param date_of_birth
	 *            the date_of_birth to set
	 */
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race
	 *            the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}

	/**
	 * @return the phone
	 */
	public long getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}

	/**
	 * @return the email_address
	 */
	public String getEmail_address() {
		return email_address;
	}

	/**
	 * @param email_address
	 *            the email_address to set
	 */
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	/**
	 * @return the registration_date
	 */
	public String getRegistration_date() {
		return registration_date;
	}

	/**
	 * @param registration_date
	 *            the registration_date to set
	 */
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	/**
	 * @return the street_address1
	 */
	public String getStreet_address1() {
		return street_address1;
	}

	/**
	 * @param street_address1
	 *            the street_address1 to set
	 */
	public void setStreet_address1(String street_address1) {
		this.street_address1 = street_address1;
	}

	/**
	 * @return the street_address2
	 */
	public String getStreet_address2() {
		return street_address2;
	}

	/**
	 * @param street_address2
	 *            the street_address2 to set
	 */
	public void setStreet_address2(String street_address2) {
		this.street_address2 = street_address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip_code
	 */
	public int getZip_code() {
		return zip_code;
	}

	/**
	 * @param zip_code
	 *            the zip_code to set
	 */
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
