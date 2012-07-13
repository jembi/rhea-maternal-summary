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
