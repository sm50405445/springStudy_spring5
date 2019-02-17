package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.Member;
import spring.MemberDao;
import spring.MemberRegisterService;

//responsebody + controller 
@RestController
@RequestMapping("api")
public class RestMemberController {

	@Autowired
	public MemberDao memberDao;
	
	@Autowired
	@Qualifier("memberRegisterService")
	/*@Resource*/
	public MemberRegisterService memberRegisterService;
	
	@GetMapping("members")
	public List<Member> members(){
		return memberDao.selectAll();
	}
	
	@GetMapping("members/{id}")
	public Member member(@PathVariable Long id,HttpServletResponse response) throws IOException{
		
		Member member = memberDao.selectById(id);
		if(member==null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
		
	}
}
