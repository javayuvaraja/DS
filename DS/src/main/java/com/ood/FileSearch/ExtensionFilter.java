package com.ood.FileSearch;

public class ExtensionFilter implements IFilter {

	@Override
	public boolean isValid(SearchParams params, File1 file) {
		if (params.extension == null) {
			return true;
		}

		return file.getExtension().equals(params.extension);
	}

}