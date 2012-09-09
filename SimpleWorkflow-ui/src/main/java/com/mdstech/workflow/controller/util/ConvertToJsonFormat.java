package com.mdstech.workflow.controller.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;

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

	public static Map<String, ? extends Object> jsonDataErrorFormData(
			final List<FieldError> errors) {
		final Map<String, Object> valueMap = new HashMap<String, Object>();
		valueMap.put("success", false);
		valueMap.put("errorInfo", "Failed Form Validations");
		valueMap.put("totalCount", errors.size());
		final Map<String, String> errorsMap = new HashMap<String, String>();
		for (final FieldError ferror : errors) {
			errorsMap.put(ferror.getField(), ferror.getDefaultMessage());
		}
		valueMap.put("errors", errorsMap);
		return valueMap;
	}

}
