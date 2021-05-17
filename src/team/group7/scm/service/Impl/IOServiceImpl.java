package team.group7.scm.service.Impl;

import javax.swing.JFileChooser;

import team.group7.scm.Cache.Cache;
import team.group7.scm.service.IOService;

public class IOServiceImpl implements IOService {
	private JFileChooser fileChooser = new JFileChooser(".");
	@Override
	public void input() throws Exception {
		// TODO Auto-generated method stub
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle("选择导入的JSON文件");
		int ret = fileChooser.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getAbsolutePath();
			Cache.importComment(path);
		}
	}
	@Override
	public boolean output() {
		// TODO Auto-generated method stub
		boolean pathFlg = true;
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("选择导出路径");
		int ret = fileChooser.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			String outFile = fileChooser.getSelectedFile().getAbsolutePath();
			Cache.outportComment(outFile);
		} else {pathFlg = false;}
		return pathFlg;
	}

}
