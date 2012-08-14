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
