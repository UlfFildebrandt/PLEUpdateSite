package arch.dataaggregate;

import java.util.HashMap;

import org.osgi.service.component.ComponentContext;

import arch.dataaggregatorinterface.IDataAggregator;

public class RegisterComponent {
	private DataAggregate servlet = null;
	private HashMap<String, IDataAggregator> map = new HashMap<String, IDataAggregator>();
	   
    protected void setServlet(DataAggregate servlet) {
    	this.servlet = servlet;
    }
    
    protected void unsetServlet(DataAggregate servlet) {
    }
    
    protected void setAggregatorService(IDataAggregator aggregator) {
    	map.put(aggregator.getType(), aggregator);
    }
    
    protected void unsetAggregatorService(IDataAggregator aggregator) {
    	map.remove(aggregator.getType());
    }
    
    protected void activate(ComponentContext context) {
		servlet.setMap(map);
    }
}
