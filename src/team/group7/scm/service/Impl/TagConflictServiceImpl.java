package team.group7.scm.service.Impl;

import java.util.List;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Comment;
import team.group7.scm.bean.Tag;
import team.group7.scm.service.TagConflictService;

public class TagConflictServiceImpl implements TagConflictService {

	@Override
	public Object[] getTagJTableColNames() {
		// TODO Auto-generated method stub
		Object[] columnNames = {"标签类名","属性1(次数)","属性2(次数)","属性3(次数)"};
		return columnNames;
	}

	@Override
	public Object[][] getTagJTableData(int index) {
		// TODO Auto-generated method stub
		Comment cm = Cache.COMMENT_LIST.get(index);
		List<Tag> tags = cm.getTags();
		Object[][] data = new Object[Cache.TAG_LIST.size()][];
		for(int i=0;i<Cache.TAG_LIST.size();++i) {
			data[i] = new Object[4];
			data[i][0] = Cache.TAG_LIST.get(i).getTagName();
			if(tags==null||i>=tags.size()) {
				data[i][1] = 0;
				data[i][2] = 0;
				data[i][3] = 0;
			} else {
				data[i][1] = tags.get(i).att1Cnt;
				data[i][2] = tags.get(i).att2Cnt;
				data[i][3] = tags.get(i).att3Cnt;
			}
		}
		return data;
	}

}
