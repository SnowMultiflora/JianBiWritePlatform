<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.*"%>
<%@page import="java.awt.*"%>
<%@ page language="java" contentType="image/jpeg" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码</title>
</head>
<body>
	<%!//生成颜色
	public Color getColor() {
		Random random = new Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return new Color(r, g, b);
	}

	//生成数字
	public String getNum() {
		int random = (int) (Math.random() * 9000) + 1000; //生成1000-10000之间的
		return String.valueOf(random); //将数字转为字符
	}%>
	<%
		//禁用浏览器缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);
		//设置验证码图片大小
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//创建画笔
		Graphics graphics = image.getGraphics();
		//生成图片背景色
		graphics.fillRect(0, 0, 80, 30);
		//生成干扰字段
		for (int i = 0; i < 30; i++) {
			Random random = new Random();
			int xBegin = random.nextInt(80);
			int yBegin = random.nextInt(30);
			int xEnd = random.nextInt(xBegin + 10);
			int yEnd = random.nextInt(yBegin + 10);
			graphics.setColor(getColor());
			graphics.drawLine(xBegin, yBegin, xEnd, yEnd);
		}
		//设置字体
		graphics.setFont(new Font("strif", Font.BOLD, 18));
		graphics.setColor(Color.BLACK);
		//获得验证码
		String number = getNum();
		//在验证码之间增加空格
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < number.length(); i++) {
			stringBuffer.append(number.charAt(i) + " ");
		}
		//从15,20坐标开始
		graphics.drawString(stringBuffer.toString(), 15, 20);
		session.setAttribute("NUMBER", number);
		//将验证码绘制成jpeg格式
		ImageIO.write(image, "jpeg", response.getOutputStream());
		out.clear();
		//验证码会被其他页面所引用
		out = pageContext.pushBody();
	%>
</body>
</html>
