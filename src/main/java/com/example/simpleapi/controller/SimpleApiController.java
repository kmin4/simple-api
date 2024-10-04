package com.example.simpleapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleapi.model.Simple;
import com.example.simpleapi.model.SimpleList;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class SimpleApiController {

	SimpleList simpleList = new SimpleList();

	@GetMapping("/getSimpleList")
	public String getSimpleList() throws Exception {
		String json = new Gson().toJson(simpleList);
		return json;
	}

	@GetMapping("/addSimpleList")
	public String addSimpleList() {
		Simple simple = new Simple();
		int num = simpleList.getSize() + 1;
		String title = "Test Title" + num;
		String content = "Test Content" + num;

		simple.setNum(num);
		simple.setTitle(title);
		simple.setContent(content);

		simpleList.addSimpleList(simple);

		String json = new Gson().toJson(simpleList);
		return json;
	}

	@GetMapping("/updateSimpleList")
	public String updateSimpleList() {
		Simple simple = new Simple();
		int num = simpleList.getSize();
		String title = "Update Test Title" + num;
		String content = "Update Test Content" + num;

		simple.setNum(num);
		simple.setTitle(title);
		simple.setContent(content);

		simpleList.updateSimpleList(num-1, simple);

		String json = new Gson().toJson(simpleList);
		return json;

	}

	@GetMapping("/deleteSimpleList")
	public String deleteSimpleList() {
		int num = simpleList.getSize() - 1;
		if(num != 0){
			simpleList.deleteSimpleList(num);
		}
		
		String json = new Gson().toJson(simpleList);
		return json;
	}

}
