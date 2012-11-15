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
	void tableAddInputField() throws PDFRendererException;
	void tableEnd() throws PDFRendererException;
	
	public static class PDFRendererException extends Exception {
		public PDFRendererException() { super(); }
		public PDFRendererException(String msg) { super(msg); }
		public PDFRendererException(Throwable ex) { super(ex); }
	}
}
