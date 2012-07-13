package org.openmrs.module.maternalsummary;

import org.openmrs.api.OpenmrsService;

public interface MaternalSummaryService extends OpenmrsService {
	
	MaternalSummary getMaternalSummary(int patientId);
	
}
