package com.myspring.pro29.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


//컨트롤러에서 @RestControoler를 이용하면 메서드에서 요청한 url로 요청화면  JSP를 통해 뷰리졸버로 리턴 후 브라우전에 결과 표시
//하지만 그냥 @Controllerd로 하고 특정 메서드에서 @ResponseBody를 적용하면 JSP가 아닌 텍스트나 JSON으로 결과 전송할 수 있다 암기 * X 100
//@Controller
public class ResController {
	@RequestMapping(value = "/res1")
	@ResponseBody
	//Annotation that indicates a method return value should be bound to the 
	//webresponse body. Supported for annotated handler methods in Servlet environments. 
	//ResponseBody 형태로하면 좀더 간단하게 결과값을 확인 할 수 있다
	public Map<String, Object> res1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hong");
		map.put("name", "홍길동");
		return map;
	}
	
	
	@RequestMapping(value = "/res2")
	public ModelAndView res2() {
		return new ModelAndView("home");
	}
	
}
