package account;

public class newID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // 아이디 새로 만들때 이거 사용하세요 !

		accountDao dao = new accountDao();
		accountVo vo = new accountVo();
		
		vo.setMid("a010");                  // 아이디
		vo.setPassword(dao.encode("123"));  // 비밀번호
		vo.setMname("항우성원");                // 이름
		vo.setMjob("백업담당");                 // 업무
		vo.setMposition("데이터관리자");          // 직무명

	
		dao.insert(vo);
	}

}
