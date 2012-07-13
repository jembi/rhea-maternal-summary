package org.openmrs.module.maternalsummary.pdf;

import java.io.OutputStream;

/**
 * Wall the pdf renderer behind an interface.
 * 
 * This is just in case we need to replace iText (it's AGPL), but if we stick with it,
 * it might be better to get rid of this and use iText directly, so that it's features can be used more fully.
 */
public interface PDFRenderer {

	void create(OutputStream out) throws PDFRendererException;
	void close();
	
	void addHeader1(String text) throws PDFRendererException;
	void addHeader2(String text) throws PDFRendererException;
	void addHeader3(String text) throws PDFRendererException;
	
	void tableStart(int numCols) throws PDFRendererException;
	void tableAdd(String text) throws PDFRendererException;
	void tableAddBold(String text) throws PDFRendererException;
	void tableEnd() throws PDFRendererException;
	
	public static class PDFRendererException extends Exception {
		public PDFRendererException() { super(); }
		public PDFRendererException(String msg) { super(msg); }
		public PDFRendererException(Throwable ex) { super(ex); }
	}
}
