package com.ood.FileSearch;

public class MinSizeFilter implements IFilter {

	@Override
	public boolean isValid(SearchParams params, File file) {
		if (params.minSize == null) {
			return true;
		}

		return file.getSize() >= params.minSize;
	}

}
