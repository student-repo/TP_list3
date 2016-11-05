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
package eu.jpereira.trainings.designpatterns.creational.builder.xml;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.Iterator;

/**
 * This class is for demonstration purpose only!!
 * 
 * @author jpereira
 * 
 */
public class XMLReportBody implements ReportBody {

	public XMLReportBody(SaleEntry saleEntry){
		this.saleEntry = saleEntry;
	}

	private StringBuilder stringBuilder = new StringBuilder();
	private SaleEntry saleEntry = new SaleEntry();

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.creational.builder.ReportBody#
	 * getAsString()
	 */

	@Override
	public void addCustomer() {
		stringBuilder.append("<sale><customer><name>");
		stringBuilder.append(this.saleEntry.getCustomer().getName());
		stringBuilder.append("</name><phone>");
		stringBuilder.append(this.saleEntry.getCustomer().getPhone());
		stringBuilder.append("</phone></customer>");

		stringBuilder.append("<items>");
	}

	@Override
	public void addItems() {
		Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
		while ( it.hasNext() ) {
			SoldItem soldEntry= it.next();
			stringBuilder.append("<item><name>");
			stringBuilder.append(soldEntry.getName());
			stringBuilder.append("</name><quantity>");
			stringBuilder.append(soldEntry.getQuantity());
			stringBuilder.append("</quantity><price>");
			stringBuilder.append(soldEntry.getUnitPrice());
			stringBuilder.append("</price></item>");
		}
		stringBuilder.append("</items></sale>");
	}

	@Override
	public String getReport() {
		return stringBuilder.toString();
	}

}
