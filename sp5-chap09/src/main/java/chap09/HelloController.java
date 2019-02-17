package chap09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//component 뿐만아니라 mapping 기능도 있음
@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model,@RequestParam(value="name",required=false) String name) {
		
		model.addAttribute("greeting","안녕하세요"+name);
		return "hello";
	}
}
