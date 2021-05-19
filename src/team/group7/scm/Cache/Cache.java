package team.group7.scm.Cache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import team.group7.scm.bean.Comment;
import team.group7.scm.bean.Tag;
import team.group7.scm.util.JSONUtil;
import team.group7.scm.view.MarkersView;

/**
 * �����ݴ��ļ��ж�ȡ������ŵ������ľ�̬������
 * @author UUZSAMA
 *
 */
public class Cache {
	public static List<Comment> COMMENT_LIST;	//����
	public static List<Tag> TAG_LIST;			//��ǩ
	public static HashSet<Integer> LIST_SET = new HashSet<Integer>();
	static {
		COMMENT_LIST = JSONUtil.readCommentList();
		if (COMMENT_LIST == null) {
			COMMENT_LIST = new ArrayList<>();
		}
		TAG_LIST = JSONUtil.readTagList();
		if (TAG_LIST == null) {
			TAG_LIST = new ArrayList<>();
			TAG_LIST.add(new Tag(1,"��ض�","��","��"));
			TAG_LIST.add(new Tag(2,"̬��","����","����","����"));
			TAG_LIST.add(new Tag(3,"�ƹ�","��","��"));
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
