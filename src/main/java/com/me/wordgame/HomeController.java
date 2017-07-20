package com.me.wordgame;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	Service service = new Service();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "newpage";
	}

	@RequestMapping(value = "/wordgame", method = RequestMethod.GET)
	public ModelAndView afterALongTime(HttpServletRequest request, ModelAndView mv) {
		// mv.addObject("word", request.getParameter("word"));
		mv.addObject("list", service.getAllWords(request.getParameter("word")));
		mv.setViewName("newpage");
		return mv;
	}

}
