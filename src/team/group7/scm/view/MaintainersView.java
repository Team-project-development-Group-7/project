package team.group7.scm.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author UUZSAMA
 * 股评查看
 * */
public class MaintainersView extends JFrame {

	private static final long serialVersionUID = 58086414387199910L;
	private JPanel contentPane;
	private JTable table;
	/** 选中行 */
	private int selectedRow = 0;	

	/**
	 * Create the frame.
	 */
	public MaintainersView() {
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
		
		JMenu mnNewMenuIo = new JMenu("\u5BFC\u5165\u5BFC\u51FA");
		menuBar.add(mnNewMenuIo);
		
		JMenu mnNewMenuInput = new JMenu("\u5BFC\u5165");
		mnNewMenuIo.add(mnNewMenuInput);
		
		JMenu mnNewMenuExport = new JMenu("\u5BFC\u51FA");
		mnNewMenuIo.add(mnNewMenuExport);
		
		JMenu mnNewMenuTagManage = new JMenu("\u6807\u7B7E\u7BA1\u7406");
		mnNewMenuTagManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TagManageView().setVisible(true);
				dispose();
			}
		});
		menuBar.add(mnNewMenuTagManage);
		
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
		
		table = createjTable();
		/** 单选 */
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter(){ 
        	@Override
            public void mouseClicked(MouseEvent e){
                selectedRow = table.getSelectedRow();
            }
        });
        
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 700, 500);
		contentPane.add(scrollPane);
		
		JButton btnLookInto = new JButton("\u67E5\u770B");
		btnLookInto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TableModel tableModel = table.getModel();
				String comment = (String) tableModel.getValueAt(selectedRow, 1);
				JOptionPane.showMessageDialog(MaintainersView.this,comment,"详细内容",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnLookInto.setBounds(714, 39, 72, 23);
		contentPane.add(btnLookInto);
	}
	/**
	 * 股评数据-待修改
	 * */
	private JTable createjTable() {
		JTable table = new JTable() {
			private static final long serialVersionUID = 7461382899262145177L;
			@Override
			public boolean isCellEditable(int row, int column) {return false;};
		};
		Object[] columnNames = {"编号","股票评论"};
		Object[][] data = {
				{1,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{2,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{3,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{4,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{5,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{6,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{7,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{8,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{9,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{10,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{11,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{12,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{13,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{14,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{15,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{16,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{17,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{18,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{19,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{20,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{21,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{22,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{23,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{24,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{25,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{26,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{27,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{28,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{29,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{30,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{31,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{32,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{33,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{34,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{35,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{36,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{37,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{38,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{39,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{40,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{41,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"},
				{42,"$哔哩哔哩(BILI)$ 年轻人的世界"},
				{43,"$哔哩哔哩-SW(09626)$ 先打个卡，哔哩哔哩，是下一个港股万亿市值"},
				{44,"$哔哩哔哩(BILI)$ 早就说了这个公司烂到根了。哪里来的哪里回去是大概率。"}
		};
		
		table.setModel(new DefaultTableModel(data,columnNames));
		//修改列宽
		TableColumn column = table.getColumnModel().getColumn(0);  
		column.setPreferredWidth(50);
		column.setMaxWidth(50);
		column.setMinWidth(50);
		return table;
	}
}
