package com.mdstech.workflow.dto.customer;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.mdstech.workflow.dto.AbstractDto;
import com.mdstech.workflow.type.GenderType;
import com.mdstech.workflow.type.MaritalStatusType;
import com.mdstech.workflow.type.SalutationType;

public class CustomerDto extends AbstractDto<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6592058405324838217L;
	@NotEmpty
	@Length(min = 1, max = 30)
	private String firstName;

	@NotEmpty
	@Length(min = 1, max = 30)
	private String lastName;

	@Length(max = 10)
	private String middleName;

	@Length(max = 20)
	private String occupation;

	@Length(max = 45)
	private String orgName;

	@NotEmpty
	@Email
	@Length(min = 1, max = 50)
	private String email;

	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private Date birthDate;

	@NotNull
	private GenderType genderType;

	@NotNull
	private SalutationType salutationType;

	@NotNull
	private MaritalStatusType maritalStatusType;

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	public GenderType getGenderType() {
		return genderType;
	}

	public void setGenderType(final GenderType genderType) {
		this.genderType = genderType;
	}

	public SalutationType getSalutationType() {
		return salutationType;
	}

	public void setSalutationType(final SalutationType salutationType) {
		this.salutationType = salutationType;
	}

	public MaritalStatusType getMaritalStatusType() {
		return maritalStatusType;
	}

	public void setMaritalStatusType(final MaritalStatusType maritalStatusType) {
		this.maritalStatusType = maritalStatusType;
	}

}
