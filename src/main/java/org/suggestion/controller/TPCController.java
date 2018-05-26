package org.suggestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TPCController
{
	@RequestMapping("/tpc")
	public String tpc()
	{
		return "tpc";
	}
}
