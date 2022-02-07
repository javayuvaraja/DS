package com.ood.FileSearch;


public class MaxSizeFilter implements IFilter {

	@Override
	public boolean isValid(SearchParams params, File1 file) {
		if (params.maxSize == null) {
			return true;
		}

		return file.getSize() <= params.maxSize;
	}

}