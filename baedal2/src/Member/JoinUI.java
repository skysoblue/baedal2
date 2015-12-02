package Member;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class  JoinUI extends JFrame implements ActionListener, ItemListener{
	LoginService service = LoginServiceImpl.getInstance();
	private static final long serialVersionUID = 1L;

	JFrame jform=new JFrame();
	JComboBox combo;
	JPanel overjpan,westjpan,eastjpan,southjpan,jpan;
	JLabel userId,password,name,birth,addr,phone,hint,answer, statusbar
	       ,empty,empty1,empty2,empty3,empty4,empty5,empty6,empty7,empty8,empty9,formlabel,formlabel2;
	JTextField userIdt,passwordt,namet,birtht,addrt,phonet,hintt,answert;
	JButton conform,resulton,cn;
	JMenuBar menubar;
	JMenu file;
	
//	public static void main(String[] args) {
//	   JoinUI join = new JoinUI();
//	}
	
	
	public JoinUI() {
	   menubar = new JMenuBar();
	   file = new JMenu("언제,   어디서건,   배달을   원하는   모든   분들을   위해   배달의   기수는   오늘도   달립니다");
	   menubar.add(file);
	   this.setJMenuBar(menubar);
	   statusbar = new JLabel("Copyright by. 배달의 기수");
	   statusbar.setPreferredSize(new Dimension(10, 20));
	   statusbar.setBorder(LineBorder.createBlackLineBorder());

	   combo = new JComboBox();
	   overjpan=new JPanel();
	   westjpan=new JPanel();
	   eastjpan=new JPanel();
	   southjpan=new JPanel();
	   jpan=new JPanel();
	   userIdt=new JTextField(11);
	   passwordt=new JTextField(11);
	   namet=new JTextField(11);
	   birtht=new JTextField(11);
	   addrt=new JTextField(11);
	   phonet=new JTextField(11);
	   hintt=new JTextField(11);
	   answert=new JTextField(11);
	   formlabel= new JLabel("회원가입",JLabel.CENTER);
	   formlabel2= new JLabel("취소",JLabel.CENTER);
	   resulton=new JButton("회원가입");
	   cn=new JButton("취소");
	   conform=new JButton("중복확인");
	   
	     overjpan.setPreferredSize(new Dimension(250,35));
	     westjpan.setPreferredSize(new Dimension(10,235));
	     eastjpan.setPreferredSize(new Dimension(10,235));
	     southjpan.setPreferredSize(new Dimension(250,10));
	     overjpan.add(formlabel);
	     this.add(BorderLayout.NORTH,overjpan);
	     this.add(BorderLayout.WEST,westjpan);
	     this.add(BorderLayout.EAST,eastjpan);
	     this.add(BorderLayout.SOUTH,southjpan);

	   userId= new JLabel("아이디",JLabel.CENTER);
	   password=new JLabel("비밀번호",JLabel.CENTER);
	   name=new JLabel("이름",JLabel.CENTER);
	   birth=new JLabel("생년월일",JLabel.CENTER);
	   addr=new JLabel("주소",JLabel.CENTER);
	   phone=new JLabel("휴대폰",JLabel.CENTER);
	   hint=new JLabel("힌트",JLabel.CENTER);
	   answer=new JLabel("답변",JLabel.CENTER);
	   empty=new JLabel();
	   empty1=new JLabel();
	   empty2=new JLabel();
	   empty3=new JLabel();
	   empty4=new JLabel();
	   empty5=new JLabel();
	   empty6=new JLabel();
	   empty7=new JLabel();
	   empty8=new JLabel();
	   empty9=new JLabel();
	   GridLayout g1=new GridLayout(10,3);
	   g1.setHgap(5);
	   g1.setVgap(5);
	   jpan.setLayout(g1);
	   
	   jpan.add(userId);
	   jpan.add(userIdt);
	   jpan.add(conform);
	   jpan.add(password);
	   jpan.add(passwordt);
	   jpan.add(empty);
	   jpan.add(name);
	   jpan.add(namet);
	   jpan.add(empty1);
	   jpan.add(birth);
	   jpan.add(birtht);
	   jpan.add(empty2);
	   jpan.add(addr);
	   jpan.add(addrt);
	   jpan.add(empty3);
	   jpan.add(phone);
	   jpan.add(phonet);
	   jpan.add(empty4);
	   jpan.add(hint);
	   jpan.add(combo);
	   combo.addItem("첫 강아지");
	   combo.addItem("첫 학교");     
	   combo.addItem("첫 사랑");     
	   combo.addItem("태어난곳");     
	   combo.addItem("첫 친구");
	   combo.addItemListener(this);
	   combo.setEditable(true);
	   jpan.add(empty5);
	   jpan.add(answer);
	   jpan.add(answert);
	   jpan.add(empty6);
	   jpan.add(empty7);
	   jpan.add(resulton);
	   jpan.add(cn);
	   jpan.add(empty8);
	   this.add(BorderLayout.CENTER,jpan);
	   
	   
	   this.add(statusbar, BorderLayout.SOUTH);
	   conform.addActionListener(this);
	   resulton.addActionListener(this);
	   cn.addActionListener(this);
	   this.setTitle("배달의 기수");
	   this.setBounds(new Rectangle(600,400));
	   Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	      Dimension frm = this.getSize();
	      int xpos = (int) (screen.getWidth()/2-frm.getWidth()/2);
	      int ypos = (int)(screen.getHeight()/2-frm.getHeight()/2);
	      this.setLocation(xpos,ypos);
	      this.setResizable(false);
	   this.setVisible(true);
	   
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "중복확인":
			if (userIdt.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력해 주세요.");
			}else if ((service.checkDupl(userIdt.getText()))) { // 이미 가입한 아이디랑 입력한 값이 다르다면 ' 그 값을 입력하지 않아도 가입이 가능하댄다'
				JOptionPane.showMessageDialog(this, "이미 가입한 아이디 입니다.");
			}else {
				JOptionPane.showMessageDialog(this, "사용 가능한 아이디 입니다.");
			}
			break;
		case "회원가입":
			if (userIdt.getText().isEmpty()||passwordt.getText().isEmpty()||namet.getText().isEmpty()||
					birtht.getText().isEmpty()||addrt.getText().isEmpty()||phonet.getText().isEmpty()||
					combo.getSelectedItem().toString().isEmpty() ||answert.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "모든 정보를 입력하세요");
//				this.dispose();   
//				this.repaint();
//				JoinUI ui = new JoinUI();
			} else {
				String id = userIdt.getText();
				String pass = passwordt.getText();
				String name = namet.getText();
				String birth = birtht.getText();
				String addr = addrt.getText();
				String phone = phonet.getText();
				String que = combo.getSelectedItem().toString(); //해야댐
				System.out.println(que);
				String ans = answert.getText();
				service.join(id, pass, name, phone, addr, birth, que, ans);
				
				JOptionPane.showMessageDialog(this, name+" 님 가입을 축하드립니다");
				this.dispose();  // 
				this.repaint();
				LoginUI ui = new LoginUI();
			}
			break;
		case "취소":
			this.dispose();  // 
			this.repaint();
			LoginUI ui2 = new LoginUI();
			break;
		default:
			break;
		}
	}
//		@Override
//		public void itemStateChanged(ItemEvent e) {
//			String qs = (String) combo.getSelectedItem();
//			switch (qs) {
//			case "첫 강아지":
//				System.exit(0);
//				break;
//			case "첫 학교":
//				System.exit(0);
//				break;
//			case "첫 사랑":
//				System.exit(0);
//				break;
//			case "태어난곳":
//				System.exit(0);
//				break;
//			case "첫친구":
//				System.exit(0);
//				break;
//			default:
//				break;
//		}
//	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}