package cn.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PictureUtil {
	/**
	 * 生成透明图片
	 * @param width
	 * @param height
	 * @param fontHeight
	 * @param drawStr
	 * @return
	 */
	public static BufferedImage drawTranslucentStringPic(int width, int height, Integer fontHeight,String drawStr)  {  
        try  
        {  
            BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            Graphics2D gd = buffImg.createGraphics();  
            //设置透明  start  
            buffImg = gd.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);  
            gd=buffImg.createGraphics();  
            //设置透明  end  
            gd.setFont(new Font("微软雅黑", Font.PLAIN, fontHeight)); //设置字体  
            gd.setColor(Color.ORANGE); //设置颜色  
            gd.drawRect(0, 0, width - 1, height - 1); //画边框  
            gd.drawString(drawStr, width/2-fontHeight*drawStr.length()/2,fontHeight); //输出文字（中文横向居中）  
            return buffImg;  
        } catch (Exception e) {  
            return null;  
        }  
    }  
      
    public static void main(String[] args){  
        BufferedImage imgMap = drawTranslucentStringPic(400, 80, 36,"测试");  
        File imgFile=new File("D://test.png");  
        try{  
            ImageIO.write(imgMap, "PNG", imgFile);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.out.println("生成完成");  
    }  
}
