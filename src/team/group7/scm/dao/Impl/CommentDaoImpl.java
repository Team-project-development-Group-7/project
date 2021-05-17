package team.group7.scm.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Comment;
import team.group7.scm.dao.CommentDao;
import team.group7.scm.dao.TagDao;

/**
 * ¹ÉÆÀDaoImpl
 * @author UUZSAMA
 *
 */
public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return Cache.COMMENT_LIST;
	}

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		Cache.COMMENT_LIST.add(comment);
		Cache.saveComment();
	}

}
