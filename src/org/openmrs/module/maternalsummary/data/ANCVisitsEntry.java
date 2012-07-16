package org.openmrs.module.maternalsummary.data;

import java.util.Date;

public class ANCVisitsEntry {
	private Date date;
	private Integer weeksPregnant;
	private Double weight;
	private Double weightChange;
	private Double bloodPressureSystolic;
	private Double bloodPressureDiastolic;
	private Double temperature;
	private Double uterusLength;
	private Double fetalHeartRate;
	private String presentation;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getWeightChange() {
		return weightChange;
	}
	public void setWeightChange(Double weightChange) {
		this.weightChange = weightChange;
	}
	public Double getBloodPressureSystolic() {
		return bloodPressureSystolic;
	}
	public void setBloodPressureSystolic(Double bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}
	public Double getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}
	public void setBloodPressureDiastolic(Double bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getUterusLength() {
		return uterusLength;
	}
	public void setUterusLength(Double uterusLength) {
		this.uterusLength = uterusLength;
	}
	public Double getFetalHeartRate() {
		return fetalHeartRate;
	}
	public void setFetalHeartRate(Double fetalHeartRate) {
		this.fetalHeartRate = fetalHeartRate;
	}
	public Integer getWeeksPregnant() {
		return weeksPregnant;
	}
	public void setWeeksPregnant(Integer weeksPregnant) {
		this.weeksPregnant = weeksPregnant;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
}
