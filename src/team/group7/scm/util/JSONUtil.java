package team.group7.scm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import team.group7.scm.bean.Comment;
import team.group7.scm.bean.Tag;

public class JSONUtil {
	public static final String COMMENT_FILE_NAME = "sc.comment.data";
	public static final String TAG_FILE_NAME = "sc.tag.data";

	/**
	 * 读取股评JSON文件
	 * @return
	 */
	public static List<Comment> readCommentList() {
		String content = JSONUtil.read(COMMENT_FILE_NAME);
		return JSON.parseArray(content, Comment.class);
	}
	public static List<Comment> readCommentList(String path) {
		String content = JSONUtil.read(path);
		return JSON.parseArray(content, Comment.class);
	}
	/**
	 * 股评数据写入JSON
	 * @param content
	 */
	public static void writeCommentList(List<Comment> content) {
		JSONUtil.write(COMMENT_FILE_NAME, JSON.toJSONString(content,SerializerFeature.DisableCircularReferenceDetect));
	}
	public static void writeCommentList(List<Comment> content,String path) {
		JSONUtil.write(path, JSON.toJSONString(content,SerializerFeature.DisableCircularReferenceDetect));
	}
	/**
	 * 读取标签JSON文件
	 * @return
	 */
	public static List<Tag> readTagList() {
		String content = JSONUtil.read(TAG_FILE_NAME);
		return JSON.parseArray(content, Tag.class);
	}
	/**
	 * 标签数据写入JSON
	 * @param content
	 */
	public static void writeTagList(List<Tag> content) {
		JSONUtil.write(TAG_FILE_NAME, JSON.toJSONString(content));
	}
	/**
	 * 读取JSON
	 * @param fileName
	 * @return
	 */
	public static String read(String fileName) {
		Path path = Paths.get(fileName);

		if (!Files.exists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String tmp = reader.readLine();
			reader.close();
			return tmp;
			//return Files.readString(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 写入JSON
	 * @param fileName
	 * @param content
	 */
	public static void write(String fileName, String content) {
		Path path = Paths.get(fileName);

		if (!Files.exists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			Files.write(path, content.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
