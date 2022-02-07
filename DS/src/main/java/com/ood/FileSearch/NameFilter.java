package com.ood.FileSearch;

public class NameFilter implements IFilter {

	@Override
	public boolean isValid(SearchParams params, File1 file) {
		if (params.name == null) {
			return true;
		}

		return file.getName().equals(params.name);
	}

}
