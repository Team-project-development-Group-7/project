package team.group7.scm.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * @author UUZSAMA
 * */
public class MTDownloadView extends JFrame {

	private static final long serialVersionUID = -4704855265036136063L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public MTDownloadView() {
		setTitle("\u6570\u636E\u6807\u6CE8\u8F6F\u4EF6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnNewMenuHome = new JMenu("\u4E3B\u9875");
		menuBar.add(mnNewMenuHome);
		mnNewMenuHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new StartView().setVisible(true);
				dispose();
			}
		});
		
		JMenu mnNewMenuDownload = new JMenu("\u4E0B\u8F7D");
		menuBar.add(mnNewMenuDownload);
		
		JMenu mnNewMenuLook = new JMenu("\u67E5\u770B");
		menuBar.add(mnNewMenuLook);
		mnNewMenuLook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MaintainersView().setVisible(true);
				dispose();
			}
		});
		
		JMenu mnNewMenuIo = new JMenu("\u5BFC\u5165\u5BFC\u51FA");
		menuBar.add(mnNewMenuIo);
		
		JMenu mnNewMenuInput = new JMenu("\u5BFC\u5165");
		mnNewMenuIo.add(mnNewMenuInput);
		
		JMenu mnNewMenuExport = new JMenu("\u5BFC\u51FA");
		mnNewMenuIo.add(mnNewMenuExport);
		
		JMenu mnNewMenuTagManage = new JMenu("\u6807\u7B7E\u7BA1\u7406");
		menuBar.add(mnNewMenuTagManage);
		mnNewMenuTagManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TagManageView().setVisible(true);
				dispose();
			}
		});
		
		JMenu mnNewMenuGraph = new JMenu("\u7EDF\u8BA1");
		menuBar.add(mnNewMenuGraph);
		mnNewMenuGraph.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTGraphView().setVisible(true);
				dispose();
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u80A1\u7968\u4EE3\u7801");
		lblNewLabel.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 29, 90, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 29, 396, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCrawling = new JButton("\u722C\u53D6");
		btnCrawling.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
		btnCrawling.setBounds(580, 29, 98, 33);
		contentPane.add(btnCrawling);
	}
}
