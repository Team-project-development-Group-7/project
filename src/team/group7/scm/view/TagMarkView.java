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
	 * ��ע��ǩ��-���޸�-�����ݿ��д
	 * */
	private JTable createjTable() {
		JTable table = new JTable();
		Object[] columnNames = {"��ǩ��","����1","����2","����3"};
		Object[][] data = {
				{"��ض�"},
				{"̬��"},
				{"�ƹ�"}
		};
		/*
		String[] op = { "��", "Ů" };
		JComboBox comboBox= new JComboBox(op);
		for(int i=0;i<3;++i)
			table.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(comboBox));
		*/
		
		table.setModel(new DefaultTableModel(data,columnNames));
		/** �޸��п� */
		TableColumn column = table.getColumnModel().getColumn(0);  
		column.setPreferredWidth(100);
		column.setMaxWidth(100);
		column.setMinWidth(100);
		return table;
	}
}
