package team.group7.scm.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import team.group7.scm.service.DownloadService;
import team.group7.scm.service.IOService;
import team.group7.scm.service.Impl.DownloadServiceImpl;
import team.group7.scm.service.Impl.IOServiceImpl;

public class MKDownloadView extends JFrame {

	DownloadService downloadService = new DownloadServiceImpl();
	private IOService ioService = new IOServiceImpl();
	private static final long serialVersionUID = 2320945823815001267L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public MKDownloadView() {
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
	
		JMenu mnNewMenuIo = new JMenu("\u5BFC\u5165\u5BFC\u51FA");
		menuBar.add(mnNewMenuIo);
		
		JMenu mnNewMenuInput = new JMenu("\u5BFC\u5165");
		mnNewMenuIo.add(mnNewMenuInput);
		
		JMenu mnNewMenuExport = new JMenu("\u5BFC\u51FA");
		mnNewMenuIo.add(mnNewMenuExport);
		mnNewMenuInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ioService.input();
					dispose();
					new MKDownloadView().setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenuExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ioService.output();
			}
		});
		JMenu mnNewMenuMark = new JMenu("\u80A1\u8BC4\u6807\u6CE8");
		menuBar.add(mnNewMenuMark);
		mnNewMenuMark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MarkersView().setVisible(true);
				dispose();
			}
		});
		
		JMenu mnNewMenuGraph = new JMenu("\u7EDF\u8BA1");
		menuBar.add(mnNewMenuGraph);
		mnNewMenuGraph.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MKGraphView().setVisible(true);
				dispose();
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u80A1\u7968\u4EE3\u7801");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 29, 90, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 29, 396, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCrawling = new JButton("\u722C\u53D6");
		btnCrawling.setFont(new Font("黑体", Font.PLAIN, 20));
		btnCrawling.setBounds(580, 29, 98, 33);
		btnCrawling.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int state = downloadService.downLoad(textField.getText());
				JOptionPane.showMessageDialog(MKDownloadView.this,state==200?"爬取成功!":"爬取失败!","提示",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(btnCrawling);
	}

}
