package com.jyn.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jyn.beans.Demo;

public class JsonParserDemo {
	public static List<Demo> parseJson(String json) throws JSONException{
		List<Demo> demos = new ArrayList<Demo>();
		Demo demo = null;
		JSONArray ds = new JSONArray(json);
//		JSONArray ds = new JSONArray("[{\"id\":1, \"name\":\"demo1\"}, {\"id\":2, \"name\":\"demo2\"}]");
		JSONObject d = null;
		for(int i = 0; i < ds.length(); i++){
			d = new JSONObject(ds.get(i).toString());
			demo = new Demo();
			demo.id = d.getInt("id");
			demo.name = d.getString("name");
			demos.add(demo);
		}
		return demos;
	}
}
