package team.group7.scm.service;

/**
 * �����ͻ����
 * @author UUZSAMA
 *
 */
public interface TagConflictService {
	/**
	 * ��ñ�ǩ��JTable����
	 * @return
	 */
	Object[] getTagJTableColNames();
	/**
	 * ��ñ�ǩ��JTable���ݣ��ù�������ǩ�����Գ��ִ�����
	 * @return
	 */
	Object[][] getTagJTableData(int index);
}
