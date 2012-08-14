package org.openmrs.module.maternalsummary.impl;

import org.openmrs.Concept;
import org.openmrs.api.context.Context;

public enum MaternalConcept {

	/* Delivery Summary */
	DATE_OF_DELIVERY						("LOINC", "21112-8"),
	MODE_OF_DELIVERY						("LOINC", "72149-8"),
	TYPE_OF_BIRTH							("LOINC", "72146-4"),
	BIRTH_WEIGHT							("LOINC", "8339-4"),
	GENDER									("LOINC", "72143-1"),
	PRETERM_OR_TERM							("LOINC", "72147-2"),
	BLOOD_LOSS								("LOINC", "9110-8"),
	MATERNAL_OUTCOME						("LOINC", "72144-9"),
	
	/* Obs History */
	NUM_PREGNANCIES							("LOINC", "11996-6"),
	NUM_TERM_BIRTHS							("LOINC", "11977-6"),
	NUM_STILL_BIRTHS						("LOINC", "57062-2"),
	NUM_CSECTIONS							("LOINC", "68497-7"),
	LAST_BORN_STATUS						("LOINC", "72153-0"),
	LAST_BORN_BIRTHDATE						("LOINC", "68499-3"),
	DATE_OF_LMP								("LOINC", "8665 2"),
	EXPECTED_DELIVERY_DATE					("LOINC", "11779-6"),
	PRESENTATION							("LOINC", "72155-5"),
	RISK									("LOINC", "72154-8"),
	
	/* Medical History */
	MEDICAL_HISTORY							("LOINC", "72185-2"),
	
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
	INTERVENTION_IRON_AND_FOLIC_ACID		("LOINC", "72180-3"),
	INTERVENTION_PYRIMETHAMINE_SULFADOXINE	("LOINC", "72179-5"),
	INTERVENTION_MEBENDAZOLE				("RWCS", "8406"),
	INTERVENTION_MOSQUITO_NET				("LOINC", "72178-7"),
	
	/* ANC Visits*/
	NUMBER_OF_WEEKS_PREGNANT				("LOINC", "11885-1"),
	WEIGHT									("LOINC", "29463-7"),
	WEIGHT_CHANGE							("LOINC", "46040-2"),
	TEMPERATURE								("LOINC", "8310-5"),
	BP_SYSTOLIC								("LOINC", "8480-6"),
	BP_DIASTOLIC							("LOINC", "84862-4"),
	UTERUS_LENGTH							("LOINC", "11881-0"),
	FETAL_HEART_RATE						("LOINC", "55283-6"),
	
	/* General */
	YES										("RWCS", "1065"),
	;
	
	
	private String codeNamespace;
	private String code;
	
	
	MaternalConcept(String codeNamespace, String code) {
		this.codeNamespace = codeNamespace;
		this.code = code;
	}
	
	public Concept getConcept() {
		if ("RWCS".equals(codeNamespace))
			return Context.getConceptService().getConcept( Integer.parseInt(code) );
		return Context.getConceptService().getConceptByMapping(code, codeNamespace);
	}
}
