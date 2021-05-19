package team.group7.scm.dao;

import java.util.List;

import team.group7.scm.bean.Tag;

/**
 * 标签Dao
 * @author UUZSAMA
 *
 */
public interface TagDao {
	/**
	 * 返回全部标签类
	 * @return
	 */
	List<Tag> getTags();
	/**
	 * 添加标签类
	 * @param tag
	 */
	void addTag(Tag tag);
	/**
	 * 根据下标删除标签类
	 * @param index
	 */
	void delTag(int index);
	/**
	 * 修改对应下标标签类
	 * @param tag
	 * @param index
	 */
	void updateTag(Tag tag,int index);

}
