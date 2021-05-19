package team.group7.scm.Cache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import team.group7.scm.bean.Comment;
import team.group7.scm.bean.Tag;
import team.group7.scm.util.JSONUtil;
import team.group7.scm.view.MarkersView;

/**
 * 将数据从文件中读取出来存放到这个类的静态变量里
 * @author UUZSAMA
 *
 */
public class Cache {
	public static List<Comment> COMMENT_LIST;	//股评
	public static List<Tag> TAG_LIST;			//标签
	public static HashSet<Integer> LIST_SET = new HashSet<Integer>();
	static {
		COMMENT_LIST = JSONUtil.readCommentList();
		if (COMMENT_LIST == null) {
			COMMENT_LIST = new ArrayList<>();
		}
		TAG_LIST = JSONUtil.readTagList();
		if (TAG_LIST == null) {
			TAG_LIST = new ArrayList<>();
			TAG_LIST.add(new Tag(1,"相关度","是","否"));
			TAG_LIST.add(new Tag(2,"态度","积极","中立","消极"));
			TAG_LIST.add(new Tag(3,"推广","是","否"));
			saveTag();
		}
		for(Comment comment:COMMENT_LIST)LIST_SET.add(comment.getId());
	}

	public static void saveComment() {
		JSONUtil.writeCommentList(COMMENT_LIST);
	}
	
	public static void saveTag() {
		JSONUtil.writeTagList(TAG_LIST);
	}
	
	public static void importComment(String path) {
		List<Comment> importComment = JSONUtil.readCommentList(path);
		for(Comment comment:importComment)if(LIST_SET.contains(comment.getId())==false) {
			COMMENT_LIST.add(comment);
			LIST_SET.add(comment.getId());
		}
	}
	
	public static void outportComment(String path) {
		JSONUtil.writeCommentList(COMMENT_LIST,path);
		saveComment();
	}
}
