package com.gfs.spring.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gfs.hibernate.model.UploadForm;
import com.gfs.hibernate.pojo.TrySpringmvc;
import com.gfs.spring.service.TypeService;
import com.gfs.tools.Charset;
import com.gfs.tools.UpLoadUtils;

@RequestMapping("/text")
@Controller
public class TEXT {

	private UploadForm uploadForm = new UploadForm();
	private UpLoadUtils upLoadUtils = new UpLoadUtils();
	String fileurl = "";
	private TrySpringmvc trySpringmvc = null;
	
	@Autowired
	private TypeService typeService;

	@RequestMapping("/text01")
	public String text01(){
		
		return "typelist";
	}
	
	@RequestMapping(value="text02", params={"uname","age!=10"})
	public String text02(){
		
		return "typelist";
	}
	
	@RequestMapping(value="text03", params={"uname","password","age!=10"})
	public String text03(@RequestParam("uname") String uname){
		System.out.println(uname);
		return "typelist01";
	}
	
	@RequestMapping("/text04/{str}")
	public String text04(@PathVariable("str") String str){
		System.out.println("str=             "+str);
		return "typelist";
	}
	
	@RequestMapping("/text05")
	public String text05(TrySpringmvc str) throws Exception{
		System.out.println("str=             "+str.getName());
		return "typelist";
	}
	
	@RequestMapping("/text06")
	public ModelAndView text06(){
		
		ModelAndView andView = new ModelAndView("typelist01");
		
		andView.addObject("name","混合");
		andView.addObject("time",new Date());
		
		return andView;
	}
	
	@RequestMapping("/text07")
	public String text07(Map<String, List<TrySpringmvc>> MP) throws Exception{
		List<TrySpringmvc> list = null;
		list = typeService.findAll();
		MP.put("TYPElist", list);
		return "typelist01";
	}
	 
	@RequestMapping("/text08")
	public String text08(TrySpringmvc type) throws Exception{
		type.setName(Charset.toUTF8(type.getName()));
		System.out.println(type.getName());
		if (typeService.add(type)) {
			return "typelist";
		}
		return "fail";
	}

	@RequestMapping("/upload")
	public ModelAndView testFileUpload(@RequestParam("desc") String desc, 
								@RequestParam("file") MultipartFile file, 
								HttpServletRequest request, 
								ModelMap model) throws IOException{
		fileurl = upLoadUtils.testFileUpload(desc, file, request);
		
		ModelAndView andView = new ModelAndView("upload_success");
		
		andView.addObject("tiaozuan","addtype?myname="+desc+"&myfile="+fileurl);
		
		return andView;
	}
	
	@RequestMapping(value="download", params={"url"})
	public ResponseEntity<byte[]> testFiledownload(@RequestParam("url") String url
												,HttpSession session) throws IOException{
		return upLoadUtils.testResponseEntity(session, url);
	}
	
	@RequestMapping("/zuanzai")
	public String testFileUpload(){
		
		return "Tyr_Upload";
	}
	
	//更新操作
	@RequestMapping(value="update", params={"mid"}, method=RequestMethod.GET)
	public String updatetype(@RequestParam("mid") Integer mid, 
						Map<String, Object> map) throws Exception{
		map.put("type", typeService.findById(mid));
		map.put("TYPElist", typeService.findAll());
		return "addtype";
	}
	
	@RequestMapping(value="/uptype", method=RequestMethod.POST)
	public String updatetype(TrySpringmvc type, 
			HttpServletRequest request, 
			ModelMap model) throws Exception{
		System.out.println(type.getName());
		System.out.println(type.getFile());
		if (typeService.update(type)) {
			return "redirect:/text/text07"; //重定向
		}
		return "fail";
	}
	
	@RequestMapping(value="addtype", params={"myname","myfile"}, method=RequestMethod.GET)
	public String addtype(@RequestParam("myname") String myname, 
						@RequestParam("myfile") String myfile,
						Map<String, Object> map) throws Exception{
		map.put("TYPElist", typeService.findAll());
		map.put("type", new TrySpringmvc());
		map.put("myname",myname);
		map.put("myfile",myfile);
		return "addtype";
	}
	
	@RequestMapping(value="/addtype", method=RequestMethod.POST)
	public String addmytype(TrySpringmvc type, 
						HttpServletRequest request, 
						ModelMap model) throws Exception{
		System.out.println(type.getName());
		System.out.println(type.getFile());
		if (typeService.add(type)) {
			return "redirect:/text/text07"; //重定向
		}
		return "fail";
	}
	
	@RequestMapping("/text09")
	public String text09(TrySpringmvc type) throws Exception{
		type.setName(Charset.toUTF8(type.getName()));
		System.out.println(type.getName());
		if (typeService.add(type)) {
			return "typelist";
		}
		return "fail";
	}
	
	//删除元素
	@RequestMapping("/delTry/{mid}")
	public String deletemytype(@PathVariable("mid") Integer id, Map<String, List<TrySpringmvc>> MP) throws Exception{
		trySpringmvc = typeService.findById(id);
		if (trySpringmvc.getFile()!=null) {
			
			if((upLoadUtils.deletefile(trySpringmvc.getFile()))&&(typeService.delete(id))){
				
				return "redirect:/text/text07";
			}
		}
		if(typeService.delete(id)){
			return "redirect:/text/text07";
		}
		
		return "fail";
	}
	
}
