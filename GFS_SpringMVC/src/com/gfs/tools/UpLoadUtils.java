package com.gfs.tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class UpLoadUtils {
	
	//上传文件
	public String testFileUpload(String desc, MultipartFile file, 
			HttpServletRequest request) throws IOException{

			String path = request.getSession().getServletContext().getRealPath("upload");  
			
			
			String fileName = file.getOriginalFilename();

			int lastIndexOfDot = fileName.lastIndexOf('.');
	        int fileNameLength = fileName.length();
	        final String extension = fileName.substring(lastIndexOfDot+1, fileNameLength);
	        
			String strObj = desc+((new Date()).getTime());
			fileName = desc+";"+MD5Utils.GetMD5Code(strObj)+"."+extension;
			File targetFile = new File(path, fileName); 
			
			if(!targetFile.exists()){  
				targetFile.mkdirs();  
			}  

			//保存  
			try {  
				file.transferTo(targetFile);  
			} catch (Exception e) {  
				e.printStackTrace();  
			}  
			
			return "upload/"+fileName;
	}
	
	//下载文件
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session, String url) throws IOException{
		url = "/"+url;
		
		int lastIndexOfFenhao = url.lastIndexOf(';');
        int fileNameLength = url.length();
        final String filenameBen = url.substring(0, lastIndexOfFenhao);
        
		int lastIndexOfDot = url.lastIndexOf('.');
        final String extension = url.substring(lastIndexOfDot+1, fileNameLength);
        
        String filename = filenameBen+"."+extension;
		
		byte [] body = null;
		ServletContext servletContext = session.getServletContext();
		InputStream in = servletContext.getResourceAsStream(url); //下载upload下的U盘01.jpg文件
		body = new byte[in.available()];
		in.read(body);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename="+filename);  //自定义下载文件名称
		
		HttpStatus statusCode = HttpStatus.OK;
		
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	
	//文件删除
	public boolean deletefile(String filePath) throws Exception{
		
		File file = new File(filePath);
		
		if (!file.isDirectory()) {
			file.delete();
		}else if (file.isDirectory()) {
			String[] filelist = file.list();
			for (int i = 0; i < filelist.length; i++) {
				File delfile = new File(filePath + "/" + filelist[i]);
				if (!delfile.isDirectory()) {
					delfile.delete();
				}else if (delfile.isDirectory()) {
					deletefile(filePath + "/" + filelist[i]);
				}
			}
			file.delete();
		}
		return true;
	}
	
}
