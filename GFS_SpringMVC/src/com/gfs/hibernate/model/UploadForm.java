package com.gfs.hibernate.model;

public class UploadForm {
	
	private String filename = "";
	private String fileurl = "";
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public UploadForm(String filename, String fileurl) {
		super();
		this.filename = filename;
		this.fileurl = fileurl;
	}
	public UploadForm() {
		super();
	}
	
}
