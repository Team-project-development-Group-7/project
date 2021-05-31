package team.group7.scm.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Tag;
import team.group7.scm.service.TagConflictService;
import team.group7.scm.service.TagMarkService;
import team.group7.scm.service.Impl.TagConflictServiceImpl;
import team.group7.scm.service.Impl.TagMarkServiceImpl;

/**
 * 冲突情况页面
 * @author UUZSAMA
 *
 */
public class TagConflictView extends JFrame {

	private static final long serialVersionUID = 8402002574552785019L;
	private JPanel contentPane;
	private TagConflictService tagConflictService = new TagConflictServiceImpl();
	private JTable table;
	/**
	 * Create the frame.
	 */
	public TagConflictView() {
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
	private JTable createjTable() {
		JTable table = new JTable(){
			private static final long serialVersionUID = -6678646780458417421L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		Object[] columnNames = tagConflictService.getTagJTableColNames();
		Object[][] data = tagConflictService.getTagJTableData(MarkersView.selectedRow);
		
		table.setModel(new DefaultTableModel(data,columnNames));
		/** 修改列宽 */
		TableColumn column = table.getColumnModel().getColumn(0);  
		column.setPreferredWidth(100);
		column.setMaxWidth(100);
		column.setMinWidth(100);
		return table;
	}
}
