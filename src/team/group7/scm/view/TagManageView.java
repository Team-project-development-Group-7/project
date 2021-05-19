package team.group7.scm.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import team.group7.scm.bean.Tag;
import team.group7.scm.service.IOService;
import team.group7.scm.service.SetTagService;
import team.group7.scm.service.Impl.IOServiceImpl;
import team.group7.scm.service.Impl.SetTagServiceImpl;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author UUZSAMA
 * */
public class TagManageView extends JFrame {

	private SetTagService setTagService = new SetTagServiceImpl();
	private IOService ioService = new IOServiceImpl();
	private static final long serialVersionUID = -7649144699181062671L;
	private JPanel contentPane;
	public static JTable table;
	public static int selectedRow = 0;	//选中行
	
	/**
	 * Create the frame.
	 */
	public TagManageView() {
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
		mnNewMenuDownload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTDownloadView().setVisible(true);
				dispose();
			}
		});
		menuBar.add(mnNewMenuDownload);
		
		JMenu mnNewMenuLook = new JMenu("\u67E5\u770B");
		mnNewMenuLook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MaintainersView().setVisible(true);
				dispose();
			}
		});
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
					new TagManageView().setVisible(true);
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
		
		table = createJTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
        table.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                selectedRow = table.getSelectedRow(); //获得选中行索引
            }
        });
        
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 500, 500);
		contentPane.add(scrollPane);
		
		JButton btnAdd = new JButton("\u65B0\u589E");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TagAddView().setVisible(true);
			}
		});
		btnAdd.setFont(new Font("黑体", Font.PLAIN, 20));
		btnAdd.setBounds(599, 59, 97, 33);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("\u4FEE\u6539");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TagUpdateView().setVisible(true);
			}
		});
		btnUpdate.setFont(new Font("黑体", Font.PLAIN, 20));
		btnUpdate.setBounds(599, 118, 97, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDel = new JButton("\u5220\u9664");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(getThis(),"你确定要删除吗?","删除",JOptionPane.YES_NO_OPTION);
				if(op == JOptionPane.YES_OPTION) {
					((DefaultTableModel) table.getModel()).removeRow(selectedRow);
					setTagService.delTag(selectedRow);
				}else { }
			}
		});
		btnDel.setFont(new Font("黑体", Font.PLAIN, 20));
		btnDel.setBounds(599, 178, 97, 33);
		contentPane.add(btnDel);
	}
	/**
	 * 标签类
	 * */
	private JTable createJTable() {
		JTable table = new JTable() {
			private static final long serialVersionUID = 7012894062931265989L;
			public boolean isCellEditable(int row, int column) {return false;};
		};
		
		Object[] columnNames = setTagService.getTagJTableColNames();
		Object[][] data = setTagService.getTagJTableData();
		
		table.setModel(new DefaultTableModel(data,columnNames));
		//修改列宽
		TableColumn column = table.getColumnModel().getColumn(0);  
		column.setPreferredWidth(80);
		column.setMaxWidth(80);
		column.setMinWidth(80);
		return table;
	}
	private JFrame getThis() {
		return this;
	}
}
