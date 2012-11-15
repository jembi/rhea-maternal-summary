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
