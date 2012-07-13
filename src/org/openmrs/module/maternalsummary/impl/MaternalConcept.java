package org.openmrs.module.maternalsummary.impl;

import org.openmrs.Concept;
import org.openmrs.api.context.Context;

public enum MaternalConcept {

	/* Delivery Summary */
	DATE_OF_DELIVERY						(5599),
	MODE_OF_DELIVERY						(5630),
	TYPE_OF_BIRTH							(8161),
	BIRTH_WEIGHT							(5916),
	GENDER									(8160),
	PRETERM_OR_TERM							(8177),
	BLOOD_LOSS								(8191),
	MATERNAL_OUTCOME						(8163),
	
	/* Obs History */
	NUM_PREGNANCIES							(5624),
	NUM_TERM_BIRTHS							(1053),
	NUM_STILL_BIRTHS						(8142),
	NUM_CSECTIONS							(8143),
	LAST_BORN_STATUS						(8159),
	LAST_BORN_BIRTHDATE						(8404),
	DATE_OF_LMP								(968),
	EXPECTED_DELIVERY_DATE					(6188),
	PRESENTATION							(8149),
	RISK									(8156),
	
	/* Medical History */
	MEDICAL_HISTORY							(8505),
	
	/* Tests and Treatment */
	HIV_TEST_DATE							(1837),
	HIV_RESULT								(2169),
	HIV_RESULT_DATE							(6549),
	RPR_TEST_DATE							(6981),
	RPR_RESULT								(1478),
	RPR_RESULT_DATE							(6550),
	TREATED_FOR_SYPHILIS					(8169),
	PARTNER_HIV_TEST_DATE					(6551),
	PARTNER_HIV_RESULT						(3082),
	PARTNER_RPR_TEST_DATE					(8409),
	PARTNER_RPR_RESULT						(8168),
	PARTNER_TREATED_FOR_SYPHILIS			(8170),
	CREATININE_LEVEL						(790),
	CD4_DATE								(3461),
	CD4_COUNT								(5497),
	WHO_STAGE								(1480),
	ARV_START_DATE							(6132),
	ARV_REGIMEN								(2589),
	COTRIMOXAZOLE_DATE						(1499),
	INTERVENTION_IRON_AND_FOLIC_ACID		(8171),
	INTERVENTION_PYRIMETHAMINE_SULFADOXINE	(8407),
	INTERVENTION_MEBENDAZOLE				(8406),
	INTERVENTION_MOSQUITO_NET				(8405),
	
	/* ANC Visits*/
	NUMBER_OF_WEEKS_PREGNANT				(1279),
	WEIGHT									(5089),
	TEMPEARTURE								(5088),
	BP_SYSTOLIC								(5085),
	BP_DIASTOLIC							(5086),
	UTERUS_LENGTH							(8145),
	FETAL_HEART_RATE						(8146),
	
	/* General */
	YES										(1065),
	;
	
	private int id;
	
	MaternalConcept(int id) {
		this.id = id;
	}
	
	public Concept getConcept() {
		return Context.getConceptService().getConcept(id);
	}
}
