package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import team.group7.scm.bean.Comment;
import team.group7.scm.service.CommentService;
import team.group7.scm.service.Impl.CommentServiceImpl;

public class CommentServiceImplTest {
	CommentService commentService = new CommentServiceImpl();
	@Test
	public void testGetComments() {
		List<Comment> comments = commentService.getComments();
		assertTrue(comments.size()>0);
		assertEquals(comments.get(1).getId(),179549688);
		assertEquals(comments.get(1).getContent(),"����˵����һ��Ʊһֱ������ô�죿�������Ϊʲôѡ��ͷ����Ϊ��ʱ��������죬"
				+ "������������Ҳ����С���ʳ�����ģ�������ע�طֺ죬��Ϊ���Ԥ�ڻ��ֵܷ�Ǯ���ⶼ�ǳֹ����ġ�"
				+ "$���A(SZ000002)$ $�й�ƽ��(SH601318)$ $��������(SZ000651)$ �����ɷݣ�˫�㷢չ����������");
	}
	@Test
	public void testGetTagJTableColNames() {
		Object[] columnNames = commentService.getTagJTableColNames();
		assertTrue(columnNames.length==2);
		assertEquals(columnNames[0],"���");
		assertEquals(columnNames[1],"��Ʊ����");
	}
	@Test
	public void testGetTagJTableData() {
		Object[][] data = commentService.getTagJTableData();
		assertTrue(data.length>0);
		assertEquals(data[1][0],179549688);
		assertEquals(data[1][1],"����˵����һ��Ʊһֱ������ô�죿�������Ϊʲôѡ��ͷ����Ϊ��ʱ��������죬"
				+ "������������Ҳ����С���ʳ�����ģ�������ע�طֺ죬��Ϊ���Ԥ�ڻ��ֵܷ�Ǯ���ⶼ�ǳֹ����ġ�"
				+ "$���A(SZ000002)$ $�й�ƽ��(SH601318)$ $��������(SZ000651)$ �����ɷݣ�˫�㷢չ����������");
	}
}
