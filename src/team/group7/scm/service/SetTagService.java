package team.group7.scm.service;

import java.util.List;

import team.group7.scm.bean.Tag;

/**
 * ά����ǩ����
 * @author UUZSAMA
 *
 */
public interface SetTagService {
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
	/**
	 * ��ñ�ǩ��JTable����
	 * @return
	 */
	Object[] getTagJTableColNames();
	/**
	 * ��ñ�ǩ��JTable����
	 * @return
	 */
	Object[][] getTagJTableData();
}
