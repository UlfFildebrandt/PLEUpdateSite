package arch.dataaggregatorproperty;

import java.util.ArrayList;
import java.util.List;

import arch.dataaggregatorinterface.DataAggregator;
import arch.datasourceinterface.DefaultDataItem;
import arch.datasourceinterface.IDataItem;
import arch.datasourceinterface.IDataSource;
import arch.property.PropertyBag;

final public class PropertyDataAggregator extends DataAggregator {
	
	private PropertyBag propertyBag;

    @Override
    public List<IDataItem> get() {
        List<IDataItem> itemList = new ArrayList<IDataItem>();

        for (int dataSourceIdx = 0; dataSourceIdx < this.dataSources.size(); dataSourceIdx++) {
            IDataSource dataSource = this.dataSources.get(dataSourceIdx);

            List<IDataItem> dataSourceList = dataSource.getData();
            for (int dataSourceItemsIdx = 0; dataSourceItemsIdx < dataSourceList.size(); dataSourceItemsIdx++) {
            	IDataItem item = dataSourceList.get(dataSourceItemsIdx);
            	int factor = Integer.parseInt(this.propertyBag.getValue("factor"));
            	DefaultDataItem d = new DefaultDataItem(item.getCompany(), item.getRevenue() * factor);
            	d.setArea(item.getArea());
                itemList.add(d);
            }
        }

        return itemList;
    }

	protected void unsetPropertyBag(PropertyBag bag) {
	}

	protected void setPropertyBag(PropertyBag propertyBag) {
		this.propertyBag = propertyBag;
	}



	@Override
	public String getType() {
		return "property";
	}
}
