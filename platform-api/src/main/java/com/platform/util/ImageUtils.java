package com.platform.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO; 

public class ImageUtils {
	
	/**
     * 图片覆盖（覆盖图压缩到width*height大小，覆盖到底图上）
     *
     * @param baseFilePath 底图
     * @param coverFilePath 覆盖图
     * @param x 起始x轴
     * @param y 起始y轴
     * @param width 覆盖宽度
     * @param height 覆盖长度度
     * @return
     * @throws Exception
     */
    public static String coverImage(String base, String imgIn, int x, int y, int width, int height, String codeUrl) throws Exception{
    	
        //原图
        BufferedImage buffImg = ImageIO.read(new FileInputStream(base));
        //覆盖层
        BufferedImage coverImg = ImageIO.read(new URL(imgIn));
         
        buffImg = coverImage(buffImg, coverImg, x, y, width, height);
		
        ImageIO.write(buffImg, "png", new File(codeUrl));
        
        return codeUrl;
    }
    
    
    public static String coverImage(String base, BufferedImage imgIn, int x, int y, int width, int height, String codeUrl) throws Exception{
    	
    	//原图
        BufferedImage buffImg = ImageIO.read(new FileInputStream(base));
        //覆盖层
        BufferedImage coverImg = imgIn;
         
        buffImg = coverImage(buffImg, coverImg, x, y, width, height);
		
        ImageIO.write(buffImg, "png", new File(codeUrl));
        
        return codeUrl;
    }
    
    /**
     * 图片覆盖（覆盖图压缩到width*height大小，覆盖到底图上）
     *
     * @param baseBufferedImage 底图
     * @param coverBufferedImage 覆盖图
     * @param x 起始x轴
     * @param y 起始y轴
     * @param width 覆盖宽度
     * @param height 覆盖长度度
     * @return
     * @throws Exception
     */
    public static BufferedImage coverImage(BufferedImage baseBufferedImage, BufferedImage coverBufferedImage, int x, int y, int width, int height) throws Exception{
         
        // 创建Graphics2D对象，用在底图对象上绘图
        Graphics2D g2d = baseBufferedImage.createGraphics();
         
        // 绘制
        g2d.drawImage(coverBufferedImage, x, y, width, height, null);
        g2d.dispose();// 释放图形上下文使用的系统资源
         
        return baseBufferedImage;
    }
    
    /**
     * 绘制文字
     * @param base
     * @param text
     * @param x
     * @param y
     * @param codeUrl
     * @return
     * @throws Exception
     */
    public static String coverText(String base, int x, int y, String codeUrl, AttributedString as) throws Exception{
    	
    	//原图
        BufferedImage buffImg = ImageIO.read(new FileInputStream(base));
        
        // 创建Graphics2D对象，用在底图对象上绘图
        Graphics2D g2d = buffImg.createGraphics();
        // 绘制
        g2d.drawString(as.getIterator(), x, y);
        g2d.dispose();// 释放图形上下文使用的系统资源
		
        ImageIO.write(buffImg, "png", new File(codeUrl));
        
        return codeUrl;
    }
    
    /**
     * 绘制文字
     * @param base
     * @param text
     * @param x
     * @param y
     * @param codeUrl
     * @return
     * @throws Exception
     */
    public static String coverText(String base, String text, int x, int y, String codeUrl, Font f, Color c) throws Exception{
    	
    	//原图
        BufferedImage buffImg = ImageIO.read(new FileInputStream(base));
        
        // 创建Graphics2D对象，用在底图对象上绘图
        Graphics2D g2d = buffImg.createGraphics();
        g2d.setColor(c);
        g2d.setFont(f);
        // 绘制
        g2d.drawString(text, x, y);
        g2d.dispose();// 释放图形上下文使用的系统资源
		
        ImageIO.write(buffImg, "png", new File(codeUrl));
        
        return codeUrl;
    }
    
    public static InputStream getImage(String url) {
    	InputStream inputStream = null;
    	try {
    		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream();
            }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
		return inputStream;
    }
    
    
    /**
     * 指定图片宽度和高度和压缩比例对图片进行压缩
     * @param imgsrc   源图片地址
     * @param imgdist  目标图片地址
     * @param widthdist  压缩后图片的宽度
     * @param heightdist 压缩后图片的高度
     * @param rate       压缩的比例
     */
    public static void reduceImg(String imgsrc, String imgdist, Integer widthdist, Integer heightdist, Float rate) {
         
    }
 
    /**
     * 原图大小等比压缩，不改变图片大小，压缩内存
     * @param imgsrc   源图片地址
     * @param imgdist  目标图片地址
     */
    public static void reduceImg(String imgsrc, String imgdist) {
        File srcfile = new File(imgsrc);
        int[] result = getImgWidthHeight(srcfile);
        int width = result[0];
        int height = result[1];
        reduceImg(imgsrc,imgdist,width,height,null);
    }
 
    /**
     * 原图大小等比压缩
     * @param imgsrc   源图片地址
     * @param imgdist  目标图片地址
     * @param rate  压缩比例
     */
    public static void reduceImg(String imgsrc, String imgdist,Float rate){
        reduceImg(imgsrc,imgdist,null,null,rate);
    }
 
    /**
     * 原图大小等比压缩
     * @param imgsrc   源图片地址
     * @param imgdist  目标图片地址
     * @param width  指定宽度
     * @param height  指定高度
     */
    public static void reduceImg(String imgsrc, String imgdist,int width,int height){
        reduceImg(imgsrc,imgdist,width,height,null);
    }
 
    /**
     * 获取图片宽度和高度
     *
     * @param
     * @return 返回图片的宽度
     */
    public static int[] getImgWidthHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = { 0, 0 };
        try {
            // 获得文件输入流
            is = new FileInputStream(file);
            // 从流里将图片写入缓冲图片区
            src = ImageIO.read(is);
            // 得到源图片宽
            result[0] =src.getWidth();
            // 得到源图片高
            result[1] =src.getHeight();
        } catch (Exception ef) {
            ef.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();  //关闭输入流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return result;
    }
    
    public static void main(String[] args) throws IOException {
    	 
        String srcPath = "C:\\Users\\dell\\Desktop\\temp.gif";
        String distPath = "C:\\Users\\dell\\Desktop\\temp\\temp.gif";
 
        File srcfile = new File(srcPath);
        File distfile = new File(distPath);
        System.out.println("原图大小：" + srcfile.length());
        reduceImg(srcPath, distPath,0.5f);
        System.out.println("处理后文件大小：" + distfile.length());
 
    }

}
