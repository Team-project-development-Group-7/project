package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import team.group7.scm.bean.Tag;
import team.group7.scm.service.TagMarkService;
import team.group7.scm.service.Impl.TagMarkServiceImpl;

public class TagMarkServiceImplTest {
	TagMarkService tagMarkService = new TagMarkServiceImpl();
	@Test
	public void testGetTags() {
		List<Tag> tags = tagMarkService.getTags();
		assertTrue(tags.size()>0);
		assertEquals(tags.get(0).getId(),1);
		assertEquals(tags.get(0).getTagName(),"相关度");
		assertEquals(tags.get(0).getAtt1(),"是");
		assertEquals(tags.get(0).getAtt2(),"否");
	}
	@Test
	public void testGetTagJTableColNames() {
		Object[] colName = tagMarkService.getTagJTableColNames();
		assertTrue(colName.length==5);
		assertEquals(colName[0],"标签类");
		assertEquals(colName[1],"属性1");
		assertEquals(colName[2],"属性2");
		assertEquals(colName[3],"属性3");
		assertEquals(colName[4],"标注属性");
	}
	@Test
	public void testGetTagJTableData() {
		Object[][] data = tagMarkService.getTagJTableData();
		assertTrue(data.length>0);
		assertEquals(data[0][0],"相关度");
		assertEquals(data[0][1],"是");
		assertEquals(data[0][2],"否");
		assertEquals(data[0][3],null);
		assertEquals(data[0][4],"");
	}

}
