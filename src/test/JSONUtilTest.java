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
		 * 判断读出的字符串是否JSON格式
		 */
		JSONString = JSONString.trim();
		assertTrue(JSONString.startsWith("{") && JSONString.endsWith("}" )||
				   JSONString.startsWith("[") && JSONString.endsWith("]"));
	}
	@Test
	public void testWrite() throws IOException {
		String pathName = "sc.test";
		String JSONString = "[这是一个JSON格式的字符串]";
		JSONUtil.write(pathName,JSONString);
		/**
		 * 判断存储后的字符串是否JSON格式
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
		assertEquals(comments.get(1).getContent(),"有人说，万一股票一直跌，怎么办？这就是我为什么选龙头，因为即时发生黑天鹅，"
				+ "发生最差情况，也是最小概率出问题的，而且我注重分红，因为最差预期还能分点钱，这都是持股信心。"
				+ "$万科A(SZ000002)$ $中国平安(SH601318)$ $格力电器(SZ000651)$ 伊利股份，双汇发展，招商银行");
	}
	@Test
	public void testReadTagList() {
		assertEquals(JSONUtil.TAG_FILE_NAME,"sc.tag.data");
		List<Tag> tags = JSONUtil.readTagList();
		assertTrue(tags.size()>0);
		assertEquals(tags.get(0).getId(),1);
		assertEquals(tags.get(0).getTagName(),"相关度");
		assertEquals(tags.get(0).getAtt1(),"是");
		assertEquals(tags.get(0).getAtt2(),"否");
	}
}
