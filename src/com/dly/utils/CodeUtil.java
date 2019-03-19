package com.dly.utils;

import com.sun.prism.paint.Color;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CodeUtil {
    private  static  int width = 90;//图片宽度
    private static  int height = 35;//图片高度
    private static int codeCount = 5;
    private  static  int xx = 14;
    private  static  int fontHeight = 25;
    private  static  int codeY = 30;
    private  static  char[] codeSequence = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    /*map<code,image>
    * */
    public  static Map<String,Object> generateCodeAndPic(){
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics gd = bufferedImage.getGraphics();
        Random random = new Random();
        gd.setColor(java.awt.Color.WHITE);
        gd.fillRect(0,0,width,height);
        //字体，大小，自适应图片
        Font font = new Font("Fixedsys",Font.BOLD,fontHeight);
        gd.setFont(font);

        //画边框
        gd.setColor(java.awt.Color.BLACK);
        gd.drawRect(0,0,width-1,height-1);
        //产生干扰线
        gd.setColor(java.awt.Color.BLACK);
        for(int i = 0;i<50;i++){
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            gd.drawLine(x,y,x+x1,y+y1);
        }
        //保存随机码，登录后验证
        StringBuffer randomCode = new StringBuffer();
        //用于设置不同颜色的字体
        int red = 0,green = 0, blue = 0;
        //随机产生数字验证码
        for (int i = 0;i<codeCount;i++){
            //产生随机的数字
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            //绘制字体颜色
            gd.setColor(new java.awt.Color(red,green,blue));
            gd.drawString(code,(i+1)*xx,codeY);
            //组合随机数
            randomCode.append(code);
            System.out.println("code:"+code);


        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",randomCode);
        map.put("codePic",bufferedImage);
        return map;


    }
    public  static void  main(String[] args){
        try {
            OutputStream out = new FileOutputStream("E://codeImg/"+System.currentTimeMillis()+".jpg");
            Map<String,Object> map = CodeUtil.generateCodeAndPic();
            ImageIO.write((RenderedImage) map.get("codePic"),"jpeg",out);
            //测试
            System.out.println("验证码的值："+map.get("code"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
