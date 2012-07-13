package org.openmrs.module.maternalsummary.data;

import java.util.Date;

public class DeliverySummaryEntry {
	private Integer number;
	private Date dateTime;
	private String modeOfDelivery;
	private String typeOfBirth;
	private Double birthWeight;
	private String gender;
	private String pretermOrTerm;
	private String bloodLoss;
	private String maternalOutcome;
	
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getModeOfDelivery() {
		return modeOfDelivery;
	}
	public void setModeOfDelivery(String modeOfDelivery) {
		this.modeOfDelivery = modeOfDelivery;
	}
	public String getTypeOfBirth() {
		return typeOfBirth;
	}
	public void setTypeOfBirth(String typeOfBirth) {
		this.typeOfBirth = typeOfBirth;
	}
	public Double getBirthWeight() {
		return birthWeight;
	}
	public void setBirthWeight(Double birthWeight) {
		this.birthWeight = birthWeight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPretermOrTerm() {
		return pretermOrTerm;
	}
	public void setPretermOrTerm(String pretermOrTerm) {
		this.pretermOrTerm = pretermOrTerm;
	}
	public String getBloodLoss() {
		return bloodLoss;
	}
	public void setBloodLoss(String bloodLoss) {
		this.bloodLoss = bloodLoss;
	}
	public String getMaternalOutcome() {
		return maternalOutcome;
	}
	public void setMaternalOutcome(String maternalOutcome) {
		this.maternalOutcome = maternalOutcome;
	}
}
