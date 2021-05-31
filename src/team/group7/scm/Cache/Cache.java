package team.group7.scm.Cache;

import java.util.ArrayList;
import java.util.HashMap;
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
	public static HashMap<Integer,Integer> LIST_MAP = new HashMap<Integer,Integer>();	//ÿ�������Ƿ���/�±�
	static {
		//COMMENT_LIST = JSONUtil.readCommentList();
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
		int i = 0;
		for(Comment comment:COMMENT_LIST) {
			++i;
			LIST_MAP.put(comment.getId(),i);
		}
	}

	public static void saveComment() {
		JSONUtil.writeCommentList(COMMENT_LIST);
	}
	
	public static void saveTag() {
		JSONUtil.writeTagList(TAG_LIST);
	}
	
	public static void importComment(String path) {
		List<Comment> importComment = JSONUtil.readCommentList(path);
		for(Comment comment:importComment) {
			List<Tag> tmp = comment.getTags();
			if(LIST_MAP.get(comment.getId())==null) {
				COMMENT_LIST.add(comment);
				LIST_MAP.put(comment.getId(),COMMENT_LIST.size());
				List<Tag> loc = COMMENT_LIST.get(COMMENT_LIST.size()-1).getTags();
				if(loc==null)continue;
				for(int i=0;i<loc.size();++i) {
					if(tmp.get(i).getAtt4()==null)continue;
					if(tmp.get(i).getAtt4().equals(tmp.get(i).getAtt1()))loc.get(i).att1Cnt = 1;
					if(tmp.get(i).getAtt4().equals(tmp.get(i).getAtt2()))loc.get(i).att2Cnt = 1;
					if(tmp.get(i).getAtt4().equals(tmp.get(i).getAtt3()))loc.get(i).att3Cnt = 1;
				}
			} else {
				List<Tag> loc = COMMENT_LIST.get(LIST_MAP.get(comment.getId())-1).getTags();
				if(tmp==null)continue;
				for(int i=0;i<tmp.size();++i) {
					/** ��ǩ��һ�� */
					if(!loc.get(i).getTagName().equals(tmp.get(i).getTagName()) ||
					   loc.get(i).getAtt1()!=null&&!loc.get(i).getAtt1().equals(tmp.get(i).getAtt1())||
					   loc.get(i).getAtt2()!=null&&!loc.get(i).getAtt2().equals(tmp.get(i).getAtt2())||
					   loc.get(i).getAtt3()!=null&&!loc.get(i).getAtt3().equals(tmp.get(i).getAtt3())) {
						continue;
					}
					if(tmp.get(i).getAtt4()==null)continue;
					if(tmp.get(i).getAtt4().equals(tmp.get(i).getAtt1()))++loc.get(i).att1Cnt;
					if(tmp.get(i).getAtt4().equals(tmp.get(i).getAtt2()))++loc.get(i).att2Cnt;
					if(tmp.get(i).getAtt4().equals(tmp.get(i).getAtt3()))++loc.get(i).att3Cnt;
				}
			}
		}
		saveComment();
	}
	public static void outportComment(String path) {
		JSONUtil.writeCommentList(COMMENT_LIST,path);
		saveComment();
	}
}
