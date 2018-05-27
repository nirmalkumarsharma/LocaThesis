package org.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ReceivedFileController
{
	MultipartFile[] multipartFiles;
	
	@RequestMapping(value="/locationhistoryJson",method=RequestMethod.POST)
	public String receiveFiles(@RequestParam("files") MultipartFile[] files)
	{
		multipartFiles=files;
		
		return "redirect:/submit";
	}
	
	public MultipartFile[] getFiles()
	{
		return multipartFiles;
	}
}
