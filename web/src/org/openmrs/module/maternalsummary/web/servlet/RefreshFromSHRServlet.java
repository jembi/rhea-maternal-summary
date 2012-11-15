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
package org.openmrs.module.maternalsummary.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.rheapocadapter.util.GetPatientUtil;

public class RefreshFromSHRServlet extends HttpServlet {
	
	protected Log log = LogFactory.getLog(getClass());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer patientId = Integer.parseInt( request.getParameter("patientId") );
		Patient p = Context.getPatientService().getPatient(patientId);
		
		log.info("Refreshing patient data from the SHR (patientId=" + patientId + ")");
		
		GetPatientUtil util = new GetPatientUtil();
		util.getPatientData(p);
		
		response.sendRedirect(request.getParameter("redir"));
	}
}
