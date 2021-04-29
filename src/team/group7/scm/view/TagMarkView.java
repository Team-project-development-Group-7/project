package team.group7.scm.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * @author UUZSAMA
 * */
public class TagMarkView extends JFrame {

	private static final long serialVersionUID = 6041152658573649457L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TagMarkView() {
		setTitle("\u6570\u636E\u6807\u6CE8");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = createjTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 5, 426, 253);
		contentPane.add(scrollPane);
	}
	/**
	 * 标注标签类-待修改-需数据库读写
	 * */
	private JTable createjTable() {
		JTable table = new JTable();
		Object[] columnNames = {"标签类","属性1","属性2","属性3"};
		Object[][] data = {
				{"相关度"},
				{"态度"},
				{"推广"}
		};
		/*
		String[] op = { "男", "女" };
		JComboBox comboBox= new JComboBox(op);
		for(int i=0;i<3;++i)
			table.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(comboBox));
		*/
		
		table.setModel(new DefaultTableModel(data,columnNames));
		/** 修改列宽 */
		TableColumn column = table.getColumnModel().getColumn(0);  
		column.setPreferredWidth(100);
		column.setMaxWidth(100);
		column.setMinWidth(100);
		return table;
	}
}
