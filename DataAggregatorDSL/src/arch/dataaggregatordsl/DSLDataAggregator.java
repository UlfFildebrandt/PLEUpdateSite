package arch.dataaggregatordsl;

import java.util.ArrayList;
import java.util.List;

import arch.dataaggregatorinterface.DataAggregator;
import arch.datasourceinterface.IDataItem;
import arch.datasourceinterface.IDataSource;
import arch.dsl.DSLInterface;

final public class DSLDataAggregator extends DataAggregator {
	
	private DSLInterface dsl;

    @Override
    public List<IDataItem> get() {
        List<IDataItem> itemList = new ArrayList<IDataItem>();

        for (int dataSourceIdx = 0; dataSourceIdx < this.dataSources.size(); dataSourceIdx++) {
            IDataSource dataSource = this.dataSources.get(dataSourceIdx);

            List<IDataItem> dataSourceList = dataSource.getData();
            for (int dataSourceItemsIdx = 0; dataSourceItemsIdx < dataSourceList.size(); dataSourceItemsIdx++) {
            	IDataItem item = dataSourceList.get(dataSourceItemsIdx);
            	IDataItem d = dsl.calculate(item);
                itemList.add(d);
            }
        }

        return itemList;
    }

	protected void unsetDSLInterface(DSLInterface bag) {
	}

	protected void setDSLInterface(DSLInterface dsl) {
		this.dsl = dsl;
	}



	@Override
	public String getType() {
		return "dsl";
	}
}
