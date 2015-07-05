package com.jyn.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import com.jyn.beans.Demo;

public class XmlPullParserDemo {
	public static List<Demo> xmlParserDemo(InputStream in) throws Exception{
		System.out.println("begin xmlParserDemo");
		List<Demo> demos = null;
		Demo demo = null;

		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(in, "UTF-8");
		int event = parser.getEventType();
		while (event != XmlPullParser.END_DOCUMENT) {
			switch (event) {
			case XmlPullParser.START_DOCUMENT:
				break;
			case XmlPullParser.START_TAG:
				if ("demos".equals(parser.getName())) {
					demos = new ArrayList<Demo>();
				} else if ("demo".equals(parser.getName())) {
					demo = new Demo();
					demo.id = Integer.valueOf(parser.getAttributeValue(0));
					demo.name = parser.nextText().trim();
					demos.add(demo);
				}
				break;
			case XmlPullParser.END_TAG:
				break;
			default:
				break;
			}
			event = parser.next();
		}
		
		return demos;
	}
}
