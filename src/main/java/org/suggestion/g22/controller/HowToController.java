package org.suggestion.g22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HowToController
{
	@RequestMapping("/howto")
	public String howTo()
	{
		return "howto";
	}
}
