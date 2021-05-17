package team.group7.scm.dao;

import java.util.List;

import team.group7.scm.bean.Comment;

/**
 * 股评Dao
 * @author UUZSAMA
 *
 */
public interface CommentDao {
	/**
	 * 返回全部评论
	 * @return
	 */
	List<Comment> getComments();
	/**
	 * 添加评论
	 * @param tag
	 */
	void addComment(Comment comment);
}
