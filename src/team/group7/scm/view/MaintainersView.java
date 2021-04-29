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
 * �����鿴
 * */
public class MaintainersView extends JFrame {

	private static final long serialVersionUID = 58086414387199910L;
	private JPanel contentPane;
	private JTable table;
	/** ѡ���� */
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
		/** ��ѡ */
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
				JOptionPane.showMessageDialog(MaintainersView.this,comment,"��ϸ����",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnLookInto.setBounds(714, 39, 72, 23);
		contentPane.add(btnLookInto);
	}
	/**
	 * ��������-���޸�
	 * */
	private JTable createjTable() {
		JTable table = new JTable() {
			private static final long serialVersionUID = 7461382899262145177L;
			@Override
			public boolean isCellEditable(int row, int column) {return false;};
		};
		Object[] columnNames = {"���","��Ʊ����"};
		Object[][] data = {
				{1,"$��������(BILI)$ �����˵�����"},
				{2,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{3,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{4,"$��������(BILI)$ �����˵�����"},
				{5,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{6,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{7,"$��������(BILI)$ �����˵�����"},
				{8,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{9,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{10,"$��������(BILI)$ �����˵�����"},
				{11,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{12,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{13,"$��������(BILI)$ �����˵�����"},
				{14,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{15,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{16,"$��������(BILI)$ �����˵�����"},
				{17,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{18,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{19,"$��������(BILI)$ �����˵�����"},
				{20,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{21,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{22,"$��������(BILI)$ �����˵�����"},
				{23,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{24,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{25,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{26,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{27,"$��������(BILI)$ �����˵�����"},
				{28,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{29,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{30,"$��������(BILI)$ �����˵�����"},
				{31,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{32,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{33,"$��������(BILI)$ �����˵�����"},
				{34,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{35,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{36,"$��������(BILI)$ �����˵�����"},
				{37,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{38,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{39,"$��������(BILI)$ �����˵�����"},
				{40,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{41,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"},
				{42,"$��������(BILI)$ �����˵�����"},
				{43,"$��������-SW(09626)$ �ȴ��������������������һ���۹�������ֵ"},
				{44,"$��������(BILI)$ ���˵�������˾�õ����ˡ��������������ȥ�Ǵ���ʡ�"}
		};
		
		table.setModel(new DefaultTableModel(data,columnNames));
		//�޸��п�
		TableColumn column = table.getColumnModel().getColumn(0);  
		column.setPreferredWidth(50);
		column.setMaxWidth(50);
		column.setMinWidth(50);
		return table;
	}
}
