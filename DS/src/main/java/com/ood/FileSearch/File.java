package com.ood.FileSearch;

public class File extends Entry {
	private byte[] content;

	public String getExtension() {
		return name.substring(name.indexOf("."), 1);
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public byte[] getContent() {
		return content;
	}

	@Override

	public int getSize() {
		return content.length;
	}

	@Override

	public boolean isDirectory() {
		return false;
	}

	@Override

	public String toString() {
		return "File{" + "name='" + name + "'}";
	}
}