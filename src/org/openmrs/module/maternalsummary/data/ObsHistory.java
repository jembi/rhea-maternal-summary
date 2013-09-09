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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObsHistory {
	private Integer numPregnancies;
	private Integer numBirths;
	private Integer numLiveBirths;
	private Integer numStillBirths;
	private Integer numCSections;
	private Boolean lastBornAlive;
	private Date lastBornBirthDate;
	private Date dateOfLMP;
	private Date expectedDeliveryDate;
	private Integer gestationalAge;
	private String presentation;
	private String location;
	private Boolean isSeroPositive;
	private Integer highestWHOStage;
	private Boolean pregnancyConfirmed;
	private Boolean pregnancySuspected;
	private List<Risk> risks = new ArrayList<Risk>();
	private List<Risk> obsRisks = new ArrayList<Risk>();
	
	public Integer getNumPregnancies() {
		return numPregnancies;
	}
	public void setNumPregnancies(Integer numPregnancies) {
		this.numPregnancies = numPregnancies;
	}
	public Integer getNumBirths() {
		return numBirths;
	}
	public void setNumBirths(Integer numBirths) {
		this.numBirths = numBirths;
	}
	public Integer getNumLiveBirths() {
		return numLiveBirths;
	}
	public void setNumLiveBirths(Integer numLiveBirths) {
		this.numLiveBirths = numLiveBirths;
	}
	public Integer getNumStillBirths() {
		return numStillBirths;
	}
	public void setNumStillBirths(Integer numStillBirths) {
		this.numStillBirths = numStillBirths;
	}
	public Integer getNumCSections() {
		return numCSections;
	}
	public void setNumCSections(Integer numCSections) {
		this.numCSections = numCSections;
	}
	public Boolean getLastBornAlive() {
		return lastBornAlive;
	}
	public void setLastBornAlive(Boolean lastBornAlive) {
		this.lastBornAlive = lastBornAlive;
	}
	public Date getLastBornBirthDate() {
		return lastBornBirthDate;
	}
	public void setLastBornBirthDate(Date lastBornBirthDate) {
		this.lastBornBirthDate = lastBornBirthDate;
	}
	public Date getDateOfLMP() {
		return dateOfLMP;
	}
	public void setDateOfLMP(Date dateOfLMP) {
		this.dateOfLMP = dateOfLMP;
	}
	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}
	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public Integer getGestationalAge() {
		return gestationalAge;
	}
	public void setGestationalAge(Integer gestationalAge) {
		this.gestationalAge = gestationalAge;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Boolean getIsSeroPositive() {
		return isSeroPositive;
	}
	public void setIsSeroPositive(Boolean isSeroPositive) {
		this.isSeroPositive = isSeroPositive;
	}
	@Deprecated
	public Integer getHighestWHOStage() {
		return highestWHOStage;
	}
	@Deprecated
	public void setHighestWHOStage(Integer highestWHOStage) {
		this.highestWHOStage = highestWHOStage;
	}
	public Boolean getPregnancyConfirmed() {
		return pregnancyConfirmed;
	}
	public void setPregnancyConfirmed(Boolean pregnancyConfirmed) {
		this.pregnancyConfirmed = pregnancyConfirmed;
	}
	public Boolean getPregnancySuspected() {
		return pregnancySuspected;
	}
	public void setPregnancySuspected(Boolean pregnancySuspected) {
		this.pregnancySuspected = pregnancySuspected;
	}
	public List<Risk> getRisks() {
		return risks;
	}
	public void setRisks(List<Risk> risks) {
		this.risks = risks;
	}
	
	public void addRisk(Risk risk) {
		risks.add(risk);
	}
	
	public List<Risk> getObsRisks() {
		return obsRisks;
	}
	public void setObsRisks(List<Risk> obsRisks) {
		this.obsRisks = obsRisks;
	}

	public void addObsRisk(Risk risk) {
		obsRisks.add(risk);
	}
	
	public static class Risk {
		private String risk;
		private Date dateReported;
		
		public Risk() {}
		
		public Risk(String risk, Date dateReported) {
			super();
			this.risk = risk;
			this.dateReported = dateReported;
		}

		public String getRisk() {
			return risk;
		}

		public void setRisk(String risk) {
			this.risk = risk;
		}

		public Date getDateReported() {
			return dateReported;
		}

		public void setDateReported(Date dateReported) {
			this.dateReported = dateReported;
		}
	}
}
