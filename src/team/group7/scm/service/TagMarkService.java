package team.group7.scm.service;

import java.util.List;

import team.group7.scm.bean.Tag;

/**
 * 标注者标注服务
 * @author UUZSAMA
 *
 */
public interface TagMarkService {
	/**
	 * 返回全部标签类
	 * @return
	 */
	List<Tag> getTags();
	/**
	 * 获得标注标签类JTable标题
	 * @return
	 */
	Object[] getTagJTableColNames();
	/**
	 * 获得标注标签类JTable内容
	 * @return
	 */
	Object[][] getTagJTableData();
}
