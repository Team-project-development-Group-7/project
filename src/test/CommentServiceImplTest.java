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
		assertEquals(comments.get(1).getContent(),"有人说，万一股票一直跌，怎么办？这就是我为什么选龙头，因为即时发生黑天鹅，"
				+ "发生最差情况，也是最小概率出问题的，而且我注重分红，因为最差预期还能分点钱，这都是持股信心。"
				+ "$万科A(SZ000002)$ $中国平安(SH601318)$ $格力电器(SZ000651)$ 伊利股份，双汇发展，招商银行");
	}
	@Test
	public void testGetTagJTableColNames() {
		Object[] columnNames = commentService.getTagJTableColNames();
		assertTrue(columnNames.length==2);
		assertEquals(columnNames[0],"编号");
		assertEquals(columnNames[1],"股票评论");
	}
	@Test
	public void testGetTagJTableData() {
		Object[][] data = commentService.getTagJTableData();
		assertTrue(data.length>0);
		assertEquals(data[1][0],179549688);
		assertEquals(data[1][1],"有人说，万一股票一直跌，怎么办？这就是我为什么选龙头，因为即时发生黑天鹅，"
				+ "发生最差情况，也是最小概率出问题的，而且我注重分红，因为最差预期还能分点钱，这都是持股信心。"
				+ "$万科A(SZ000002)$ $中国平安(SH601318)$ $格力电器(SZ000651)$ 伊利股份，双汇发展，招商银行");
	}
}
