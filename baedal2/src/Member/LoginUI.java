package Member;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import category.CategoryUI;
import global.StdDimention;
import order.OrderService;
import order.OrderServiceImpl;
import order.OrderVO;

public class LoginUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pstmt;
	Timestamp reg_date;

	LoginService service = LoginServiceImpl.getInstance();
	LoginVO member = new LoginVO();
	OrderVO order = new OrderVO();
	OrderService orderService = OrderServiceImpl.getInstance();
	private String names[] = { "아이디", "비밀번호" };
	private JLabel labels[], notice;
	private JTextField fields[];
	private JButton login, join, search;
	private JPanel panelNorth, panelCenter, panelSouth;
	private int size = 2;

	public LoginUI() {
		super("배달의 기수");
		this.init();
	}

	// Event 처리 부분
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
		case "회원가입":
			this.dispose(); // 지금있는 화면을 날리고
			this.repaint(); // 새화면을 띄운다.
			JoinUI joinUI = new JoinUI();
			break;
		case "로그인":
			if (fields[0].getText().isEmpty() || fields[1].getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 다시 입력해 주세요.");
				break;
			} else{
				member = service.login(fields[0].getText(), fields[1].getText());
				if (member.getName() == null) {
					JOptionPane.showMessageDialog(this, "로그인 실패");
					break;
				} else {
					JOptionPane.showMessageDialog(this, member.getName()+"님, 환영합니다.");
					int orderSeq = orderService.add(member.getUserid());
					this.dispose();
					this.repaint();
					CategoryUI ui = new CategoryUI(orderSeq);
					break;
				}
			} 

		case "ID / PW 찾기":
			this.dispose();
			this.repaint();
			SearchUI searchUI = new SearchUI();
			break;

		default:
			break;
		}

	}

	public void idSelect() throws SQLException {
		String UsrId = null;
		ResultSet rs = null;
		int Cnt = 0;
		UsrId = fields[0].getText();
		String SQL1 = "SELECT * FROM MEMBER WHERE USERID='" + UsrId + "'";
		pstmt = con.prepareStatement(SQL1);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Cnt++;
		}

		if (Cnt > 0) {
			JOptionPane.showMessageDialog(this, "중복된 아이디가 존재 합니다.");
		} else {
			JOptionPane.showMessageDialog(this, "아이디 중복검사가 완료되었습니다.\n중복된 아이디가 없습니다.");
		}
	}

	public void init() {
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("            언제나,  어디서나,  우리는  배달의 기수");
		menubar.add(file);
		this.setJMenuBar(menubar);

		labels = new JLabel[size];
		fields = new JTextField[size];
		for (int i = 0; i < labels.length; i++)
			labels[i] = new JLabel(names[i], JLabel.CENTER);

		for (int i = 0; i < fields.length; i++)
			fields[i] = new JTextField();
		panelNorth = new JPanel();
		panelNorth.setLayout(new GridLayout(size, 2));
		for (int i = 0; i < size; i++) {
			panelNorth.add(labels[i]);
			panelNorth.add(fields[i]);
		}
		this.setVisible(true);
		login = new JButton("로그인");
		join = new JButton("회원가입");
		search = new JButton("ID / PW 찾기");
		panelCenter = new JPanel();
		panelCenter.add(login);
		panelCenter.add(join);
		panelCenter.add(search);
		panelCenter.add(search);
		panelSouth = new JPanel();
		notice = new JLabel("<html>DB연결이 되어있지 않으면 <br/>"
				+ "다음 샘플 값 중 <br/> "
				+ "========================<br/>"
				+ "ID : hong, 비번 : 1 <br/> "
				+ "ID : kim, 비번 : 1 <br/>"
				+ "ID : lee, 비번 : 1 <br/>"
				+ "========================<br/>"
				+ "하나를 선택해서 로그인 바랍니다</html>", JLabel.CENTER);
		panelSouth.add(notice);
		add(panelNorth, "North");
		add(panelCenter, "Center");
		add(panelSouth, "South");
		login.addActionListener(this);
		join.addActionListener(this);
		search.addActionListener(this);
		StdDimention.setPosition(this,300,350);
	}
}

