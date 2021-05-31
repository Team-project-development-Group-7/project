package team.group7.scm.service;

/**
 * 处理冲突服务
 * @author UUZSAMA
 *
 */
public interface TagConflictService {
	/**
	 * 获得标签类JTable标题
	 * @return
	 */
	Object[] getTagJTableColNames();
	/**
	 * 获得标签类JTable内容（该股评各标签各属性出现次数）
	 * @return
	 */
	Object[][] getTagJTableData(int index);
}
