package org.openmrs.module.maternalsummary.pdf.impl;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openmrs.module.maternalsummary.pdf.PDFRenderer;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextRenderer implements PDFRenderer {
	
	private static final Font FONT_NORMAL = new Font(FontFamily.HELVETICA, 11);
	private static final Font FONT_HEADER1 = new Font(FontFamily.HELVETICA, 16, Font.BOLD);
	private static final Font FONT_HEADER2 = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
	private static final Font FONT_HEADER3 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
	private static final Font FONT_TABLE_BOLD = new Font(FontFamily.HELVETICA, 11, Font.BOLD);
	private static final Font FONT_FOOTER = new Font(FontFamily.HELVETICA, 8);
	
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
	public void tableEnd() throws PDFRendererException {
		try {
			doc.add(_table);
			doc.add(Chunk.NEWLINE);
		} catch (DocumentException ex) {
			throw new PDFRendererException(ex);
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
