package money;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import money.BankDAO;
import money.BankDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BankManager extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JScrollPane scrollList;
	JTable table_1;
	
	public BankManager() throws Exception {
		
		setSize(1252, 1000);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setVisible(false);
		panel.setBounds(105, 150, 492, 363);
		getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setBounds(960, 151, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(960, 223, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(960, 296, 116, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(960, 380, 116, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		JButton btnNewButton_1 = new JButton("삽입");  //삽입
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BankDAO dao = new BankDAO();
				BankDTO dto = new BankDTO();
				dto.setId(textField.getText());
				dto.setName(textField_1.getText());
				dto.setAge(textField_2.getText());
				dto.setTel(textField_3.getText());
				try {
					dao.insert(dto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(getContentPane(), "회원가입되었습니다");
			}
		});
		btnNewButton_1.setBounds(689, 150, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("수정"); // 수정
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BankDAO dao = new BankDAO();
				BankDTO dto = new BankDTO();
				String selectId = JOptionPane.showInputDialog("아이디를 입력하세요");
				String selectTel = JOptionPane.showInputDialog("수정할 전화번호를 입력하세요");
				try {
					dao.updateTel(selectTel, selectId);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(getContentPane(), "전화번호가 수정되었습니다");
			}
		});
		btnNewButton_2.setBounds(689, 222, 97, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("삭제"); // 삭제
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BankDAO dao = new BankDAO();
				BankDTO dto = new BankDTO();
				String selectId = JOptionPane.showInputDialog("삭제하실 아이디를 입력하세요");
				try {
					dao.delete(selectId);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(getContentPane(), "회원탈퇴되었습니다");
			}
		});
		btnNewButton_3.setBounds(689, 296, 97, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton button = new JButton("전체검색"); //전체검색
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BankDAO dao = new BankDAO();
				
				Vector<Object> dataSet = new Vector<>();
				Vector<String> col = new Vector<>();
				col.add("Id");
				col.add("Name");
				col.add("Age");
				col.add("Tel");
				ArrayList<BankDTO> list = new ArrayList<BankDTO>();
				try {
					list = dao.selectAll();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < list.size(); i++) {
					BankDTO dto = new BankDTO();
					dto = (BankDTO) list.get(i);
					Vector<Comparable> row = new Vector<Comparable>();
					row.add(dto.getId());
					row.add(dto.getName());
					row.add(dto.getAge());
					row.add(dto.getTel());
					dataSet.add(row);
				}
				table_1 = new JTable(dataSet, col);
				scrollList = new JScrollPane(table_1);
				panel.add(scrollList);
				panel.setVisible(true);
				JOptionPane.showMessageDialog(getContentPane(), "전체검색 되었습니다");
				
			}		
		});
		button.setBounds(689, 457, 97, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("검색"); //검색
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BankDAO dao = new BankDAO();
				Vector<Object> dataSet = new Vector<>();
				Vector<String> col = new Vector<>();
				col.add("Id");
				col.add("Name");
				col.add("Age");
				col.add("Tel");
				
				BankDTO dto = new BankDTO();
				String selectId = JOptionPane.showInputDialog("검색할 아이디를 입력하세요");
				ArrayList<BankDTO> list = new ArrayList<BankDTO>();
				try {
					list =  dao.selectinfo(selectId);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < list.size(); i++) {
					dto = (BankDTO) list.get(i);
				}
					Vector<Comparable> row = new Vector<Comparable>();
					row.add(dto.getId());
					row.add(dto.getName());
					row.add(dto.getAge());
					row.add(dto.getTel());
					dataSet.add(row);

					
				table_1 = new JTable(dataSet, col);
				scrollList = new JScrollPane(table_1);
				panel.add(scrollList);
				JOptionPane.showMessageDialog(getContentPane(), "검색완료되었습니다");
				panel.setVisible(true);

			}
		});
		button_1.setBounds(689, 379, 97, 23);
		getContentPane().add(button_1);
		
		JLabel label = new JLabel("\uC544\uC774\uB514");
		label.setBounds(862, 154, 57, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC774\uB984");
		label_1.setBounds(862, 226, 57, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uB098\uC774");
		label_2.setBounds(862, 299, 57, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_3.setBounds(862, 383, 57, 15);
		getContentPane().add(label_3);
	
		setVisible(true);
		
	}
	
	public static void main(String[] args) throws Exception {
		BankManager bank = new BankManager();
	}
}
