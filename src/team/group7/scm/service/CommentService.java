package team.group7.scm.service;

import java.util.List;

import team.group7.scm.bean.Comment;

/**
 * 评论服务
 * @author UUZSAMA
 *
 */
public interface CommentService {
	/**
	 * 返回全部评论
	 * @return
	 */
	List<Comment> getComments();
	/**
	 * 获得股评JTable标题
	 * @return
	 */
	Object[] getTagJTableColNames();
	/**
	 * 获得股评JTable内容
	 * @return
	 */
	Object[][] getTagJTableData();
}
