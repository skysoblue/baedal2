package menu;

import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class MenuUIPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Canvas Canvas;
	JPanel panelNorthImg, panelSouthImg, panelNorthBtn, panelSouthBtn;
	JLabel lblBN, lblImg1, lblImg2,lblImg3,lblImg4,lblImg5,lblImg6,lblImg7,lblImg8;
	JButton btnget1, btnget2, btnget3, btnget4, btnget5, btnget6, btnget7, btnget8;
	JMenu menu;
	JMenuBar bar;
	BufferedReader in;
	List<JButton> btns;

	public MenuUIPanel() {
		
		this.setLayout(new GridLayout(4, 1)); //4 = 4행 1열?
		btns = new ArrayList<JButton>();
		panelNorthImg = new JPanel();
	
		panelNorthBtn = new JPanel();
		panelSouthImg = new JPanel();
		panelSouthBtn = new JPanel();
		
		ImageIcon icon1 = new ImageIcon("src/baedalMenu/hansic/1.png");
		ImageIcon icon2 = new ImageIcon("src/baedalMenu/hansic/2.png");
		ImageIcon icon3 = new ImageIcon("src/baedalMenu/hansic/3.png");
		ImageIcon icon4 = new ImageIcon("src/baedalMenu/hansic/4.png");
		ImageIcon icon5 = new ImageIcon("src/baedalMenu/hansic/5.png");
		ImageIcon icon6 = new ImageIcon("src/baedalMenu/hansic/6.png");
		ImageIcon icon7 = new ImageIcon("src/baedalMenu/hansic/7.png");
		ImageIcon icon8 = new ImageIcon("src/baedalMenu/hansic/8.png");
	
		lblImg1 = new JLabel(icon1);
		lblImg2 = new JLabel(icon2);
		lblImg3 = new JLabel(icon3);
		lblImg4 = new JLabel(icon4);
		lblImg5 = new JLabel(icon5);
		lblImg6 = new JLabel(icon6);
		lblImg7 = new JLabel(icon7);
		lblImg8 = new JLabel(icon8);
		
		btnget1 = new JButton("담기");
		btnget2 = new JButton("담기");
		btnget3 = new JButton("담기");
		btnget4 = new JButton("담기");
		btnget5 = new JButton("담기");
		btnget6 = new JButton("담기");
		btnget7 = new JButton("담기");
		btnget8 = new JButton("담기");
		// 조합!
		
		
		panelNorthImg.add(lblImg1);
		panelNorthImg.add(lblImg2);
		panelNorthImg.add(lblImg3);
		panelNorthImg.add(lblImg4);
		panelSouthImg.add(lblImg5);
		panelSouthImg.add(lblImg6);
		panelSouthImg.add(lblImg7);
		panelSouthImg.add(lblImg8);
		
		panelNorthBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 220, 10)); // 버튼 레이아웃, 판넬에 넣어야함.
		panelSouthBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 220, 10));
		
		panelNorthBtn.add(btnget1);
		panelNorthBtn.add(btnget2);
		panelNorthBtn.add(btnget3);
		panelNorthBtn.add(btnget4);
		panelSouthBtn.add(btnget5);
		panelSouthBtn.add(btnget6);
		panelSouthBtn.add(btnget7);
		panelSouthBtn.add(btnget8);
		
	
		/*btnget1.addActionListener(this);
		btnget2.addActionListener(this);
		btnget3.addActionListener(this);
		btnget4.addActionListener(this);
		btnget5.addActionListener(this);
		btnget6.addActionListener(this);
		btnget7.addActionListener(this);
		btnget8.addActionListener(this);*/
		//패널 넣.
		this.add(panelNorthImg);
		this.add(panelNorthBtn);
		this.add(panelSouthImg);
		this.add(panelSouthBtn);
		
		
	}
	
	
	 
}
