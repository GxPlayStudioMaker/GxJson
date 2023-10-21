package com.json.gx;

import com.json.gx.reflection.AttributesGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class GxJson {
	private JSONArray jsonArray;
	private JSONObject jsonObject;

	public String toJson(Object obj) throws JSONException {
		AttributesGet at = new AttributesGet();
		at.getValueType(obj);
		jsonObject = new JSONObject();

		for (String n : at.names) {
			for (Object op : at.va) {
				jsonObject.put(n, op);
			}
		}

		return jsonObject.toString();
	}

	public String loadFrom(String phant) throws IOException {
		StringBuilder st = new StringBuilder();

		BufferedReader reader = new BufferedReader(new FileReader(phant));

		String line;
		while ((line = reader.readLine()) != null) {
			st.append(line);
		}

		reader.close();
  
		return st.toString();
	}
}