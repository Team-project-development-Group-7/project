package team.group7.scm.dao;

import java.util.List;

import team.group7.scm.bean.Comment;

/**
 * ����Dao
 * @author UUZSAMA
 *
 */
public interface CommentDao {
	/**
	 * ����ȫ������
	 * @return
	 */
	List<Comment> getComments();
	/**
	 * �������
	 * @param tag
	 */
	void addComment(Comment comment);
}
