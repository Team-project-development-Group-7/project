package team.group7.scm.dao;

import java.util.List;

import team.group7.scm.bean.Tag;

/**
 * ��ǩDao
 * @author UUZSAMA
 *
 */
public interface TagDao {
	/**
	 * ����ȫ����ǩ��
	 * @return
	 */
	List<Tag> getTags();
	/**
	 * ��ӱ�ǩ��
	 * @param tag
	 */
	void addTag(Tag tag);
	/**
	 * �����±�ɾ����ǩ��
	 * @param index
	 */
	void delTag(int index);
	/**
	 * �޸Ķ�Ӧ�±��ǩ��
	 * @param tag
	 * @param index
	 */
	void updateTag(Tag tag,int index);

}
