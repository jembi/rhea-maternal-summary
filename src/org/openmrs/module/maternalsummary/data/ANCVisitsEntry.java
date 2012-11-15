/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.maternalsummary.data;

import java.util.Date;

public class ANCVisitsEntry {
	private Date date;
	private Integer weeksPregnant;
	private Double weight;
	private Double weightChange;
	private Integer bloodPressureSystolic;
	private Integer bloodPressureDiastolic;
	private Double temperature;
	private Double uterusLength;
	private Integer fetalHeartRate;
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
	public Integer getBloodPressureSystolic() {
		return bloodPressureSystolic;
	}
	public void setBloodPressureSystolic(Integer bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}
	public Integer getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}
	public void setBloodPressureDiastolic(Integer bloodPressureDiastolic) {
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
	public Integer getFetalHeartRate() {
		return fetalHeartRate;
	}
	public void setFetalHeartRate(Integer fetalHeartRate) {
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
