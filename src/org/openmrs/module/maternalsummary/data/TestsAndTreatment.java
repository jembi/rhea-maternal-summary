package org.openmrs.module.maternalsummary.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestsAndTreatment {
	private Tests tests = new Tests();
	private Tests partnerTests = new Tests();
	private List<SeroPositiveWomen> seroPositiveWomen = new ArrayList<TestsAndTreatment.SeroPositiveWomen>();
	private List<TreatmentIntervention> interventions = new ArrayList<TestsAndTreatment.TreatmentIntervention>();
	

	public Tests getTests() {
		return tests;
	}

	public void setTests(Tests tests) {
		this.tests = tests;
	}

	public Tests getPartnerTests() {
		return partnerTests;
	}

	public void setPartnerTests(Tests partnerTests) {
		this.partnerTests = partnerTests;
	}

	@Deprecated
	public List<SeroPositiveWomen> getSeroPositiveWomen() {
		return seroPositiveWomen;
	}

	@Deprecated
	public void setSeroPositiveWomen(List<SeroPositiveWomen> seroPositiveWomen) {
		this.seroPositiveWomen = seroPositiveWomen;
	}
	
	@Deprecated
	public void addSeroPositiveWomenEncounter(SeroPositiveWomen seroPositiveWomen) {
		this.seroPositiveWomen.add(seroPositiveWomen);
	}

	public List<TreatmentIntervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<TreatmentIntervention> interventions) {
		this.interventions = interventions;
	}
	
	public void addIntervention(TreatmentIntervention intervention) {
		interventions.add(intervention);
	}
	
	
	public static class Tests {
		private String RPRResult;
		private Date RPRTestDate;
		private Date RPRResultDate;
		private String HIVResult;
		private Date HIVTestDate;
		private Date HIVResultDate;
		private String treatedForSyphilis;
	
		public String getRPRResult() {
			return RPRResult;
		}
	
		public void setRPRResult(String rPRResult) {
			RPRResult = rPRResult;
		}
	
		public Date getRPRTestDate() {
			return RPRTestDate;
		}
	
		public void setRPRTestDate(Date rPRTestDate) {
			RPRTestDate = rPRTestDate;
		}
	
		public Date getRPRResultDate() {
			return RPRResultDate;
		}
	
		public void setRPRResultDate(Date rPRResultDate) {
			RPRResultDate = rPRResultDate;
		}
	
		public String getHIVResult() {
			return HIVResult;
		}
	
		public void setHIVResult(String hIVResult) {
			HIVResult = hIVResult;
		}
	
		public Date getHIVTestDate() {
			return HIVTestDate;
		}
	
		public void setHIVTestDate(Date hIVTestDate) {
			HIVTestDate = hIVTestDate;
		}
	
		public Date getHIVResultDate() {
			return HIVResultDate;
		}
	
		public void setHIVResultDate(Date hIVResultDate) {
			HIVResultDate = hIVResultDate;
		}
	
		public String getTreatedForSyphilis() {
			return treatedForSyphilis;
		}
	
		public void setTreatedForSyphilis(String treatedForSyphilis) {
			this.treatedForSyphilis = treatedForSyphilis;
		}
	}

	@Deprecated
	public static class SeroPositiveWomen {
		private Double creatinineLevel;
		private Double CD4Count;
		private Date CD4CountDate;
		private String WHOStage;
		private String ARVProphylaxis;
		private Date ARVProphylaxisDate;
		private Date cotrimoxazoleStartDate;
		
		public Double getCreatinineLevel() {
			return creatinineLevel;
		}

		public void setCreatinineLevel(Double creatinineLevel) {
			this.creatinineLevel = creatinineLevel;
		}

		public Double getCD4Count() {
			return CD4Count;
		}

		public void setCD4Count(Double cD4Count) {
			CD4Count = cD4Count;
		}

		public Date getCD4CountDate() {
			return CD4CountDate;
		}

		public void setCD4CountDate(Date cD4CountDate) {
			CD4CountDate = cD4CountDate;
		}

		public String getWHOStage() {
			return WHOStage;
		}

		public void setWHOStage(String wHOStage) {
			WHOStage = wHOStage;
		}

		public String getARVProphylaxis() {
			return ARVProphylaxis;
		}

		public void setARVProphylaxis(String aRVProphylaxis) {
			ARVProphylaxis = aRVProphylaxis;
		}

		public Date getARVProphylaxisDate() {
			return ARVProphylaxisDate;
		}

		public void setARVProphylaxisDate(Date aRVProphylaxisDate) {
			ARVProphylaxisDate = aRVProphylaxisDate;
		}

		public Date getCotrimoxazoleStartDate() {
			return cotrimoxazoleStartDate;
		}

		public void setCotrimoxazoleStartDate(Date cotrimoxazoleStartDate) {
			this.cotrimoxazoleStartDate = cotrimoxazoleStartDate;
		}
	}
	
	public static class TreatmentIntervention {
		private String intervention;
		private Date date;
		
		public TreatmentIntervention() {}

		public TreatmentIntervention(String intervention, Date date) {
			this.intervention = intervention;
			this.date = date;
		}

		public String getIntervention() {
			return intervention;
		}

		public void setIntervention(String intervention) {
			this.intervention = intervention;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
	}
}
