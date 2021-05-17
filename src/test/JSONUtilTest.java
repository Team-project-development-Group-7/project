package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import team.group7.scm.bean.Comment;
import team.group7.scm.bean.Tag;
import team.group7.scm.util.JSONUtil;

public class JSONUtilTest {
	@Test
	public void testRead() {
		assertEquals(JSONUtil.COMMENT_FILE_NAME,"sc.comment.data");
		String JSONString = JSONUtil.read(JSONUtil.COMMENT_FILE_NAME);
		/**
		 * �ж϶������ַ����Ƿ�JSON��ʽ
		 */
		JSONString = JSONString.trim();
		assertTrue(JSONString.startsWith("{") && JSONString.endsWith("}" )||
				   JSONString.startsWith("[") && JSONString.endsWith("]"));
	}
	@Test
	public void testWrite() throws IOException {
		String pathName = "sc.test";
		String JSONString = "[����һ��JSON��ʽ���ַ���]";
		JSONUtil.write(pathName,JSONString);
		/**
		 * �жϴ洢����ַ����Ƿ�JSON��ʽ
		 */
		JSONString = JSONUtil.read(pathName);
		JSONString = JSONString.trim();
		assertTrue(JSONString.startsWith("{") && JSONString.endsWith("}" )||
				   JSONString.startsWith("[") && JSONString.endsWith("]"));
	}
	@Test
	public void testReadCommentList() {
		List<Comment> comments = JSONUtil.readCommentList();
		assertTrue(comments.size()>0);
		assertEquals(comments.get(1).getId(),179549688);
		assertEquals(comments.get(1).getContent(),"����˵����һ��Ʊһֱ������ô�죿�������Ϊʲôѡ��ͷ����Ϊ��ʱ��������죬"
				+ "������������Ҳ����С���ʳ�����ģ�������ע�طֺ죬��Ϊ���Ԥ�ڻ��ֵܷ�Ǯ���ⶼ�ǳֹ����ġ�"
				+ "$���A(SZ000002)$ $�й�ƽ��(SH601318)$ $��������(SZ000651)$ �����ɷݣ�˫�㷢չ����������");
	}
	@Test
	public void testReadTagList() {
		assertEquals(JSONUtil.TAG_FILE_NAME,"sc.tag.data");
		List<Tag> tags = JSONUtil.readTagList();
		assertTrue(tags.size()>0);
		assertEquals(tags.get(0).getId(),1);
		assertEquals(tags.get(0).getTagName(),"��ض�");
		assertEquals(tags.get(0).getAtt1(),"��");
		assertEquals(tags.get(0).getAtt2(),"��");
	}
}
