package team.group7.scm.service.Impl;

import java.util.List;

import team.group7.scm.bean.Tag;
import team.group7.scm.dao.TagDao;
import team.group7.scm.dao.Impl.TagDaoImpl;
import team.group7.scm.service.SetTagService;


/**
 * 标签维护服务实现
 * @author UUZSAMA
 *
 */
public class SetTagServiceImpl implements SetTagService {
	private TagDao tagDao = new TagDaoImpl();
	@Override
	public List<Tag> getTags() {
		// TODO Auto-generated method stub
		return tagDao.getTags();
	}
	public void addTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.addTag(tag);
	}

	@Override
	public void delTag(int index) {
		// TODO Auto-generated method stub
		tagDao.delTag(index);
	}

	@Override
	public void updateTag(Tag tag, int index) {
		// TODO Auto-generated method stub
		tagDao.updateTag(tag, index);
	}
	@Override
	public Object[] getTagJTableColNames() {
		// TODO Auto-generated method stub
		Object[] columnNames = {"标签类","属性1","属性2","属性3"};
		return columnNames;
	}

	@Override
	public Object[][] getTagJTableData() {
		// TODO Auto-generated method stub
		List<Tag> tags = getTags();
		Object[][] data = new Object[tags.size()][];
		for(int i=0;i<tags.size();++i) {
			data[i] = new Object[4];
			data[i][0] = tags.get(i).getTagName();
			data[i][1] = tags.get(i).getAtt1();
			data[i][2] = tags.get(i).getAtt2();
			data[i][3] = tags.get(i).getAtt3();
		}
		return data;
	}
}
