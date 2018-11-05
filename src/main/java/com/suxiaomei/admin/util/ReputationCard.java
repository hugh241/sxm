package com.suxiaomei.admin.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.suxiaomei.admin.entity.isoc.IsocCreditCardTemplate;

/**
 * 阿姨名片生成工具类
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年8月13日 下午3:02:32
 */
public class ReputationCard {

	// 水印透明度
	private static float alpha = 1;
	// 图片存储路径
//	private static final String PATH = "C:\\Users\\lenovo\\Desktop\\img\\";

	/**
	 * 创建信誉卡
	 * 
	 * @param name
	 *            名字
	 * @param qrcode
	 *            二维码
	 * @param isocCreditCardTemplate
	 *            信誉卡参数对象
	 * @return
	 */
	public static String createCard(String name, String head, String qrcode, IsocCreditCardTemplate template,String localPath) {
		String currentDate = DateUtil.getCurrentDate();
		String root = localPath+ currentDate;
		File file = new File(root);  
		if(!file.exists()){  
		    file.mkdirs();  
		}
		String uuid = Util.getUUID();
		String path = root + "/" + uuid + ".jpg";
		InputStream is = null;
		OutputStream os = null;
		try {
			String localUrl = (localPath + template.getUrl()).replaceAll("\\/", "\\\\\\\\");
			// 源图片-模版地址
			Image srcImg = ImageIO.read(new File(localUrl));
			int imgwidth = srcImg.getWidth(null);
			System.out.println("图片宽度" + srcImg.getWidth(null));
			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
			// 得到画笔对象
			Graphics2D g = buffImg.createGraphics();
			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
			/* 有名字 */
			if (template.getHasname() == 1) {
				String[] colorArr = template.getNamecolor().split(",");
				// 设置名字文字颜色
				g.setColor(new Color(Util.IntValueOf(colorArr[0]), Util.IntValueOf(colorArr[1]), Util.IntValueOf(colorArr[2])));
				// 设置名字文字Font
				g.setFont(new Font(template.getNamefontfamily(), Font.BOLD, template.getNamefontsize()));
				// 设置名字文字透明度
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
				// 第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
				if (template.getNamepositiontype() == 1) {// 左对齐
					g.drawString(name, 0, template.getNametop());// 名字显示位置
				} else if (template.getNamepositiontype() == 2) { // 居中对齐
					int w = name.length() * template.getNamefontsize();
					g.drawString(name, (imgwidth - w) / 2, template.getNametop());// 名字显示位置
				} else if (template.getNamepositiontype() == 3) { // 右对齐
					int w = name.length() * template.getNamefontsize();
					g.drawString(name, imgwidth - w, template.getNametop());// 名字显示位置
				} else { // 其他情况按照实际参数放置
					g.drawString(name, template.getNameleft(), template.getNametop());// 名字显示位置
				}
			}

			/* 有没有头像 */
			if (template.getHashead() == 1) {
				// 水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
				ImageIcon imgIcon = getImageIcon(template.getHeadwidth(), template.getHeadheight(), new ImageIcon(getByteByCode(head)));
				// 得到Image对象。
				Image img = imgIcon.getImage();
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
				// 水印图片的位置
				if (template.getHeadpositiontype() == 1) {// 左对齐
					g.drawImage(img, 0, template.getHeadtop(), null);
				} else if (template.getHeadpositiontype() == 2) { // 居中对齐
					int w = img.getWidth(null);
					g.drawImage(img, (imgwidth - w) / 2, template.getHeadtop(), null);
				} else if (template.getHeadpositiontype() == 3) { // 右对齐
					int w = img.getWidth(null);
					g.drawImage(img, imgwidth - w, template.getHeadtop(), null);
				} else { // 其他情况按照实际参数放置
					g.drawImage(img, template.getHeadleft(), template.getHeadtop(), null);
				}
			}

			/* 有没有二维码 */
			if (template.getHasqrcode() == 1 && qrcode != null && !"".equals(qrcode)) {
				// 水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
				ImageIcon imgIcon = getImageIcon(template.getQrcodewidth(), template.getQrcodeheight(), new ImageIcon(getByteByCode(qrcode)));
				// 得到Image对象。
				Image img = imgIcon.getImage();
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
				// 水印图片的位置
				if (template.getQrcodepositiontype() == 1) {// 左对齐
					g.drawImage(img, 0, template.getQrcodetop(), null);
				} else if (template.getQrcodepositiontype() == 2) { // 居中对齐
					int w = img.getWidth(null);
					g.drawImage(img, (imgwidth - w) / 2, template.getQrcodetop(), null);
				} else if (template.getQrcodepositiontype() == 3) { // 右对齐
					int w = img.getWidth(null);
					g.drawImage(img, imgwidth - w, template.getQrcodetop(), null);
				} else { // 其他情况按照实际参数放置
					g.drawImage(img, template.getQrcodeleft(), template.getQrcodetop(), null);
				}
			}

			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); // 渲染
			g.dispose();// 释放资源
			os = new FileOutputStream(path);// 生成图片
			ImageIO.write(buffImg, "JPG", os);
			System.out.println("图片完成添加水印文字");
			return currentDate+ "/" + uuid + ".jpg";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			try {
				if (null != is)
					is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (null != os)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static ImageIcon getImageIcon(int width, int height, ImageIcon imageIcon) {
		if (width == 0 || height == 0) {
			return imageIcon;
		}
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return imageIcon;
	}

	/**
	 * 将网络图片处理成二进制的形式
	 * 
	 * @param url
	 * @return
	 */
	public static byte[] getByteByCode(String url) {
		try {
			URL u = new URL(url);
			// 打开链接
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			// 设置请求方式为"GET"
			conn.setRequestMethod("GET");
			// 超时响应时间为5秒
			conn.setConnectTimeout(5 * 1000);
			// 通过输入流获取图片数据
			InputStream inStream = conn.getInputStream();
			// 得到图片的二进制数据，以二进制封装得到数据，具有通用性
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			// 创建一个Buffer字符串
			byte[] buffer = new byte[1024];
			// 每次读取的字符串长度，如果为-1，代表全部读取完毕
			int len = 0;
			// 使用一个输入流从buffer里把数据读取出来
			while ((len = inStream.read(buffer)) != -1) {
				// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
				outStream.write(buffer, 0, len);
			}
			// 关闭输入流
			inStream.close();
			// 把outStream里的数据写入内存
			return outStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
//		IsocCreditCardTemplate template = new IsocCreditCardTemplate(1, 1, 2, "测试1", "zj-1.png", 1, 2, 750, 300, "楷体", 60, "255,255,255", 1, 2, 300, 300, 350, 200, 0, 2, 300, 300, 200,0, 1, "", "", 1);
//		IsocCreditCardTemplate template = new IsocCreditCardTemplate(1, 1, 2, "测试1", "zj-2.png", 0, 2, 750, 300, "楷体", 60, "255,255,255", 0, 2, 300, 300, 350, 200, 1, 2, 300, 300, 200,
//				0, 1, "", "", 1);
//		ReputationCard.createCard("李建波", "http://imgmobile.mssxm.com/head.jpg", "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQFE8TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyb3RmOHA5RVdjTW0xMDAwMDAwNzAAAgQ_nRRbAwQAAAAA", template);
	
//		String path = "/sxmback2.0/api/employee/getCreditCard";
//		System.out.println(path.replaceAll("\\/", "\\\\\\\\"));
	}
}
