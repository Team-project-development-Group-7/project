package team.group7.scm.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

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
import team.group7.scm.service.CommentService;
import team.group7.scm.service.SetTagService;
import team.group7.scm.service.TagMarkService;
import team.group7.scm.service.Impl.CommentServiceImpl;
import team.group7.scm.service.Impl.SetTagServiceImpl;
import team.group7.scm.service.Impl.TagMarkServiceImpl;

/**
 * @author UUZSAMA
 * */
public class TagMarkView extends JFrame {

	private TagMarkService tagMarkService = new TagMarkServiceImpl();
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
		//关闭窗口事件
		this.addWindowListener(new WindowAdapter() {  
			@Override
			public void windowClosing(WindowEvent e) {  
				super.windowClosing(e);   
				TableCellEditor ed = table.getCellEditor();
				if(ed!=null)ed.stopCellEditing();  
				List<Tag> src = tagMarkService.getTags();
				List<Tag> tags = new ArrayList<Tag>();
				for(int i=0;i<src.size();++i)tags.add(src.get(i).clone());
				int flag = 0;
				for(int i=0;i<Cache.TAG_LIST.size();++i) {
					String tmp = (String)table.getValueAt(i, 4);
					if(tmp!=null&&tmp!="") {flag = 1;}
					tags.get(i).setAtt4(tmp);
				}
				if(flag>0) {
					Cache.COMMENT_LIST.get(MarkersView.selectedRow).setTags(tags);
					MarkersView.table.getSelectionModel().setSelectionInterval(MarkersView.selectedRow, MarkersView.selectedRow+1);
					++MarkersView.selectedRow;
					Cache.saveComment();
				}
			}  
			  
		});   
	}
	/**
	 * 标注标签类
	 * */
	private JTable createjTable() {
		JTable table = new JTable(){
			private static final long serialVersionUID = -7691281643413012186L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return column<4?false:true;
			};
		};
		Object[] columnNames = tagMarkService.getTagJTableColNames();
		Object[][] data = tagMarkService.getTagJTableData();
		
		table.setModel(new DefaultTableModel(data,columnNames));
		/** 修改列宽 */
		TableColumn column = table.getColumnModel().getColumn(0);  
		column.setPreferredWidth(100);
		column.setMaxWidth(100);
		column.setMinWidth(100);
		return table;
	}
}
