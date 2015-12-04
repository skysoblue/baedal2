package Member;

import java.io.Serializable;

import global.SQL;

public class MemberVO implements Serializable, SQL{
	
	private String userid;		// 아이디
	private String password;	// 비번
	private String name;		// 회원이름
	private String phone;		// 전화번호
	private String addr;		// 주소
	private String birth;		// 태어난 날짜
	private String question;				//질문
	private String answer;				//답
	
//	================Member====================
	
	
	public MemberVO() {

	}
	
	
	
	public MemberVO(String userid, String password, String name, String phone, String addr, 
				String birth, String question , String answer) {
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.birth = birth;
		this.question = question;
		this.answer = answer;
	}
	
	
	public String selectAll(){
		String query = "select * from member";
		return query;
	}
	

	public String insert() {
		String query = "insert into member (userid, password, name , phone , addr ,birth, question, answer)" 
					+ "values(?,?,?,?,?,?,?,?)";
		return query;
	}
	

	public String login() {
		String query = "select * from member where userid = "
				+make(this.userid)+" and password = "+make(this.password);
		return query;
	}


	public String selectByID(String name, String birth) {
		String query = "select * from member where name =" 
				+this.make(name)+ "and birth=" +this.make(birth);
		return query;
	}
// select userid from member where birth='19800101' and name='홍길동';

	
	
	public String selectByPass(String userid, String question, String answer) {
		String query = "select * from member where userid ="
				+this.make(userid)+ "and question=" +this.make(question)+ "and ans=" +this.make(answer);
		return query;  //내일 해야댐
	}

	
	public String checkID(String userid){
		String query = "select * from member where userid ="+make(userid);
		return query;
	}
	
	@Override
	public String make(String s) {
		// TODO Auto-generated method stub
		return "'"+s+"'";
	}



	public String getUserid() {
		return userid;
	}



	public String getPassword() {
		return password;
	}



	public String getName() {
		return name;
	}



	public String getPhone() {
		return phone;
	}



	public String getAddr() {
		return addr;
	}



	public String getBirth() {
		return birth;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public String getQuestion() {
		return question;
	}



	public String getAnswer() {
		return answer;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	@Override
	public String toString() {
		return "LoginVO [userid=" + userid + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", addr=" + addr + ", birth=" + birth + ", question=" + question + ", answer=" + answer + "]";
	}









}