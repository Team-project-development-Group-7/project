package team.group7.scm.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ¹ÉÆÀBean
 * @author UUZSAMA
 *
 */
public class Comment {
	private int id;			//±àºÅ
	private String content; //ÄÚÈİ
	List<Tag> tags = null;	//±êÇ©
	public Comment(int id, String content) {
		super();
		this.id = id;
		this.content = content;
		this.tags = null;
	}
	public Comment(int id, String content, List<Tag> tags) {
		super();
		this.id = id;
		this.content = content;
		this.tags = tags;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		List<Tag> tmp = new ArrayList<Tag>();
		for(Tag tag:tags)tmp.add(tag.clone());
		this.tags = tmp;
	}
}
