package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Tag;
import team.group7.scm.service.SetTagService;
import team.group7.scm.service.Impl.SetTagServiceImpl;

public class SetTagServiceImplTest {
	SetTagService setTagService = new SetTagServiceImpl();
	@Test
	public void testGetTags() {
		List<Tag> tags = setTagService.getTags();
		assertTrue(tags.size()>0);
		assertEquals(tags.get(0).getId(),1);
		assertEquals(tags.get(0).getTagName(),"相关度");
		assertEquals(tags.get(0).getAtt1(),"是");
		assertEquals(tags.get(0).getAtt2(),"否");
	}
	@Test
	public void testAddTag() {
		int oldSize = setTagService.getTags().size();
		setTagService.addTag(new Tag(1,"2","3"));
		assertTrue(oldSize+1==setTagService.getTags().size());
	}
	@Test
	public void testDelTag() {
		int oldSize = setTagService.getTags().size();
		int oldCommentSize = Cache.COMMENT_LIST.get(0).getTags().size();
		setTagService.delTag(oldSize-1);
		assertTrue(oldSize-1==setTagService.getTags().size());
		assertTrue(oldCommentSize-1==Cache.COMMENT_LIST.get(0).getTags().size());
	}
	@Test
	public void testUpdateTag() {
		int index = setTagService.getTags().size()-1;
		setTagService.updateTag(new Tag(1,"2","3"),index);
		assertEquals(setTagService.getTags().get(index).getId(),1);
		assertEquals(Cache.COMMENT_LIST.get(0).getTags().get(index).getTagName(),"2");
	}
	@Test
	public void testGetTagJTableColNames() {
		Object[] colName = setTagService.getTagJTableColNames();
		assertTrue(colName.length==4);
		assertEquals(colName[0],"标签类");
		assertEquals(colName[1],"属性1");
		assertEquals(colName[2],"属性2");
		assertEquals(colName[3],"属性3");
	}
	@Test
	public void testGetTagJTableData() {
		Object[][] data = setTagService.getTagJTableData();
		assertTrue(data.length>0);
		assertEquals(data[0][0],"相关度");
		assertEquals(data[0][1],"是");
		assertEquals(data[0][2],"否");
	}
}
