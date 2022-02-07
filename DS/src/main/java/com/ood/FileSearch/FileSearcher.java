package com.ood.FileSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileSearcher {
	private FileFilter filter = new FileFilter();

	public List<File1> search(Directory1 dir, SearchParams params) {
		List<File1> files = new ArrayList<>();

		Queue<Directory1> queue = new LinkedList<>();
		queue.add(dir);

		while (!queue.isEmpty()) {
			Directory1 folder = queue.poll();

			for (IEntry entry : folder.entries) {
				if (entry.isDirectory()) {
					queue.add((Directory1) entry);
				} else {
					File1 file = (File1) entry;
					if (filter.isValid(params, file)) {
						files.add(file);
					}
				}
			}
		}

		return files;
	}
}