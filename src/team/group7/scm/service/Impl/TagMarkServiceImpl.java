package team.group7.scm.service.Impl;

import java.util.ArrayList;
import java.util.List;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Comment;
import team.group7.scm.bean.Tag;
import team.group7.scm.dao.TagDao;
import team.group7.scm.dao.Impl.TagDaoImpl;
import team.group7.scm.service.TagMarkService;
import team.group7.scm.view.MarkersView;

/**
 * 标注服务实现
 * @author UUZSAMA
 *
 */
public class TagMarkServiceImpl implements TagMarkService {
	private TagDao tagDao = new TagDaoImpl();
	@Override
	public List<Tag> getTags() {
		// TODO Auto-generated method stub
		return new ArrayList<Tag>(tagDao.getTags());
	}

	@Override
	public Object[] getTagJTableColNames() {
		// TODO Auto-generated method stub
		Object[] columnNames = {"标签类","属性1","属性2","属性3","标注属性"};
		return columnNames;
	}

	@Override
	public Object[][] getTagJTableData() {
		// TODO Auto-generated method stub
		List<Tag> tags = getTags();
		Object[][] data = new Object[tags.size()][];
		Comment cm = Cache.COMMENT_LIST.get(MarkersView.selectedRow);
		List<Tag> tmp = cm.getTags();
		if(tmp==null||tmp.size()!=tags.size()) {
			cm.setTags(tags);
			tmp = cm.getTags();
			Cache.saveComment();
		}
		for(int i=0;i<tags.size();++i) {
			/**判断标签类是否被修改过*/
			if(tags.get(i).getTagName()!=tmp.get(i).getTagName()||
					tags.get(i).getAtt1()!=tmp.get(i).getAtt1()||
					tags.get(i).getAtt2()!=tmp.get(i).getAtt2()||
					tags.get(i).getAtt3()!=tmp.get(i).getAtt3()) {
				cm.setTags(tags);
				tmp = cm.getTags();
				Cache.saveComment();
			}
			data[i] = new Object[5];
			data[i][0] = tags.get(i).getTagName();
			data[i][1] = tags.get(i).getAtt1();
			data[i][2] = tags.get(i).getAtt2();
			data[i][3] = tags.get(i).getAtt3();
			data[i][4] = tmp.get(i).getAtt4();
		}
		return data;
	}

}
