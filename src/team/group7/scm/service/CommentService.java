package team.group7.scm.service;

import java.util.List;

import team.group7.scm.bean.Comment;

/**
 * ���۷���
 * @author UUZSAMA
 *
 */
public interface CommentService {
	/**
	 * ����ȫ������
	 * @return
	 */
	List<Comment> getComments();
	/**
	 * ��ù���JTable����
	 * @return
	 */
	Object[] getTagJTableColNames();
	/**
	 * ��ù���JTable����
	 * @return
	 */
	Object[][] getTagJTableData();
}
