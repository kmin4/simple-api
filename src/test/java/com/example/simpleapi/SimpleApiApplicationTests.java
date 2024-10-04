package com.example.simpleapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.simpleapi.model.Simple;
import com.example.simpleapi.model.SimpleList;

@SpringBootTest
class SimpleApiApplicationTests {
	SimpleList simpleList = new SimpleList();

	@Test
	void getSimpleList() {
		simpleList.getSimpleList();
	}

	@Test
	void addSimpleList(){
		Simple simple = new Simple();
		int num = simpleList.getSize() + 1;
		String title = "Test Title" + num;
		String content = "Test Content" + num;

		simple.setNum(num);
		simple.setTitle(title);
		simple.setContent(content);

		simpleList.addSimpleList(simple);
	}

	@Test
	void updateSimpleList() {
		Simple simple = new Simple();
		int num = simpleList.getSize();
		String title = "Update Test Title" + num;
		String content = "Update Test Content" + num;

		simple.setNum(num);
		simple.setTitle(title);
		simple.setContent(content);

		simpleList.updateSimpleList(num-1, simple);
	}

	@Test
	void deleteSimpleList(){
		int num = simpleList.getSize() - 1;
		if(num != 0){
			simpleList.deleteSimpleList(num);
		}
		
	}
}
