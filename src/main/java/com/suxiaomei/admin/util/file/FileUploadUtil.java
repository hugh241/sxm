package com.suxiaomei.admin.util.file;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import com.suxiaomei.admin.util.Util;

public class FileUploadUtil {

	public static void saveImg(MultipartFile file,String path,String fileName){
        File pathFile = new File(path);  
        if(!pathFile.exists()){
        	pathFile.mkdirs();  
        }
        File targetFile = new File(path,fileName);
        //保存  
        try {
            file.transferTo(targetFile);  
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void deleteImg(String ORIGINNAL,String MOBILE,String PC){
        File file1 = new File(ORIGINNAL);  
        if(file1.exists()){
        	file1.delete();
        }
        File file2 = new File(MOBILE);  
        if(file2.exists()){
        	file2.delete();
        }
        File file3 = new File(PC);  
        if(file3.exists()){
        	file3.delete();
        }
	}
	
	public static String _saveImg(MultipartFile file,String currentDate,String ORIGINNAL,String PC,String MOBILE){
		String fileName = new Date().getTime()+Util.getRandom()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
        //保存 并返回
        saveImg(file,ORIGINNAL+currentDate,fileName);
        try {
        	zipImageFile(ORIGINNAL+currentDate,PC+currentDate, 800,fileName,1f);
        	zipImageFile(ORIGINNAL+currentDate,MOBILE+currentDate, 640,fileName,1f);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return currentDate+"/"+fileName;
	}
	
	/**
     * 直接指定压缩后的宽高：
     * (先保存原文件，再压缩、上传)
     * 壹拍项目中用于二维码压缩
     * @param oldFile 要进行压缩的文件全路径
     * @param width 压缩后的宽度
     * @param height 压缩后的高度
     * @param quality 压缩质量
     * @param smallIcon 文件名的小小后缀(注意，非文件后缀名称),入压缩文件名是yasuo.jpg,则压缩后文件名是yasuo(+smallIcon).jpg
     * @return 返回压缩后的文件的全路径
     * String type, int width, int height, String newname, String currentDate
     * String oldFile, int width,float quality, String smallIcon
     */
    public static String zipImageFile(String oPath,String realPath,int width, String newname,float quality) {
    	String oldFile = oPath+"/"+newname;
        File pathFile = new File(realPath);  
        if(!pathFile.exists()){
        	pathFile.mkdirs();  
        }
        String newpath = null;
        try {
            /**对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(new File(oldFile));
            int oldWidth = srcFile.getWidth(null);
            int oldHeight = srcFile.getHeight(null);
            int height = (int) Math.floor(((double)oldHeight/oldWidth)*width);
            
            /**宽,高设定 */
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
            /**压缩后的文件名 */
            newpath = realPath+"/"+newname;
            /** 压缩之后临时存放位置 */
            FileOutputStream out = new FileOutputStream(newpath);
            String formatName = newpath.substring(newpath.lastIndexOf(".") + 1);
            ImageIO.write(tag,formatName, out);
            out.close();
        } catch (Exception e){
        	e.printStackTrace();
        }
        return newpath;
    }
}
