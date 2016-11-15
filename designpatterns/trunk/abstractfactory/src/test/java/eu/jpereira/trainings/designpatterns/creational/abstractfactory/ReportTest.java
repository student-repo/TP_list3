/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.Report;

import static org.junit.Assert.*;

/**
 * @author jpereira
 * 
 */

public class ReportTest {

	@Test
	public void testCreateJSONReport() {

//		Report report = new Report("JSON");
//		assertEquals("JSON", report.getBody().getType());
//		assertEquals("JSON", report.getHeader().getType());
//		assertEquals("JSON", report.getFooter().getType());
		Report report = new Report();
		assertEquals("JSON", report.getFactory("Body").getReportBody("JSON").getType());
		assertEquals("JSON", report.getFactory("Header").getReportHeader("JSON").getType());
		assertEquals("JSON", report.getFactory("Footer").getReportFooter("JSON").getType());


	}

	@Test
	public void testCreateXMLReport() {

//		Report report = new Report("XML");
//		assertEquals("XML", report.getBody().getType());
//		assertEquals("XML", report.getHeader().getType());
//		assertEquals("XML", report.getFooter().getType());
		Report report = new Report();
		assertEquals("XML", report.getFactory("Body").getReportBody("XML").getType());
		assertEquals("XML", report.getFactory("Header").getReportHeader("XML").getType());
		assertEquals("XML", report.getFactory("Footer").getReportFooter("XML").getType());

	}

}
