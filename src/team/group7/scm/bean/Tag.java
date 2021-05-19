package team.group7.scm.bean;

/**
 * 标签Bean
 * @author UUZSAMA
 *
 */
public class Tag {
	private int id;				//编号
	private String tagName;		//标签类名
	private String att1;		//属性1
	private String att2;		//属性2
	private String att3;		//属性3
	private String att4 = null; //标注属性
	public Tag() {
		super();
	}
	public Tag(int id, String tagName, String att1) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.att1 = att1;
	}
	public Tag(int id, String tagName, String att1, String att2) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.att1 = att1;
		this.att2 = att2;
	}
	public Tag(int id, String tagName, String att1, String att2, String att3) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
	}
	public Tag(int id, String tagName, String att1, String att2, String att3, String att4) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
		this.setAtt4(att4);
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getAtt1() {
		return att1;
	}
	public void setAtt1(String att1) {
		this.att1 = att1;
	}
	public String getAtt2() {
		return att2;
	}
	public void setAtt2(String att2) {
		this.att2 = att2;
	}
	public String getAtt3() {
		return att3;
	}
	public void setAtt3(String att3) {
		this.att3 = att3;
	}
	public String getAtt4() {
		return att4;
	}
	public void setAtt4(String att4) {
		this.att4 = att4;
	}
	@Override
    public Tag clone(){
        Tag node = new Tag(this.id,this.tagName,this.att1,this.att2,this.att3,this.att4);
        return node;
    }
}
