package test;

import static org.junit.Assert.*;

import org.junit.Test;

import team.group7.scm.service.GraphService;
import team.group7.scm.service.Impl.GraphServiceImpl;

public class GraphServiceImplTest {
	GraphService graphService = new GraphServiceImpl();
	@Test
	public void testGetTaged() {
		assertEquals(graphService.getTaged(),5);
	}
	@Test
	public void testGetTagResult() {
		int[][] res = graphService.getTagResult();
		assertEquals(res[0][0],1);
		assertEquals(res[0][1],1);
		assertEquals(res[0][2],0);
		assertEquals(res[1][0],1);
		assertEquals(res[1][1],2);
		assertEquals(res[1][2],0);
		assertEquals(res[2][0],1);
		assertEquals(res[2][1],1);
		assertEquals(res[2][2],0);
	}
	@Test
	public void testGetNotTag() {
		assertEquals(graphService.getNotTag(),85);
	}
}
