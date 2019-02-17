package spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ChangePasswordService {

/*	//꼭 주입 안돼도 됨
	@Qualifier("chgPwdSvc")
	private MemberDao memberDao;
	
	private Optional<MemberDao> memberDao;
	*/
	
	@Autowired
	private MemberDao memberDao;
	
	/*public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/
	
	public void changePassword(String email, String oldPwd,String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null)
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd,newPwd);
		memberDao.update(member);
		
	}

	
	
}
