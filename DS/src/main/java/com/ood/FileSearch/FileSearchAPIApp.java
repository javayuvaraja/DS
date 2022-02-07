package com.ood.FileSearch;

public class FileSearchAPIApp {

	public static void main(String[] args) {
		new FileSearchAPIApp().test();
	}

	private void test() {
		SearchParams params = new SearchParams();
		params.extension = "xml";
		params.minSize = 2;
		params.maxSize = 100;

		File1 xmlFile = new File1();
		xmlFile.setContent("aaa.xml".getBytes());
		xmlFile.name = "aaa.xml";

		File1 txtFile = new File1();
		txtFile.setContent("bbb.txt".getBytes());
		txtFile.name = "bbb.txt";

		File1 jsonFile = new File1();
		jsonFile.setContent("ccc.json".getBytes());
		jsonFile.name = "ccc.json";

		Directory1 dir1 = new Directory1();
		dir1.addEntry(txtFile);
		dir1.addEntry(xmlFile);

		Directory1 dir0 = new Directory1();
		dir0.addEntry(jsonFile);
		dir0.addEntry(dir1);

		FileSearcher searcher = new FileSearcher();
		System.out.println(searcher.search(dir0, params));
	}

	


	

	

	
	

	

	
	

	

}