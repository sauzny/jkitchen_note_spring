<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.awt.*"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%
		//response.reset(); // 可能会影响session，使每次都会重新创建session
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		ServletOutputStream sos = response.getOutputStream();		
		int width = 150, height = 35;
		BufferedImage buffImg=new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g=buffImg.createGraphics();
        
        //创建一个随机数生成器类。
        Random random=new Random();        
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);
        
        //创建字体，字体的大小应该根据图片的高度来定。
        Font font=new Font("Times New Roman",Font.PLAIN,24);
        //设置字体。
        g.setFont(font);
        
        //画边框。
        g.setColor(Color.BLACK);
        g.drawRect(0,0,width-1,height-1);
        
        //随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
        g.setColor(Color.GRAY);
        for (int i=0;i<10;i++)
        {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x,y,x+xl,y+yl);
        }
        
        
        //randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode=new StringBuffer();
        int red=0,green=0,blue=0;
        
        //随机产生6位数字的验证码。
        for (int i=0;i<6;i++)
        {
            //得到随机产生的验证码数字。
            String strRand=String.valueOf(random.nextInt(10));
            
            //产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red=random.nextInt(200);
            green=random.nextInt(200);
            blue=random.nextInt(200);          
            
            //产生随机高度 16至height之间
            float imght = 0;
            while(imght<=16){
             imght = Float.parseFloat(String.valueOf(random.nextInt(height)));
            }
            //用随机产生的颜色将验证码绘制到图像中。
            g.setColor(new Color(red,green,blue));
            g.drawString(strRand,24*i+6,imght);            
            
            //将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
     	 //将四位数字的验证码保存到Session中。
     	
     	request.getSession().setAttribute("CAPTCHA",randomCode.toString());
       
        //禁止图像缓存。

        response.setContentType("image/jpeg");
        
        //将图像输出到Servlet输出流中。
    
        javax.imageio.ImageIO.write(buffImg, "jpeg",sos);
        sos.close();

        //weblogic 不支持
		out.clear();
		out = pageContext.pushBody();

%>

<%!
Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
 %>
