package team.group7.scm.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import team.group7.scm.bean.Tag;
import team.group7.scm.service.SetTagService;
import team.group7.scm.service.Impl.SetTagServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author UUZSAMA
 * */
public class TagAddView extends JFrame {

	private SetTagService setTagService = new SetTagServiceImpl();
	
	private static final long serialVersionUID = 8609093595688151747L;
	private JPanel contentPane;
	private JTextField textTag;
	private JTextField textAtt1;
	private JTextField textAtt2;
	private JTextField textAtt3;

	/**
	 * Create the frame.
	 */
	public TagAddView() {
		setLocationRelativeTo(null);
		setTitle("\u6570\u636E\u6807\u6CE8");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6807\u7B7E\u540D");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 34, 71, 19);
		contentPane.add(lblNewLabel);
		
		textTag = new JTextField();
		textTag.setBounds(136, 34, 158, 21);
		contentPane.add(textTag);
		textTag.setColumns(10);
		
		JLabel lblNewLabel1 = new JLabel("\u5C5E\u60271");
		lblNewLabel1.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel1.setBounds(49, 83, 58, 15);
		contentPane.add(lblNewLabel1);
		
		textAtt1 = new JTextField();
		textAtt1.setColumns(10);
		textAtt1.setBounds(136, 83, 158, 21);
		contentPane.add(textAtt1);
		
		JLabel lblNewLabel11 = new JLabel("\u5C5E\u60272");
		lblNewLabel11.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel11.setBounds(49, 115, 58, 15);
		contentPane.add(lblNewLabel11);
		
		JLabel lblNewLabel12 = new JLabel("\u5C5E\u60273");
		lblNewLabel12.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel12.setBounds(49, 146, 58, 15);
		contentPane.add(lblNewLabel12);
		
		textAtt2 = new JTextField();
		textAtt2.setColumns(10);
		textAtt2.setBounds(136, 111, 158, 21);
		contentPane.add(textAtt2);
		
		textAtt3 = new JTextField();
		textAtt3.setColumns(10);
		textAtt3.setBounds(136, 142, 158, 21);
		contentPane.add(textAtt3);
		
		JButton btnOk = new JButton("\u786E\u5B9A");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) TagManageView.table.getModel();
				tableModel.addRow(new Object[] {textTag.getText(),textAtt1.getText(),textAtt2.getText(),textAtt3.getText()});
				setTagService.addTag(new Tag(tableModel.getRowCount(),textTag.getText(),textAtt1.getText(),textAtt2.getText(),textAtt3.getText()));
				dispose();
			}
		});
		btnOk.setBounds(79, 208, 97, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(237, 208, 97, 23);
		contentPane.add(btnCancel);
	}

}
