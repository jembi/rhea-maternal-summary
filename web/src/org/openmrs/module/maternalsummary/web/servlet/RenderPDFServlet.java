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
import org.openmrs.api.context.Context;
import org.openmrs.module.maternalsummary.MaternalSummaryService;
import org.openmrs.module.maternalsummary.pdf.PDFRenderer.PDFRendererException;

public class RenderPDFServlet extends HttpServlet {
	
	protected Log log = LogFactory.getLog(getClass());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer patientId = Integer.parseInt( request.getParameter("patientId") );
		
		response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"summary.pdf\"");

		MaternalSummaryService mss = Context.getService(MaternalSummaryService.class);
		try {
			mss.getMaternalSummary(patientId).renderPDF(response.getOutputStream());
		} catch (PDFRendererException ex) {
			log.error(ex);
		}
		
		response.sendRedirect(request.getParameter("redir"));
	}
}
