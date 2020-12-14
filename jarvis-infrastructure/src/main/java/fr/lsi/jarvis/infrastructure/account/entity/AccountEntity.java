package fr.lsi.jarvis.infrastructure.account.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.lsi.jarvis.infrastructure.generic.EntityIO;

/**
 * Entity Account
 *
 * @author Laurent SION
 *
 */
@Entity
@Table(name = "account_entity")
public class AccountEntity extends EntityIO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1933483170024259648L;

	/**
	 * UUID
	 */
	@Id
	@Column(name = "uuid")
	private String uuid;

	/**
	 * Login
	 */
	@Column(name = "login", unique = true)
	private String login;

	/**
	 * Firstname
	 */
	@Column(name = "firstname")
	private String firstName;

	/**
	 * LastName
	 */
	@Column(name = "lastname")
	private String lastName;

	/**
	 * Crypto mdp
	 */
	@Column(name = "password")
	private String passwordCrypt;

	/**
	 * Adress street
	 */
	@Column(name = "street")
	private String street;

	/**
	 * Postal Code
	 */
	@Column(name = "postal_code")
	private String postalCode;

	/**
	 * City
	 */
	@Column(name = "city")
	private String city;

	/**
	 * Phone Number
	 */
	@Column(name = "phone_number", unique = true)
	private String phoneNumber;

	/**
	 * eMail
	 */
	@Column(name = "mail", unique = true)
	private String mail;

	/**
	 * Admin
	 */
	@Column(name = "is_admin")
	private Boolean isAdmin;

	/**
	 * access Localizer
	 */
	@Column(name = "localizer_access")
	private Boolean isLocalizer;

	/**
	 * access voice
	 */
	@Column(name = "voice_access")
	private Boolean isVoice;

	/**
	 * access SMS
	 */
	@Column(name = "sms_access")
	private Boolean isSms;

	/**
	 * isActif
	 */
	@Column(name = "actif")
	private Boolean actif;

	/**
	 * Date de Création
	 */
	@Column(name = "date_create")
	private LocalDate dateCreate;

	/**
	 * Date de co
	 */
	@Column(name = "date_last_connection")
	private LocalDate dateLastCo;

	/**
	 * Constructeur
	 */
	public AccountEntity() {
		super();
	}

	/**
	 * @return the uuid
	 */
	@Override
	public String getUuid() {
		return this.uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	@Override
	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the passwordCrypt
	 */
	public String getPasswordCrypt() {
		return this.passwordCrypt;
	}

	/**
	 * @param passwordCrypt the passwordCrypt to set
	 */
	public void setPasswordCrypt(final String passwordCrypt) {
		this.passwordCrypt = passwordCrypt;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return this.street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(final String street) {
		this.street = street;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return this.mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(final String mail) {
		this.mail = mail;
	}

	/**
	 * @return the isAdmin
	 */
	public Boolean getIsAdmin() {
		return this.isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setIsAdmin(final Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the isLocalizer
	 */
	public Boolean getIsLocalizer() {
		return this.isLocalizer;
	}

	/**
	 * @param isLocalizer the isLocalizer to set
	 */
	public void setIsLocalizer(final Boolean isLocalizer) {
		this.isLocalizer = isLocalizer;
	}

	/**
	 * @return the isVoice
	 */
	public Boolean getIsVoice() {
		return this.isVoice;
	}

	/**
	 * @param isVoice the isVoice to set
	 */
	public void setIsVoice(final Boolean isVoice) {
		this.isVoice = isVoice;
	}

	/**
	 * @return the isSms
	 */
	public Boolean getIsSms() {
		return this.isSms;
	}

	/**
	 * @param isSms the isSms to set
	 */
	public void setIsSms(final Boolean isSms) {
		this.isSms = isSms;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * @return the actif
	 */
	public Boolean getActif() {
		return this.actif;
	}

	/**
	 * @param actif the actif to set
	 */
	public void setActif(final Boolean actif) {
		this.actif = actif;
	}

	/**
	 * @return the dateCreate
	 */
	public LocalDate getDateCreate() {
		return this.dateCreate;
	}

	/**
	 * @param dateCreate the dateCreate to set
	 */
	public void setDateCreate(final LocalDate dateCreate) {
		this.dateCreate = dateCreate;
	}

	/**
	 * @return the dateLastCo
	 */
	public LocalDate getDateLastCo() {
		return this.dateLastCo;
	}

	/**
	 * @param dateLastCo the dateLastCo to set
	 */
	public void setDateLastCo(final LocalDate dateLastCo) {
		this.dateLastCo = dateLastCo;
	}

}
