package team.group7.scm.service;

/**
 * 导入导出服务
 * @author UUZSAMA
 *
 */
public interface IOService {
	/**
	 * 导入
	 * @throws Exception
	 */
	public void input() throws Exception;
	/**
	 * 导出
	 * @return
	 */
	public boolean output();
}
