package com.bowlong.third.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

@SuppressWarnings("unchecked")
public class XMLEx {

	public static final Document createDocument() {
		Document doc = DocumentHelper.createDocument();
		return doc;
	}

	public static final Element createRootElement(String name) {
		Element e = DocumentHelper.createElement(name);
		return e;
	}

	public static final Element createRootElement(Document doc, String name) {
		Element e = createRootElement(name);
		doc.setRootElement(e);
		return e;
	}

	public static final Attribute createAttribute(Element e, String name, String value) {
		Attribute a = DocumentHelper.createAttribute(e, name, value);
		return a;
	}

	public static final Document parse4Path(final String path)
			throws DocumentException {
		return parse(new File(path));
	}
	
	public static final Document parse(final String xml)
			throws DocumentException {
		return parse(new StringReader(xml));
	}

	public static final Document parse(final Reader reader)
			throws DocumentException {
		SAXReader sr = new SAXReader();
		Document doc = sr.read(reader);
		return doc;
	}

	public static final Document parse(final File f) throws DocumentException {
		SAXReader sr = new SAXReader();
		Document doc = sr.read(f);
		return doc;
	}

	public static final Document parse(final InputStream in)
			throws DocumentException {
		SAXReader sr = new SAXReader();
		Document doc = sr.read(in);
		return doc;
	}

	public static final Element getRoot4Path(final String path)
			throws DocumentException {
		Document doc = parse4Path(path);
		return getRoot(doc);
	}
	
	public static final Element getRoot(final String xml)
			throws DocumentException {
		Document doc = parse(xml);
		return getRoot(doc);
	}

	public static final Element getRoot(final File f) throws DocumentException {
		Document doc = parse(f);
		return getRoot(doc);
	}

	public static final Element getRoot(final Reader reader)
			throws DocumentException {
		Document doc = parse(reader);
		return getRoot(doc);
	}

	public static final Element getRoot(final Document doc) {
		return doc.getRootElement();
	}

	public static final Element getRoot(final Element e, final String name) {
		return e.element(name);
	}

	public static final Element element(final Element e, final String name) {
		Element e1 = e.element(name);
		return e1;
	}

	public static final List<Element> elements(final Element e) {
		List<Element> e1 = ((List<Element>) e.elements());
		return e1;
	}

	public static final List<Element> elements(final Element e,
			final String name) {
		List<Element> e1 = ((List<Element>) e.elements(name));
		return e1;
	}

	public static final Element addElement(final Element e, final String name) {
		return e.addElement(name);
	}

	public static final Element setText(final Element e, final String text) {
		e.setText(text);
		return e;
	}

	public static final Element setBool(final Element e, final boolean value) {
		return setText(e, String.valueOf(value));
	}

	public static final Element setByte(final Element e, final byte value) {
		return setText(e, String.valueOf(value));
	}

	public static final Element setShort(final Element e, final short value) {
		return setText(e, String.valueOf(value));
	}

	public static final Element setInt(final Element e, final int value) {
		return setText(e, String.valueOf(value));
	}

	public static final Element setLong(final Element e, final long value) {
		return setText(e, String.valueOf(value));
	}

	public static final Element setFloat(final Element e, final float value) {
		return setText(e, String.valueOf(value));
	}

	public static final Element setDouble(final Element e, final double value) {
		return setText(e, String.valueOf(value));
	}

	public static final Attribute setText(final Attribute a, final String value) {
		a.setValue(value);
		return a;
	}

	public static final Attribute setBool(final Attribute a, final boolean value) {
		a.setValue(String.valueOf(value));
		return a;
	}

	public static final Attribute setByte(final Attribute a, final byte value) {
		a.setValue(String.valueOf(value));
		return a;
	}

	public static final Attribute setShort(final Attribute a, final short value) {
		a.setValue(String.valueOf(value));
		return a;
	}

	public static final Attribute setInt(final Attribute a, final int value) {
		a.setValue(String.valueOf(value));
		return a;
	}

	public static final Attribute setLong(final Attribute a, final long value) {
		a.setValue(String.valueOf(value));
		return a;
	}

	public static final Attribute setFloat(final Attribute a, final float value) {
		a.setValue(String.valueOf(value));
		return a;
	}

	public static final Attribute setDouble(final Attribute a,
			final double value) {
		a.setValue(String.valueOf(value));
		return a;
	}

	public static final Element addAttribute(final Element e,
			final String name, final String value) {
		return e.addAttribute(name, value);
	}

	public static final Element addAttribute(final Element e,
			final String name, final boolean value) {
		return addAttribute(e, name, String.valueOf(value));
	}

	public static final Element addAttribute(final Element e,
			final String name, final byte value) {
		return addAttribute(e, name, String.valueOf(value));
	}

	public static Element addAttribute(final Element e, final String name,
			final short value) {
		return addAttribute(e, name, String.valueOf(value));
	}

	public static final Element addAttribute(final Element e,
			final String name, final int value) {
		return addAttribute(e, name, String.valueOf(value));
	}

	public static final Element addAttribute(final Element e,
			final String name, final long value) {
		return addAttribute(e, name, String.valueOf(value));
	}

	public static final Element addAttribute(final Element e,
			final String name, final float value) {
		return addAttribute(e, name, String.valueOf(value));
	}

	public static final Element addAttribute(final Element e,
			final String name, final double value) {
		return addAttribute(e, name, String.valueOf(value));
	}

	public static final Attribute attribute(final Element e, final String name) {
		return e.attribute(name);
	}

	public static final String getText(final Element e) {
		if (e == null)
			return "";
		return e.getText();
	}

	public static final String getTextTrim(final Element e) {
		if (e == null)
			return "";
		return e.getTextTrim();
	}

	public static final String getText(final Attribute a) {
		if (a == null)
			return "";
		return a.getText();
	}

	public static final String getTextTrim(final Attribute a) {
		if (a == null)
			return "";
		return a.getText().trim();
	}

	public static final void writeTo(Document doc, OutputStream out)
			throws IOException {
		writePrettyTo(doc, out);
	}

	public static final void writePrettyTo(Document doc, OutputStream out)
			throws IOException {
		// 美化格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter wr = new XMLWriter(out, format);
		wr.write(doc);
	}

	public static final void writeCompactTo(Document doc, OutputStream out)
			throws IOException {
		// 缩减格式
		OutputFormat format = OutputFormat.createCompactFormat();
		format.setEncoding("UTF-8");
		XMLWriter wr = new XMLWriter(out, format);
		wr.write(doc);
	}

	public static final String XML_TAG = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	public static void main(String[] args) throws DocumentException,
			IOException {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><request><hRet>0</hRet><status>1800</status><transIDO>12345678901234567</transIDO><versionId>100</versionId><userId>12345678</userId><cpServiceId>120123002000</cpServiceId><consumeCode>120123002001</consumeCode><cpParam>0000000000000000</cpParam></request>";
		Document doc = parse(str);
		writePrettyTo(doc, System.out);
		// System.out.println(doc.asXML());
	}

}
