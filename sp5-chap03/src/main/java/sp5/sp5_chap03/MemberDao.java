package sp5.sp5_chap03;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private static long nextId = 0;
	
	private Map<String, Member> map = new HashMap<String, Member>();
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
	}
	
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
}