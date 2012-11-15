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
package org.openmrs.module.maternalsummary.impl;

import org.openmrs.Concept;
import org.openmrs.api.context.Context;

/**
 * Moved all lookups to RWCS (basically just the concept_id)
 * Code lookups are currently very slow, and so we'll have to index
 * the concept_map table first. When this is done, we can just grab the older
 * version of this file with the correct mappings from svn.
 */
public enum MaternalConcept {

	/* Delivery Summary */
	DATE_OF_DELIVERY						("RWCS", "5599"),
	MODE_OF_DELIVERY						("RWCS", "5630"),
	TYPE_OF_BIRTH							("RWCS", "8161"),
	BIRTH_WEIGHT							("RWCS", "5916"),
	GENDER									("RWCS", "8160"),
	PRETERM_OR_TERM							("RWCS", "8177"),
	BLOOD_LOSS								("RWCS", "8191"),
	MATERNAL_OUTCOME						("RWCS", "8163"),
	
	/* Obs History */
	NUM_PREGNANCIES							("RWCS", "5624"),
	NUM_TERM_BIRTHS							("RWCS", "1053"),
	NUM_STILL_BIRTHS						("RWCS", "8142"),
	NUM_CSECTIONS							("RWCS", "8143"),
	LAST_BORN_STATUS						("RWCS", "8159"),
	LAST_BORN_BIRTHDATE						("RWCS", "8404"),
	DATE_OF_LMP								("RWCS", "968"),
	EXPECTED_DELIVERY_DATE					("RWCS", "6188"),
	PRESENTATION							("RWCS", "8149"),
	RISK									("RWCS", "8156"),
	OBS_RISK								("RWCS", "8534"),
	
	/* Medical History */
	MEDICAL_HISTORY							("RWCS", "8505"),
	
	/* Tests and Treatment */
	HIV_TEST_DATE							("RWCS", "1837"),
	HIV_RESULT								("RWCS", "2169"),
	HIV_RESULT_DATE							("RWCS", "6549"),
	RPR_TEST_DATE							("RWCS", "6981"),
	RPR_RESULT								("RWCS", "1478"),
	RPR_RESULT_DATE							("RWCS", "6550"),
	TREATED_FOR_SYPHILIS					("RWCS", "8169"),
	PARTNER_HIV_TEST_DATE					("RWCS", "6551"),
	PARTNER_HIV_RESULT						("RWCS", "3082"),
	PARTNER_RPR_TEST_DATE					("RWCS", "8409"),
	PARTNER_RPR_RESULT						("RWCS", "8168"),
	PARTNER_TREATED_FOR_SYPHILIS			("RWCS", "8170"),
	CREATININE_LEVEL						("RWCS", "790"),
	CD4_DATE								("RWCS", "3461"),
	CD4_COUNT								("RWCS", "5497"),
	WHO_STAGE								("RWCS", "1480"),
	ARV_START_DATE							("RWCS", "6132"),
	ARV_REGIMEN								("RWCS", "2589"),
	COTRIMOXAZOLE_DATE						("RWCS", "1499"),
	INTERVENTION_IRON_AND_FOLIC_ACID		("RWCS", "8171"),
	INTERVENTION_PYRIMETHAMINE_SULFADOXINE	("RWCS", "8407"),
	INTERVENTION_MEBENDAZOLE				("RWCS", "8406"),
	INTERVENTION_MOSQUITO_NET				("RWCS", "8405"),
	INTERVENTION_TETANUS_VACCINE			("RWCS", "8538"),
	
	/* ANC Visits*/
	NUMBER_OF_WEEKS_PREGNANT				("RWCS", "1279"),
	WEIGHT									("RWCS", "5089"),
	WEIGHT_CHANGE							("RWCS", "8511"),
	TEMPERATURE								("RWCS", "5088"),
	BP_SYSTOLIC								("RWCS", "5085"),
	BP_DIASTOLIC							("RWCS", "5086"),
	UTERUS_LENGTH							("RWCS", "8145"),
	FETAL_HEART_RATE						("RWCS", "8146"),
	
	/* General */
	YES										("RWCS", "1065"),
	
	/* Referrals */
	REFERRED_TO								("RWCS", "8514"),
	REFERRAL_URGENCY						("RWCS", "8517"),
	REFERRAL_REASON							("RWCS", "1739"),
	REFERRAL_CONFIRMATION_COMMENTS			("RWCS", "8541"),
	;
	
	
	private String codeNamespace;
	private String code;
	
	
	MaternalConcept(String codeNamespace, String code) {
		this.codeNamespace = codeNamespace;
		this.code = code;
	}
	
	public Concept getConcept() {
		if ("RWCS".equals(codeNamespace))
			return new Concept( Integer.parseInt(code) );
		return Context.getConceptService().getConceptByMapping(code, codeNamespace);
	}
}
