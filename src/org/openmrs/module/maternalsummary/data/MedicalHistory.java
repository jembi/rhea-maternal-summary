package org.openmrs.module.maternalsummary.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalHistory {
	private List<Medication> medication = new ArrayList<MedicalHistory.Medication>();
	private List<HistoryItem> history = new ArrayList<HistoryItem>();

	public List<Medication> getMedication() {
		return medication;
	}

	public void setMedication(List<Medication> medication) {
		this.medication = medication;
	}
	
	public void addMedication(Medication medication) {
		this.medication.add(medication);
	}

	public List<HistoryItem> getHistory() {
		return history;
	}

	public void setHistory(List<HistoryItem> history) {
		this.history = history;
	}
	
	public void addHistory(HistoryItem history) {
		this.history.add(history);
	}

	public static class Medication {
		private String medication;
		private Date date;
		
		public Medication() {}
		
		public Medication(String medication, Date date) {
			this.medication = medication;
			this.date = date;
		}

		public String getMedication() {
			return medication;
		}

		public void setMedication(String medication) {
			this.medication = medication;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
	}

	public static class HistoryItem {
		private String history;
		private Date date;
		
		public HistoryItem() {}
		
		public HistoryItem(String history, Date date) {
			this.history = history;
			this.date = date;
		}

		public String getHistory() {
			return history;
		}

		public void setHistory(String history) {
			this.history = history;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
	}
}
