package team.group7.scm.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import team.group7.scm.Cache.Cache;
import team.group7.scm.bean.Tag;
import team.group7.scm.service.GraphService;
import team.group7.scm.service.IOService;
import team.group7.scm.service.Impl.GraphServiceImpl;
import team.group7.scm.service.Impl.IOServiceImpl;

/**
 * ͳ��ͼ
 * @author UUZSAMA
 *
 */
public class MKGraphView extends JFrame {

	GraphService graphService = new GraphServiceImpl();
	private IOService ioService = new IOServiceImpl();
	private static final long serialVersionUID = -2819033294975986692L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MKGraphView() {
		setTitle("\u6570\u636E\u6807\u6CE8\u8F6F\u4EF6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		//new JFreeChartTest();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnNewMenuHome = new JMenu("\u4E3B\u9875");
		menuBar.add(mnNewMenuHome);
		mnNewMenuHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new StartView().setVisible(true);
				dispose();
			}
		});
		
		JMenu mnNewMenuDownload = new JMenu("\u4E0B\u8F7D");
		menuBar.add(mnNewMenuDownload);
		mnNewMenuDownload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MKDownloadView().setVisible(true);
				dispose();
			}
		});
		
		JMenu mnNewMenuIo = new JMenu("\u5BFC\u5165\u5BFC\u51FA");
		menuBar.add(mnNewMenuIo);
		
		JMenu mnNewMenuInput = new JMenu("\u5BFC\u5165");
		mnNewMenuIo.add(mnNewMenuInput);
		
		JMenu mnNewMenuExport = new JMenu("\u5BFC\u51FA");
		mnNewMenuIo.add(mnNewMenuExport);
		mnNewMenuInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ioService.input();
					dispose();
					new MKGraphView().setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenuExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ioService.output();
			}
		});
		JMenu mnNewMenuMark = new JMenu("\u80A1\u8BC4\u6807\u6CE8");
		menuBar.add(mnNewMenuMark);
		mnNewMenuMark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MarkersView().setVisible(true);
				dispose();
			}
		});
		
		JMenu mnNewMenuGraph = new JMenu("\u7EDF\u8BA1");
		menuBar.add(mnNewMenuGraph);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(20, 20, 743, 499);
		JComponent panel1=makeTextPanel("��ͼ");
		tabbedPane.addTab("��ͼ", panel1);
		JComponent panel2=makeTextPanel("��״ͼ");
		tabbedPane.addTab("��״ͼ", panel2);
		contentPane.add(tabbedPane);
		
		
	}
	/**
	 * ͳ��ͼ-���ܴ��޸�
	 * */
	//����һЩ����������ʾͼ����Ҫչʾͼ�����Ĺ���
	private JComponent makeTextPanel(String text){
	    JPanel panel=new JPanel(false);
	    JLabel filler=new JLabel(text);
	    filler.setHorizontalAlignment(JLabel.CENTER);
	    //����������ʽ
	    StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
	    //���ñ�������
	    standardChartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20));
	    //����ͼ��������
	    standardChartTheme.setRegularFont(new Font("����",Font.PLAIN,15));
	    //�������������
	    standardChartTheme.setLargeFont(new Font("����",Font.PLAIN,15));
	    //Ӧ��������ʽ
	    ChartFactory.setChartTheme(standardChartTheme);
	    switch(text) {
	    case "��ͼ":
	    	DefaultPieDataset dfp=new DefaultPieDataset();
	    	
	    	int[][] nums = graphService.getTagResult();
	    	for(int i=0;i<Cache.TAG_LIST.size();++i) {
	    		Tag tag = Cache.TAG_LIST.get(i);
	    		if(nums[i][0]>0)dfp.setValue(tag.getTagName()+":"+tag.getAtt1(), nums[i][0]);
	    		if(nums[i][1]>0)dfp.setValue(tag.getTagName()+":"+tag.getAtt2(), nums[i][1]);
	    		if(nums[i][2]>0)dfp.setValue(tag.getTagName()+":"+tag.getAtt3(), nums[i][2]);
	    	}
		       
		        //Create JFreeChart object
		    JFreeChart a=ChartFactory.createPieChart("����������",dfp, true, true, true);
		    ChartPanel cp = new ChartPanel(a);
		    panel.add(cp);
		    break;
	    case "��״ͼ":
	    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
	    	
	    	int[][] nums2 = graphService.getTagResult();
	    	for(int i=0;i<Cache.TAG_LIST.size();++i) {
	    		Tag tag = Cache.TAG_LIST.get(i);
	    		if(nums2[i][0]>0)dataset.setValue(nums2[i][0],tag.getTagName(),tag.getAtt1());
	    		if(nums2[i][1]>0)dataset.setValue(nums2[i][1],tag.getTagName(),tag.getAtt2());
	    		if(nums2[i][2]>0)dataset.setValue(nums2[i][2],tag.getTagName(),tag.getAtt3());
	    	}           
	    	JFreeChart a1  = ChartFactory.createBarChart3D("�����ע����ͳ��ͼ","","����",dataset, PlotOrientation.VERTICAL,true,true,true);
	    	ChartPanel cp1 = new ChartPanel(a1);
		    panel.add(cp1);
		    break;
        default:break;
	    }
	    panel.add(filler);
	    return panel;
	}
}
