package team.group7.scm.dao.Impl;

import java.util.List;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Comment;
import team.group7.scm.bean.Tag;
import team.group7.scm.dao.TagDao;

/**
 * ±Í«©DaoImpl
 * @author UUZSAMA
 *
 */
public class TagDaoImpl implements TagDao {

	@Override
	public List<Tag> getTags() {
		// TODO Auto-generated method stub
		return Cache.TAG_LIST;
	}

	@Override
	public void addTag(Tag tag) {
		// TODO Auto-generated method stub
		Cache.TAG_LIST.add(tag);
		List<Comment> cms = Cache.COMMENT_LIST;
		for(int i=0;i<cms.size();++i) if(cms.get(i).getTags()!=null){
			cms.get(i).getTags().add(tag.clone());
		}
		Cache.saveComment();
		Cache.saveTag();
	}

	@Override
	public void delTag(int index) {
		// TODO Auto-generated method stub
		Cache.TAG_LIST.remove(index);
		List<Comment> cms = Cache.COMMENT_LIST;
		for(int i=0;i<cms.size();++i) if(cms.get(i).getTags()!=null){
			cms.get(i).getTags().remove(index);
		}
		Cache.saveComment();
		Cache.saveTag();
	}

	@Override
	public void updateTag(Tag tag, int index) {
		// TODO Auto-generated method stub
		Cache.TAG_LIST.set(index,tag);
		List<Comment> cms = Cache.COMMENT_LIST;
		for(int i=0;i<cms.size();++i) if(cms.get(i).getTags()!=null){
			cms.get(i).getTags().set(index,tag.clone());
		}
		Cache.saveComment();
		Cache.saveTag();
	}


}
