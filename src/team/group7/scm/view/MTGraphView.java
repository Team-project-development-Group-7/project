package team.group7.scm.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

/**
 * @author UUZSAMA
 * */
public class MTGraphView extends JFrame {

	private static final long serialVersionUID = -5467094031047471042L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MTGraphView() {
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
		mnNewMenuDownload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTDownloadView().setVisible(true);
				dispose();
			}
		});
		
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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(20, 20, 743, 499);
		JComponent panel1=makeTextPanel("±ýÍ¼");
		tabbedPane.addTab("±ýÍ¼", panel1);
		JComponent panel2=makeTextPanel("Öù×´Í¼");
		tabbedPane.addTab("Öù×´Í¼", panel2);
		JComponent panel3=makeTextPanel("ÕÛÏßÍ¼");
		tabbedPane.addTab("ÕÛÏßÍ¼", panel3);
		contentPane.add(tabbedPane);
		
	}
	/**
	 * Í³¼ÆÍ¼-¹¦ÄÜ´ýÐÞ¸Ä
	 * */
	private JComponent makeTextPanel(String text){
	    JPanel panel=new JPanel(false);
	    JLabel filler=new JLabel(text);
	    filler.setHorizontalAlignment(JLabel.CENTER);
	    
	    panel.add(filler);
	    return panel;
	}

}
