package team.group7.scm.service.Impl;

import java.util.List;

import team.group7.scm.bean.Comment;
import team.group7.scm.dao.CommentDao;
import team.group7.scm.dao.Impl.CommentDaoImpl;
import team.group7.scm.service.CommentService;
/**
 * 
 * @author UUZSAMA
 *
 */
public class CommentServiceImpl implements CommentService {
	private CommentDao commentDao = new CommentDaoImpl();
	
	/**
	 * ����ȫ������
	 * @return
	 */
	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return commentDao.getComments();
	}
	/**
	 * ��ù���JTable����
	 * @return
	 */
	@Override
	public Object[] getTagJTableColNames() {
		// TODO Auto-generated method stub
		Object[] columnNames = {"���","��Ʊ����"};
		return columnNames;
	}
	/**
	 * ��ù���JTable����
	 * @return
	 */
	@Override
	public Object[][] getTagJTableData() {
		// TODO Auto-generated method stub
		List<Comment> comments = getComments();
		Object[][] data = new Object[comments.size()][];
		for(int i=0;i<comments.size();++i) {
			data[i] = new Object[2];
			data[i][0] = comments.get(i).getId();
			data[i][1] = comments.get(i).getContent();
		}
		return data;
	}

}
