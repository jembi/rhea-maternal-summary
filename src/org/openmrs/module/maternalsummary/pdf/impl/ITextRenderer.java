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
package org.openmrs.module.maternalsummary.pdf.impl;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openmrs.module.maternalsummary.pdf.PDFRenderer;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfBorderDictionary;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;

public class ITextRenderer implements PDFRenderer {
	
	private static final Font FONT_NORMAL = new Font(Font.HELVETICA, 11);
	private static final Font FONT_HEADER1 = new Font(Font.HELVETICA, 16, Font.BOLD);
	private static final Font FONT_HEADER2 = new Font(Font.HELVETICA, 14, Font.BOLD);
	private static final Font FONT_HEADER3 = new Font(Font.HELVETICA, 12, Font.BOLD);
	private static final Font FONT_TABLE_BOLD = new Font(Font.HELVETICA, 11, Font.BOLD);
	private static final Font FONT_FOOTER = new Font(Font.HELVETICA, 8);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
	
	private Document doc;
	private PdfPTable _table;
	private Date now;

	@Override
	public void create(OutputStream out) throws PDFRendererException {
		try {
			now = new Date();
			doc = new Document();
			PdfWriter writer = PdfWriter.getInstance(doc, out);
			//writer.setPageEvent(new FooterEvent());
			doc.open();
		} catch (DocumentException ex) {
			throw new PDFRendererException(ex);
		}
	}

	@Override
	public void close() {
		doc.close();
	}

	@Override
	public void addHeader1(String text) throws PDFRendererException {
		try {
			Paragraph p = new Paragraph(text, FONT_HEADER1);
			doc.add(p);
			doc.add(Chunk.NEWLINE);
		} catch (DocumentException ex) {
			throw new PDFRendererException(ex);
		}
	}
	
	@Override
	public void addHeader2(String text) throws PDFRendererException {
		try {
			Paragraph p = new Paragraph(text, FONT_HEADER2);
			doc.add(p);
			doc.add(Chunk.NEWLINE);
		} catch (DocumentException ex) {
			throw new PDFRendererException(ex);
		}
	}
	
	@Override
	public void addHeader3(String text) throws PDFRendererException {
		try {
			Paragraph p = new Paragraph(text, FONT_HEADER3);
			doc.add(p);
			doc.add(Chunk.NEWLINE);
		} catch (DocumentException ex) {
			throw new PDFRendererException(ex);
		}
	}
	
	
	@Override
	public void tableStart(int numCols) throws PDFRendererException {
		_table = new PdfPTable(numCols);
	}
		
	@Override
	public void tableAdd(String text) throws PDFRendererException {
		_table.addCell(new Phrase(text, FONT_NORMAL));
	}

	@Override
	public void tableAddBold(String text) throws PDFRendererException {
		_table.addCell(new Phrase(text, FONT_TABLE_BOLD));
	}
	
	@Override
	public void tableAddInputField() throws PDFRendererException {
		PdfPCell cell = new PdfPCell();
		cell.setCellEvent(new ReferralCommentEvent());
		cell.setFixedHeight(120);
		_table.addCell(cell);
	}
	
	@Override
	public void tableEnd() throws PDFRendererException {
		try {
			doc.add(_table);
			doc.add(Chunk.NEWLINE);
		} catch (DocumentException ex) {
			throw new PDFRendererException(ex);
		}
	}
	
	
	
	private class ReferralCommentEvent implements PdfPCellEvent {

		@Override
		public void cellLayout(PdfPCell cell, Rectangle rec, PdfContentByte[] canvases) {
			PdfWriter writer = canvases[0].getPdfWriter();
			TextField text = new TextField(writer, rec, "text_0");
			
			text.setBorderStyle(PdfBorderDictionary.STYLE_SOLID);
            text.setBorderColor(Color.BLACK);
            text.setBorderWidth(2);
            text.setFontSize(12);
            text.setOptions(TextField.MULTILINE);
            
            try {
	            PdfFormField field = text.getTextField();
	            writer.addAnnotation(field);
            } catch (DocumentException ex) {
            	throw new RuntimeException(ex);
            } catch (IOException ex) {
            	throw new RuntimeException(ex);
            }
		}
		
	}
	
	
	private class FooterEvent extends PdfPageEventHelper {
		@Override
		public void onEndPage(PdfWriter writer, Document doc) {
			PdfPTable footer = new PdfPTable(2);
			footer.getDefaultCell().setBorder(Rectangle.TOP);
			footer.addCell(new Phrase(dateFormat.format(now), FONT_FOOTER));
			footer.addCell(new Phrase(writer.getPageNumber()));
			footer.writeSelectedRows(0, -1, (doc.right()-doc.left())/2.0f, 42.0f, writer.getDirectContent());
		}
	}
}
