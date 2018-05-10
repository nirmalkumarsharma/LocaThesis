package org.suggestion.g22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SubmitController
{
	@Autowired
	ReceivedFileController fileFetcher;
	
	@RequestMapping("/submit")
	public String submit(Model model)
	{
		MultipartFile[] files = fileFetcher.getFiles();
		model.addAttribute("files", files);
		return "submit";
	}
}
