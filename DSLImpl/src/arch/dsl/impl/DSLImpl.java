package arch.dsl.impl;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import arch.datasourceinterface.DefaultDataItem;
import arch.datasourceinterface.IDataItem;
import arch.dsl.DSLInterface;


public class DSLImpl implements DSLInterface {

	@Override
	public IDataItem calculate(IDataItem dataItem) {
		Binding binding = new Binding();
		binding.setVariable("dataitem", dataItem);
		GroovyShell shell = new GroovyShell(binding);

		Object value = shell.evaluate("return dataitem.revenue + 10");
		int help = ((Integer)value).intValue();
		DefaultDataItem item = new DefaultDataItem(dataItem.getCompany(), help);
		item.setArea(dataItem.getArea());
		
		return item;
	}
	


}
