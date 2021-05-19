package team.group7.scm.service.Impl;

import java.util.List;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Comment;
import team.group7.scm.bean.Tag;
import team.group7.scm.dao.CommentDao;
import team.group7.scm.dao.Impl.CommentDaoImpl;
import team.group7.scm.service.GraphService;


public class GraphServiceImpl implements GraphService {
	CommentDao commentDao = new CommentDaoImpl();
	/**
	 * 已标注数量
	 */
	@Override
	public int getTaged() {
		// TODO Auto-generated method stub
		int tagEdNum = 0;
		List<Comment> comments = commentDao.getComments();
		for(int i=0;i<comments.size();++i)if(comments.get(i).getTags()!=null)++tagEdNum;
		return tagEdNum;
	}
	/**
	 * 统计每个标签每个属性的数量
	 */
	@Override
	public int[][] getTagResult() {
		// TODO Auto-generated method stub
		List<Comment> comments = commentDao.getComments();
		int[][] tagResult = new int[Cache.TAG_LIST.size()+1][3];
		for(int i=0;i<comments.size();++i)if(comments.get(i).getTags()!=null) {
			List<Tag> tags = comments.get(i).getTags();
			for(int j=0;j<tags.size();++j) {
				if(tags.get(j).getAtt4()!=null&&tags.get(j).getAtt1()!=null&&
						tags.get(j).getAtt4().equals(tags.get(j).getAtt1()))++tagResult[j][0];
				if(tags.get(j).getAtt4()!=null&&tags.get(j).getAtt2()!=null&&
						tags.get(j).getAtt4().equals(tags.get(j).getAtt2()))++tagResult[j][1];
				if(tags.get(j).getAtt4()!=null&&tags.get(j).getAtt3()!=null&&
						tags.get(j).getAtt4().equals(tags.get(j).getAtt3()))++tagResult[j][2];
			}
		}
		return tagResult;
	}
	@Override
	public int getNotTag() {
		// TODO Auto-generated method stub
		return Cache.COMMENT_LIST.size()-getTaged();
	}

}
