package fr.lsi.jarvis.domain.account.model;

import java.beans.Transient;
import java.time.LocalDate;

/**
 * Entity Account
 *
 * @author Laurent SION
 *
 */
public class Account {

	/**
	 * UUID
	 */
	private String uuid;

	/**
	 * login
	 */
	private String login;

	/**
	 * Firstname
	 */
	private String firstName;

	/**
	 * LastName
	 */
	private String lastName;

	/**
	 * Crypto mdp
	 */
	private String passwordCrypt;

	/**
	 * mdp
	 */
	private char[] password;

	/**
	 * Adress street
	 */
	private String street;

	/**
	 * Postal Code
	 */
	private String postalCode;

	/**
	 * City
	 */
	private String city;

	/**
	 * Phone Number
	 */
	private String phoneNumber;

	/**
	 * eMail
	 */
	private String mail;

	/**
	 * Admin
	 */
	private Boolean isAdmin;

	/**
	 * access Localizer
	 */
	private Boolean isLocalizer;

	/**
	 * access voice
	 */
	private Boolean isVoice;

	/**
	 * access SMS
	 */
	private Boolean isSms;

	/**
	 * isActif
	 */
	private Boolean actif;

	/**
	 * Date de Création
	 */
	private LocalDate dateCreate;

	/**
	 * Date de co
	 */
	private LocalDate dateLastCo;

	/**
	 * Constructeur
	 */
	public Account() {
		super();
	}

	/**
	 * @return the uuid
	 */
	public final String getUuid() {
		return this.uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public final void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the firstName
	 */
	public final String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public final void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public final String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public final void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the passwordCrypt
	 */
	@Transient
	public final String getPasswordCrypt() {
		return this.passwordCrypt;
	}

	/**
	 * @param passwordCrypt the passwordCrypt to set
	 */
	public final void setPasswordCrypt(final String passwordCrypt) {
		this.passwordCrypt = passwordCrypt;
	}

	/**
	 * @return the password
	 */
	@Transient
	public final char[] getPassword() {
		return this.password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(final char[] password) {
		this.password = password;
	}

	/**
	 * @return the street
	 */
	public final String getStreet() {
		return this.street;
	}

	/**
	 * @param street the street to set
	 */
	public final void setStreet(final String street) {
		this.street = street;
	}

	/**
	 * @return the postalCode
	 */
	public final String getPostalCode() {
		return this.postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public final void setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the city
	 */
	public final String getCity() {
		return this.city;
	}

	/**
	 * @param city the city to set
	 */
	public final void setCity(final String city) {
		this.city = city;
	}

	/**
	 * @return the phoneNumber
	 */
	public final String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public final void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the mail
	 */
	public final String getMail() {
		return this.mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public final void setMail(final String mail) {
		this.mail = mail;
	}

	/**
	 * @return the isAdmin
	 */
	public final Boolean getIsAdmin() {
		return this.isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public final void setIsAdmin(final Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the isLocalizer
	 */
	public final Boolean getIsLocalizer() {
		return this.isLocalizer;
	}

	/**
	 * @param isLocalizer the isLocalizer to set
	 */
	public final void setIsLocalizer(final Boolean isLocalizer) {
		this.isLocalizer = isLocalizer;
	}

	/**
	 * @return the isVoice
	 */
	public final Boolean getIsVoice() {
		return this.isVoice;
	}

	/**
	 * @param isVoice the isVoice to set
	 */
	public final void setIsVoice(final Boolean isVoice) {
		this.isVoice = isVoice;
	}

	/**
	 * @return the isSms
	 */
	public final Boolean getIsSms() {
		return this.isSms;
	}

	/**
	 * @param isSms the isSms to set
	 */
	public final void setIsSms(final Boolean isSms) {
		this.isSms = isSms;
	}

	/**
	 * @return the login
	 */
	public final String getLogin() {
		return this.login;
	}

	/**
	 * @param login the login to set
	 */
	public final void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * @return the actif
	 */
	public final Boolean getActif() {
		return this.actif;
	}

	/**
	 * @param actif the actif to set
	 */
	public final void setActif(final Boolean actif) {
		this.actif = actif;
	}

	/**
	 * @return the dateCreate
	 */
	public final LocalDate getDateCreate() {
		return this.dateCreate;
	}

	/**
	 * @param dateCreate the dateCreate to set
	 */
	public final void setDateCreate(final LocalDate dateCreate) {
		this.dateCreate = dateCreate;
	}

	/**
	 * @return the dateLastCo
	 */
	public final LocalDate getDateLastCo() {
		return this.dateLastCo;
	}

	/**
	 * @param dateLastCo the dateLastCo to set
	 */
	public final void setDateLastCo(final LocalDate dateLastCo) {
		this.dateLastCo = dateLastCo;
	}

}
