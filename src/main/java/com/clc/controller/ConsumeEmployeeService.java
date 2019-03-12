package com.clc.controller;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.clc.entity.EmployeeBean;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConsumeEmployeeService {
	public static void main(String[] args) throws JSONException {
		Response response = RestAssured.get("http://localhost:8080/springwebapp/api/emps/");
		String responseString = response.asString();
		JSONArray jsonArray = new JSONArray(responseString);
		JSONObject json =null;
		List<EmployeeBean> productList = new ArrayList<EmployeeBean>();
		for(int i=0;i<jsonArray.length();i++){
			 json = new JSONObject(jsonArray.get(i).toString());
			 productList.add(new EmployeeBean(json.getInt("id"),  json.getString("name")));
		}
		
		System.out.println("Webservice json to Java Object---"+productList);
		
	}
}
