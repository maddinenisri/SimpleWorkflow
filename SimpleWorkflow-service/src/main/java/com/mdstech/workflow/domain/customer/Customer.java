package com.mdstech.workflow.domain.customer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.mdstech.workflow.domain.AbstractEntity;
import com.mdstech.workflow.type.GenderType;
import com.mdstech.workflow.type.MaritalStatusType;
import com.mdstech.workflow.type.SalutationType;

@Entity
@Table(name = "INS_CUSTOMER")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ID_CUSTOMER")) })
public class Customer extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = -7070758411539761536L;

	@Column(name = "FIRST_NAME")
	@Length(min = 1, max = 30)
	@NotNull
	private String firstName;

	@Column(name = "LAST_NAME")
	@Length(min = 1, max = 30)
	@NotNull
	private String lastName;

	@Column(name = "MIDDLE_NAME")
	@Length(max = 20)
	private String middleName;

	@Column(name = "OCCUPATION")
	@Length(max = 20)
	private String occupation;

	@Column(name = "ORG_NAME")
	@Length(max = 45)
	private String orgName;

	@Column(name = "EMAIL")
	@Length(min = 1, max = 50)
	@NotNull
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER")
	@NotNull
	private GenderType genderType;

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private Date birthDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "MARITAL_STATUS")
	@NotNull
	private MaritalStatusType maritalStatusType;

	@Enumerated(EnumType.STRING)
	@Column(name = "SALUTATION")
	@NotNull
	private SalutationType salutationType;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(final String occupation) {
		this.occupation = occupation;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(final String orgName) {
		this.orgName = orgName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public GenderType getGenderType() {
		return genderType;
	}

	public void setGenderType(final GenderType genderType) {
		this.genderType = genderType;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	public MaritalStatusType getMaritalStatusType() {
		return maritalStatusType;
	}

	public void setMaritalStatusType(final MaritalStatusType maritalStatusType) {
		this.maritalStatusType = maritalStatusType;
	}

	public SalutationType getSalutationType() {
		return salutationType;
	}

	public void setSalutationType(final SalutationType salutationType) {
		this.salutationType = salutationType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
