package arch.property.impl;

import java.util.HashMap;
import java.util.Map;

import arch.property.PropertyBag;


public class PropertyBagImpl implements PropertyBag {
	
	private static Map<String, String> map = new HashMap<String, String>();
	
	static {
		map.put("factor", "3");
	}

	@Override
	public String getValue(String key) {
		return map.get(key);
	}

}
