package team.group7.scm.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import team.group7.scm.bean.Comment;
import team.group7.scm.service.CommentService;
import team.group7.scm.service.IOService;
import team.group7.scm.service.Impl.CommentServiceImpl;
import team.group7.scm.service.Impl.IOServiceImpl;

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
	private CommentService commentService = new CommentServiceImpl();
	private IOService ioService = new IOServiceImpl();
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
		mnNewMenuInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ioService.input();
					dispose();
					new MaintainersView().setVisible(true);
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
		
		initTable();
        
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 700, 500);
		contentPane.add(scrollPane);
		
		JButton btnLookInto = new JButton("\u67E5\u770B");
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
				JOptionPane.showMessageDialog(MaintainersView.this,lines,"详细内容",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnLookInto.setBounds(714, 39, 72, 23);
		contentPane.add(btnLookInto);
	}
	private void initTable() {
		table = createjTable();
		/** 单选 */
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter(){ 
        	@Override
            public void mouseClicked(MouseEvent e){
                selectedRow = table.getSelectedRow();
            }
        });
        table.getSelectionModel().setSelectionInterval(0,0);
	}
	/**
	 * 股评数据
	 * */
	private JTable createjTable() {
		JTable table = new JTable() {
			private static final long serialVersionUID = 7461382899262145177L;
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
}
