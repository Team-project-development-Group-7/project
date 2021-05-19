package team.group7.scm.service.Impl;

import java.util.ArrayList;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Comment;
import team.group7.scm.service.DownloadService;
import team.group7.scm.spider.Spider;


public class DownloadServiceImpl implements DownloadService {
	@Override
	public int downLoad(String id) {
		// TODO Auto-generated method stub
		ArrayList<Spider.Data> datas = Spider.downLoad(id);
		for(int i=0;i<datas.size();++i) {
			Spider.Data comment = datas.get(i);
			try {
				Cache.COMMENT_LIST.add(new Comment(Integer.parseInt(comment.id),comment.comment));
			}catch (NumberFormatException e) {
				// TODO: handle exception
				Cache.COMMENT_LIST.add(new Comment(-1,comment.comment));
			}
		}
		Cache.saveComment();
		return Spider.reply_code;
	}

}