package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.Member;
import spring.MemberDao;

@Controller
public class MemberListController {

	@Autowired
	private MemberDao memberDao;
	
	//listcommand 뒤에 꼭 error를 넣어야함!!!
	@RequestMapping("members")
	public String list(@ModelAttribute("cmd") ListCommand listcommand,Errors errors,Model model) {
		
		if(errors.hasErrors()) {
			return "member/memberList";
		}
		
		if(listcommand.getFrom()!=null && listcommand.getTo()!=null) {
			List<Member> members = memberDao.selectByRegdate(listcommand.getFrom(), listcommand.getTo());
			model.addAttribute("members",members);
		}
		
		
		return "member/memberList";
	}
}
