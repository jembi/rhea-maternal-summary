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
import java.util.List;

public class Referrals {
	private List<Referral> referrals;
	private List<Confirmation> confirmations;
	private boolean referredButNotConfirmed;
	
	public List<Referral> getReferrals() {
		return referrals;
	}
	public void setReferrals(List<Referral> referrals) {
		this.referrals = referrals;
	}
	public List<Confirmation> getConfirmations() {
		return confirmations;
	}
	public void setConfirmations(List<Confirmation> confirmations) {
		this.confirmations = confirmations;
	}
	public boolean getReferredButNotConfirmed() {
		return referredButNotConfirmed;
	}
	public void setReferredButNotConfirmed(boolean referredButNotConfirmed) {
		this.referredButNotConfirmed = referredButNotConfirmed;
	}

	public static class Referral {
		private Date date;
		private String referredTo;
		private String urgency;
		private String reason;
		
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getReferredTo() {
			return referredTo;
		}
		public void setReferredTo(String referredTo) {
			this.referredTo = referredTo;
		}
		public String getUrgency() {
			return urgency;
		}
		public void setUrgency(String urgency) {
			this.urgency = urgency;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
	}
	
	public static class Confirmation {
		private Date date;
		private String comments;
		
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
	}
}
