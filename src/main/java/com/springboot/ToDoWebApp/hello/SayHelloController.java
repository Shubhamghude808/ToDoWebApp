package com.springboot.ToDoWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello()
	{
		return "Hello, what are u learing";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHellohtml()
	{
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("<html>");
		sBuffer.append("<head>");
		sBuffer.append("<title>HTML page</title>");
		sBuffer.append("</head>");
		sBuffer.append("<body>");
		sBuffer.append("My First Html page");
		sBuffer.append("</body>");
		sBuffer.append("</html>");
		return sBuffer.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHellojsp()
	{
		return "SayHello";
	}
}
