package Member;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

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

public class SearchUI extends JFrame implements ActionListener, Runnable, ItemListener {
	LoginService service = LoginServiceImpl.getInstance();
	List<LoginVO> list = new ArrayList<LoginVO>();
	LoginVO vo = new LoginVO();
	Canvas canvas;
	JButton btnIde, btnPwe;
	BufferStrategy strategy;
	BufferedImage image;
	JPanel jp, jpIdsc, jpName, jpBirth, jpIde, jpPwsc, jpId, jpQue, jpAn, jpPwe;
	JLabel lblIdsc, lblName, lblBirth, lblPwsc, lblId, lblQue, lblAn;
	JTextField txtName, txtBirth, txtId, txtQue, txtAn;
	JComboBox combo;
	private static final long serialVersionUID = 1L;

//	public static void main(String[] args) {
//		SearchUI search = new SearchUI();
//	}

	public SearchUI() {

		this.setTitle("배달의 기수");

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("언제나,  어디서나,  우리는  배달의 기수");
		menubar.add(file);
		this.setJMenuBar(menubar);
		lblName = new JLabel("  이름      ");
		lblBirth = new JLabel("생년월일");
		lblId = new JLabel("     ID        ");
		lblQue = new JLabel("    질문      ");
		lblAn = new JLabel("   답변      ");
		txtName = new JTextField(11);
		txtBirth = new JTextField(11);
		txtId = new JTextField(11);
		txtQue = new JTextField(11);
		txtAn = new JTextField(11);
		btnIde = new JButton("ID찾기");
		btnPwe = new JButton("PW찾기");
		lblIdsc = new JLabel("ID찾기");
		lblPwsc = new JLabel("PW찾기");
		jp = new JPanel();
		jpIdsc = new JPanel();
		jpName = new JPanel();
		jpBirth = new JPanel();
		jpPwsc = new JPanel();
		jpId = new JPanel();
		jpQue = new JPanel();
		jpAn = new JPanel();
		jpIde = new JPanel();
		jpPwe = new JPanel();
		jp.setLayout(new GridLayout(9, 1));
		combo = new JComboBox();
		jpIdsc.add(lblIdsc);
		jpName.add(lblName);
		jpName.add(txtName);
		jpBirth.add(lblBirth);
		jpBirth.add(txtBirth);
		jpIde.add(btnIde);
		jpPwsc.add(lblPwsc);
		jpId.add(lblId);
		jpId.add(txtId);
		jpQue.add(lblQue);
		jpQue.add(combo);
		combo.addItem("첫 강아지");
		combo.addItem("첫 학교");
		combo.addItem("첫 사랑");
		combo.addItem("태어난곳");
		combo.addItem("첫친구");
		combo.setEditable(true);
		jpAn.add(lblAn);
		jpAn.add(txtAn);
		jpPwe.add(btnPwe);
		jp.add(jpIdsc);
		jp.add(jpName);
		jp.add(jpBirth);
		jp.add(jpIde);
		jp.add(jpPwsc);
		jp.add(jpId);
		jp.add(jpQue);
		jp.add(jpAn);
		jp.add(jpPwe);
		btnIde.addActionListener(this);
		btnPwe.addActionListener(this);
		this.add(jp);
		this.setBounds(100, 50, 400, 400);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = this.getSize();
		int xpos = (int) (screen.getWidth() / 2 - frm.getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - frm.getHeight() / 2);
		this.setLocation(xpos, ypos);

		JLabel statusbar = new JLabel("Copyright by. 배달의 기수");
		statusbar.setPreferredSize(new Dimension(10, 20));
		statusbar.setBorder(LineBorder.createBlackLineBorder());
		this.add(statusbar, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ID찾기":
			if (txtName.getText().isEmpty() || txtBirth.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "모든 정보 입력하세요");
			} else if (service.searchById(txtName.getText(), txtBirth.getText()) != null) {
				list = service.searchById(txtName.getText(), txtBirth.getText());
				for (LoginVO vo : list) {
					JOptionPane.showMessageDialog(this, "귀하의 ID는 " + vo.getUserid() + " 입니다");
					this.dispose();
					this.repaint();
					LoginUI ui = new LoginUI();
					return;
				}
				JOptionPane.showMessageDialog(this, "해당 정보의 ID가 없습니다");
			}
		}
		switch (e.getActionCommand()) {
		case "PW찾기":
			System.out.println(txtId.getText());
			System.out.println(combo.getSelectedItem().toString());
			System.out.println(txtAn.getText());
			if (txtId.getText().isEmpty() || combo.getSelectedItem().toString().isEmpty()
					|| txtAn.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "모든 정보 입력하세요");
			} else if (service.searchByPass(txtId.getText(), combo.getSelectedItem().toString(),
					txtAn.getText()) != null) {
				list = service.searchByPass(txtId.getText(), combo.getSelectedItem().toString(), txtAn.getText());
				for (LoginVO vo : list) {
					JOptionPane.showMessageDialog(this, "귀하의 비밀번호는 " + vo.getPassword() + " 입니다");
					this.dispose();
					this.repaint();
					LoginUI ui = new LoginUI();
					return;
				}
				System.out.println(list);
				JOptionPane.showMessageDialog(this, "해당 정보의 ID가 없습니다");
			}
		}
	}
}

//
// }
// }
// this.dispose(); //지금있는 화면을 날리고
// this.repaint(); // 새화면을 띄운다.
// JoinUI joinUI = new JoinUI();
// break;
// case "로그인":
// System.out.println("UI에서 실행중 =================");
// if (fields[0].getText().isEmpty()||fields[1].getText().isEmpty()) {
// JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 다시 입력해 주세요.");
// }else if (service.login(fields[0].getText(), fields[1].getText()).equals("로그인
// 실패")) {
// JOptionPane.showMessageDialog(this, "로그인 실패");
// break;
// }else{
//// service.login(fields[0].getText(), fields[1].getText());
//// service.login(fields[0].getText(), fields[1].getText()).equals("로그인 성공");
// JOptionPane.showMessageDialog(this, "환영합니다.");
//
// this.dispose();
// this.repaint();
// FisrtUI ui = new FisrtUI();
// break;
// }
//
// case "ID / PW 찾기":
// this.dispose();
// this.repaint();
// SearchUI searchUI = new SearchUI();
// break;
//
// default:
// break;
// }
//
// }
//
//
// }
//
// }
// String command = e.getActionCommand();
// switch (command) {
// case "중복확인":
// if (userIdt.getText().isEmpty()) {
// JOptionPane.showMessageDialog(this, "아이디를 입력해 주세요.");
// }else if ((service.checkDupl(userIdt.getText()))) { // 이미 가입한 아이디랑 입력한 값이
// 다르다면 ' 그 값을 입력하지 않아도 가입이 가능하댄다'
// JOptionPane.showMessageDialog(this, "이미 가입한 아이디 입니다.");
// }else {
// JOptionPane.showMessageDialog(this, "사용 가능한 아이디 입니다.");
// }
// break;
// case "회원가입":
// String id = userIdt.getText();
// String pass = passwordt.getText();
// String name = namet.getText();
// String birth = birtht.getText();
// String addr = addrt.getText();
// String phone = phonet.getText();
// String que = combo.getSelectedItem().toString(); //해야댐
// System.out.println(que);
// String ans = answert.getText();
// service.join(id, pass, name, phone, addr, birth, que, ans);
// JOptionPane.showMessageDialog(this, name+" 님 가입을 축하드립니다");
// this.dispose(); //
// this.repaint();
// LoginUI ui = new LoginUI();
// break;
// case "취소":
// this.dispose(); //
// this.repaint();
// LoginUI ui2 = new LoginUI();
// break;
// default:
// break;
// }