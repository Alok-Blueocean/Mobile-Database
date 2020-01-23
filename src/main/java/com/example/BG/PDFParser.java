package com.example.BG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.apache.bcel.generic.NEW;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.docx4j.jaxb.XPathBinderAssociationIsPartialException;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Text;

public class PDFParser {
	public static void readDocxFile(String fileName) throws JAXBException, Docx4JException, IOException {
		File doc = new File(fileName);
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
		  .load(doc);
		MainDocumentPart mainDocumentPart = wordMLPackage
		  .getMainDocumentPart();
		String textNodesXPath = "//w:t";
		List<Object> textNodes= mainDocumentPart
		  .getJAXBNodesViaXPath(textNodesXPath, true);
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/alok.r/AIAA/bg.txt"));
		for (Object obj : textNodes) {
		    Text text = (Text) ((JAXBElement) obj).getValue();
		    String textValue = text.getValue();
		   bufferedWriter.write(textValue);
		}
		bufferedWriter.close();
	}
	public static void main(String[] args) throws JAXBException, Docx4JException, IOException {
		readDocxFile("/home/alok.r/Downloads/Brahma Jigyasa  Bhagavat Gita_UPV2.docx");
	}
}
