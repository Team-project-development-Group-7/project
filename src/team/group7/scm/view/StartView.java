package team.group7.scm.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 开始页面
 * @author UUZSAMA
 *
 */
public class StartView extends JFrame {

	private static final long serialVersionUID = -8530797118922967971L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public StartView() {
		setTitle("数据标注软件");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnID0 = new JButton("\u6570\u636E\u7EF4\u62A4");
		btnID0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainersView().setVisible(true);
				dispose();
			}
		});
		btnID0.setFont(new Font("黑体", Font.PLAIN, 20));
		btnID0.setBounds(200, 400, 130, 42);
		contentPane.add(btnID0);
		
		JButton btnID1 = new JButton("\u6570\u636E\u6807\u6CE8");
		btnID1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MarkersView().setVisible(true);
				dispose();
			}
		});
		btnID1.setFont(new Font("黑体", Font.PLAIN, 20));
		btnID0.setFont(new Font("黑体", Font.PLAIN, 20));
		btnID1.setBounds(410, 400, 130, 42);
		contentPane.add(btnID1);
	}
}
