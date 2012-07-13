package org.openmrs.module.maternalsummary;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openmrs.Patient;
import org.openmrs.module.maternalsummary.data.ANCVisitsEntry;
import org.openmrs.module.maternalsummary.data.DeliverySummaryEntry;
import org.openmrs.module.maternalsummary.data.MedicalHistory;
import org.openmrs.module.maternalsummary.data.ObsHistory;
import org.openmrs.module.maternalsummary.data.TestsAndTreatment;
import org.openmrs.module.maternalsummary.pdf.PDFRenderer;
import org.openmrs.module.maternalsummary.pdf.PDFRenderer.PDFRendererException;
import org.openmrs.module.maternalsummary.pdf.impl.ITextRenderer;

public class MaternalSummary {
	
	private static DateFormat mediumFormat = new SimpleDateFormat("dd-MMM-yyyy");
	private static DateFormat longFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");

	private Patient patient;
	private List<DeliverySummaryEntry> deliverySummary;
	private ObsHistory obsHistory;
	private MedicalHistory medicalHistory;
	private TestsAndTreatment testsAndTreatment;
	private List<ANCVisitsEntry> ANCVisits;
	
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<DeliverySummaryEntry> getDeliverySummary() {
		return deliverySummary;
	}
	public void setDeliverySummary(List<DeliverySummaryEntry> deliverySummary) {
		this.deliverySummary = deliverySummary;
	}
	public ObsHistory getObsHistory() {
		return obsHistory;
	}
	public void setObsHistory(ObsHistory obsHistory) {
		this.obsHistory = obsHistory;
	}
	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public TestsAndTreatment getTestsAndTreatment() {
		return testsAndTreatment;
	}
	public void setTestsAndTreatment(TestsAndTreatment testsAndTreatment) {
		this.testsAndTreatment = testsAndTreatment;
	}
	public List<ANCVisitsEntry> getANCVisits() {
		return ANCVisits;
	}
	public void setANCVisits(List<ANCVisitsEntry> aNCVisits) {
		ANCVisits = aNCVisits;
	}
	
	
	public void renderPDF(OutputStream out) throws PDFRendererException {
		PDFRenderer renderer = new ITextRenderer();
		try {
			renderer.create(out);
			renderer.addHeader1(patient.getGivenName() + " " + patient.getFamilyName());
			renderer.addHeader2(formatMedium(new Date()));
			
			renderDeliverySummary(renderer);
			renderObsHistory(renderer);
			renderMedicalHistory(renderer);
			renderTestsAndTreatment(renderer);
			renderANCVisits(renderer);
		
		} finally {
			renderer.close();
		}
	}
	
	private void renderDeliverySummary(PDFRenderer renderer) throws PDFRendererException {
		renderer.addHeader2("Delivery Summary");
		
		renderer.tableStart(6);
		
		renderer.tableAddBold("No.");
		renderer.tableAddBold("Date/Time");
		renderer.tableAddBold("Mode of Delivery");
		renderer.tableAddBold("Type of Birth");
		renderer.tableAddBold("Blood Loss <15 mins of delivery");
		renderer.tableAddBold("Maternal Outcome");
		
		for (DeliverySummaryEntry entry : deliverySummary) {
			renderer.tableAdd(toString(entry.getNumber()));
			renderer.tableAdd(formatLong(entry.getDateTime()));
			renderer.tableAdd(entry.getModeOfDelivery());
			renderer.tableAdd(entry.getTypeOfBirth());
			renderer.tableAdd(entry.getBloodLoss());
			renderer.tableAdd(entry.getMaternalOutcome());
		}
			
		renderer.tableEnd();
	}
	
	private void renderObsHistory(PDFRenderer renderer) throws PDFRendererException {
		renderer.addHeader2("Obs History");
		
		renderer.addHeader3("Number of");
		renderer.tableStart(2);
		renderer.tableAddBold("Pregnancies");
		renderer.tableAdd(toString(obsHistory.getNumPregnancies()));
		renderer.tableAddBold("Births");
		renderer.tableAdd(toString(obsHistory.getNumBirths()));
		renderer.tableAddBold("Live Births");
		renderer.tableAdd(toString(obsHistory.getNumLiveBirths()));
		renderer.tableAddBold("Still Births");
		renderer.tableAdd(toString(obsHistory.getNumStillBirths()));
		renderer.tableAddBold("C-Sections");
		renderer.tableAdd(toString(obsHistory.getNumCSections()));
		renderer.tableEnd();
		
		renderer.addHeader3("Last Born");
		renderer.tableStart(2);
		renderer.tableAdd("");
		if (obsHistory.getLastBornAlive()!=null)
			if (obsHistory.getLastBornAlive())
				renderer.tableAdd("Alive");
			else
				renderer.tableAdd("Dead");
		else
			renderer.tableAdd("");
		renderer.tableAddBold("Birth Date");
		renderer.tableAdd(formatMedium(obsHistory.getLastBornBirthDate()));
		renderer.tableEnd();
		
		renderer.tableStart(2);
		renderer.tableAddBold("Date of LMP");
		renderer.tableAdd(formatMedium(obsHistory.getDateOfLMP()));
		renderer.tableAddBold("Expected Delivery Date");
		renderer.tableAdd(formatMedium(obsHistory.getExpectedDeliveryDate()));
		renderer.tableAddBold("Gestational Age");
		renderer.tableAdd(toString(obsHistory.getGestationalAge()) + " weeks");
		renderer.tableAddBold("Child's presentation inside");
		renderer.tableAdd(obsHistory.getPresentation());
		renderer.tableAddBold("Highest WHO Stage");
		renderer.tableAdd(toString(obsHistory.getHighestWHOStage()));
		renderer.tableEnd();
		
		renderer.addHeader3("Risks");
		renderer.tableStart(2);
		renderer.tableAddBold("Risk");
		renderer.tableAddBold("Date Reported");
		for (ObsHistory.Risk risk : obsHistory.getRisks()) {
			renderer.tableAdd(risk.getRisk());
			renderer.tableAdd(formatMedium(risk.getDateReported()));
		}
		renderer.tableEnd();
	}
	
	private void renderMedicalHistory(PDFRenderer renderer) throws PDFRendererException {
		renderer.addHeader2("Medical History");
		
		renderer.addHeader3("Current Medication");
		renderer.tableStart(2);
		for (MedicalHistory.Medication med : medicalHistory.getMedication()) {
			renderer.tableAdd(formatMedium(med.getDate()));
			renderer.tableAdd(med.getMedication());
		}
		renderer.tableEnd();
		
		renderer.addHeader3("Medical History");
		renderer.tableStart(2);
		for (MedicalHistory.HistoryItem h : medicalHistory.getHistory()) {
			renderer.tableAdd(formatMedium(h.getDate()));
			renderer.tableAdd(h.getHistory());
		}
		renderer.tableEnd();
	}
	
	private void renderTestsAndTreatment(PDFRenderer renderer) throws PDFRendererException {
		renderer.addHeader2("Tests and Treatment");
		
		renderer.addHeader3("Testing");
		renderer.tableStart(2);
		renderer.tableAddBold("HIV");
		renderer.tableAdd(testsAndTreatment.getTests().getHIVResult());
		renderer.tableAddBold("HIV Test Date");
		renderer.tableAdd(formatMedium(testsAndTreatment.getTests().getHIVTestDate()));
		renderer.tableAddBold("HIV Result Date");
		renderer.tableAdd(formatMedium(testsAndTreatment.getTests().getHIVResultDate()));
		renderer.tableAddBold("RPR");
		renderer.tableAdd(testsAndTreatment.getTests().getRPRResult());
		renderer.tableAddBold("RPR Test Date");
		renderer.tableAdd(formatMedium(testsAndTreatment.getTests().getRPRTestDate()));
		renderer.tableAddBold("RPR Result Date");
		renderer.tableAdd(formatMedium(testsAndTreatment.getTests().getRPRResultDate()));
		renderer.tableAddBold("Syphilis Treatment");
		renderer.tableAdd(testsAndTreatment.getTests().getTreatedForSyphilis());
		renderer.tableEnd();
		
		renderer.addHeader3("Partner Testing");
		renderer.tableStart(2);
		renderer.tableAddBold("HIV");
		renderer.tableAdd(testsAndTreatment.getPartnerTests().getHIVResult());
		renderer.tableAddBold("HIV Test Date");
		renderer.tableAdd(formatMedium(testsAndTreatment.getPartnerTests().getHIVTestDate()));
		renderer.tableAddBold("RPR");
		renderer.tableAdd(testsAndTreatment.getPartnerTests().getRPRResult());
		renderer.tableAddBold("RPR Test Date");
		renderer.tableAdd(formatMedium(testsAndTreatment.getPartnerTests().getRPRTestDate()));
		renderer.tableAddBold("Syphilis Treatment");
		renderer.tableAdd(testsAndTreatment.getPartnerTests().getTreatedForSyphilis());
		renderer.tableEnd();
		
		renderer.addHeader3("Sero Positive Women");
		renderer.tableStart(7);
		renderer.tableAddBold("Creatinine Level");
		renderer.tableAddBold("CD4 Count");
		renderer.tableAddBold("CD4 Date");
		renderer.tableAddBold("WHO Stage");
		renderer.tableAddBold("ARV Regimen");
		renderer.tableAddBold("ARV Date");
		renderer.tableAddBold("Cotrimoxazole Date");
		for (TestsAndTreatment.SeroPositiveWomen spw : testsAndTreatment.getSeroPositiveWomen()) {
			renderer.tableAdd(toString(spw.getCreatinineLevel()));
			renderer.tableAdd(toString(spw.getCD4Count()));
			renderer.tableAdd(formatMedium(spw.getCD4CountDate()));
			renderer.tableAdd(spw.getWHOStage());
			renderer.tableAdd(spw.getARVProphylaxis());
			renderer.tableAdd(formatMedium(spw.getARVProphylaxisDate()));
			renderer.tableAdd(formatMedium(spw.getCotrimoxazoleStartDate()));
		}
		renderer.tableEnd();
		
		renderer.addHeader3("Treatment Interventions");
		renderer.tableStart(2);
		for (TestsAndTreatment.TreatmentIntervention ti : testsAndTreatment.getInterventions()) {
			renderer.tableAdd(formatMedium(ti.getDate()));
			renderer.tableAdd(ti.getIntervention());
		}
		renderer.tableEnd();
	}
	
	private void renderANCVisits(PDFRenderer renderer) throws PDFRendererException {
		renderer.addHeader2("ANC Visits");
		
		renderer.tableStart(5);
		renderer.tableAddBold("Date");
		renderer.tableAddBold("Weight");
		renderer.tableAddBold("Blood Pressure");
		renderer.tableAddBold("Temperature");
		renderer.tableAddBold("Uterus Length");
		for (ANCVisitsEntry visit : ANCVisits) {
			renderer.tableAdd(formatMedium(visit.getDate()));
			renderer.tableAdd(toString(visit.getWeight()));
			renderer.tableAdd( toString(visit.getBloodPressureSystolic()) + " / " + toString(visit.getBloodPressureDiastolic()) );
			renderer.tableAdd(toString(visit.getTemperature()));
			renderer.tableAdd(toString(visit.getUterusLength()));
		}
		renderer.tableEnd();
	}
	
	
	private static String toString(Object o) {
		return o!=null ? o.toString() : "";
	}
	
	private static String formatMedium(Date date) {
		return formatDate(mediumFormat, date);
	}
	
	private static String formatLong(Date date) {
		return formatDate(longFormat, date);
	}
	
	private static String formatDate(DateFormat format, Date date) {
		return date!=null ? format.format(date) : "";
	}
}
