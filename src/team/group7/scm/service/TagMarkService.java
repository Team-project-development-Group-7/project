package team.group7.scm.service;

import java.util.List;

import team.group7.scm.bean.Tag;

/**
 * ��ע�߱�ע����
 * @author UUZSAMA
 *
 */
public interface TagMarkService {
	/**
	 * ����ȫ����ǩ��
	 * @return
	 */
	List<Tag> getTags();
	/**
	 * ��ñ�ע��ǩ��JTable����
	 * @return
	 */
	Object[] getTagJTableColNames();
	/**
	 * ��ñ�ע��ǩ��JTable����
	 * @return
	 */
	Object[][] getTagJTableData();
}
