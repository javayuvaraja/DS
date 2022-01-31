package com.ood.FileSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileSearcher {
	private FileFilter filter = new FileFilter();

	public List<File> search(Directory dir, SearchParams params) {
		List<File> files = new ArrayList<>();

		Queue<Directory> queue = new LinkedList<>();
		queue.add(dir);

		while (!queue.isEmpty()) {
			Directory folder = queue.poll();

			for (IEntry entry : folder.entries) {
				if (entry.isDirectory()) {
					queue.add((Directory) entry);
				} else {
					File file = (File) entry;
					if (filter.isValid(params, file)) {
						files.add(file);
					}
				}
			}
		}

		return files;
	}
}