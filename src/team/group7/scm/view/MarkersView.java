package team.group7.scm.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Tag;
import team.group7.scm.service.CommentService;
import team.group7.scm.service.IOService;
import team.group7.scm.service.Impl.CommentServiceImpl;
import team.group7.scm.service.Impl.IOServiceImpl;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

/**
 * @author UUZSAMA
 * 股评查看&标注
 * */
public class MarkersView extends JFrame {
	private CommentService commentService = new CommentServiceImpl();
	private IOService ioService = new IOServiceImpl();
	private static final long serialVersionUID = -3930220319042994505L;
	private JPanel contentPane;
	public static JTable table;
	public static int selectedRow = 0;

	/**
	 * Create the frame.
	 */
	public MarkersView() {
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
				new MKDownloadView().setVisible(true);
				dispose();
			}
		});
		
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
					new MarkersView().setVisible(true);
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
		
		table = createjTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        table.addMouseListener(new MouseAdapter(){   
        	@Override
            public void mouseClicked(MouseEvent e){
                selectedRow = table.getSelectedRow();
            }
        });
        table.getSelectionModel().setSelectionInterval(selectedRow,selectedRow);
       
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 700, 500);
		contentPane.add(scrollPane);
		
		JButton btnLookInto = new JButton("查看");
		btnLookInto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TableModel tableModel = table.getModel();
				String comment = (String) tableModel.getValueAt(selectedRow, 1);
				String lines = "";
				for(int i=0;i<comment.length();i+=80) {
					int j = Math.min(i+80,comment.length());
					lines += comment.substring(i,j)+"\n";
				}
				JOptionPane.showMessageDialog(MarkersView.this,lines,"详细内容",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnLookInto.setBounds(714, 39, 72, 23);
		contentPane.add(btnLookInto);
		
		JButton btnMark = new JButton("\u6807\u6CE8");
		btnMark.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TagMarkView().setVisible(true);
			}
		});
		btnMark.setBounds(714, 130, 72, 23);
		contentPane.add(btnMark);
		
		JButton btnConflict = new JButton("冲突");
		btnConflict.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TagConflictView().setVisible(true);
			}
		});
		btnConflict.setBounds(714, 84, 72, 23);
		contentPane.add(btnConflict);
		setOneRowBackgroundColor(table);
	}
	/**
	 * 股评数据
	 * */
	private JTable createjTable() {
		JTable table = new JTable() {
			private static final long serialVersionUID = 2438490148172356472L;
			@Override
			public boolean isCellEditable(int row, int column) {return false;};
		};
		Object[] columnNames = commentService.getTagJTableColNames();
		Object[][] data = commentService.getTagJTableData();
		
		table.setModel(new DefaultTableModel(data,columnNames));
		//修改列宽
		TableColumn column = table.getColumnModel().getColumn(0);  
		column.setPreferredWidth(100);
		column.setMaxWidth(100);
		column.setMinWidth(100);
		return table;
	}
	/**
	 * 设置表格的某一行的背景色
	 * 白色:没有完全标注好
	 * 绿色:标注好且没有冲突
	 * 红色:有冲突
	 * @param table
	 */
	public void setOneRowBackgroundColor(JTable table) {
		try {
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				public Component getTableCellRendererComponent(JTable table,
						Object value, boolean isSelected, boolean hasFocus,
						int row, int column) {
					List<Tag> tags = commentService.getComments().get(row).getTags();
					if(tags==null) tags = Cache.TAG_LIST;
					boolean unTaged = false;
					boolean muti = false;
					for(Tag tag:tags) {
						int cnt = 0;
						if(tag.att1Cnt>0)++cnt;
						if(tag.att2Cnt>0)++cnt;
						if(tag.att3Cnt>0)++cnt;
						if(cnt==0)unTaged = true;
						else if(cnt>1)muti = true;
					}
					if (unTaged) {
						setBackground(Color.WHITE);
						setForeground(Color.BLACK);
					}else if(muti){
						setBackground(Color.RED);
						setForeground(Color.BLACK);
					}else{
						setBackground(Color.GREEN);
						setForeground(Color.BLACK);
					}
					return super.getTableCellRendererComponent(table, value,
							isSelected, hasFocus, row, column);
				}
			};
			int columnCount = table.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
				table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
			}
		} catch (Exception ex) { ex.printStackTrace(); }
	}
}
