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
		assertEquals(tags.get(0).getTagName(),"��ض�");
		assertEquals(tags.get(0).getAtt1(),"��");
		assertEquals(tags.get(0).getAtt2(),"��");
	}
	@Test
	public void testGetTagJTableColNames() {
		Object[] colName = tagMarkService.getTagJTableColNames();
		assertTrue(colName.length==5);
		assertEquals(colName[0],"��ǩ��");
		assertEquals(colName[1],"����1");
		assertEquals(colName[2],"����2");
		assertEquals(colName[3],"����3");
		assertEquals(colName[4],"��ע����");
	}
	@Test
	public void testGetTagJTableData() {
		Object[][] data = tagMarkService.getTagJTableData();
		assertTrue(data.length>0);
		assertEquals(data[0][0],"��ض�");
		assertEquals(data[0][1],"��");
		assertEquals(data[0][2],"��");
		assertEquals(data[0][3],null);
		assertEquals(data[0][4],"");
	}

}
