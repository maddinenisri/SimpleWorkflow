package com.mdstech.workflow.controller.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ConvertToJsonFormat {
	public static Map<String, ? extends Object> jsonDataFromList(
			final Collection<?> data) {
		final Map<String, Object> valueMap = new HashMap<String, Object>();
		if (data != null) {
			valueMap.put("success", true);
			valueMap.put("totalCount", data.size());
			valueMap.put("data", data);
		} else {
			valueMap.put("success", false);
			valueMap.put("totalCount", 0);
		}
		return valueMap;
	}

}
