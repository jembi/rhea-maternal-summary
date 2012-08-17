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
