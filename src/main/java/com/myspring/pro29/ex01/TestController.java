package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST 방식으로 사용하기 위해서는 스프링 프레임워크 버전을 pom에서 4.1.1로 변경
//@RestController
@RequestMapping("/test/*")
public class TestController {
	
	  static Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/hi")
	public String hi() {
		return "hahahahahahahahaha";
	}

	  @RequestMapping("/member")
	  public MemberVO member() {
	    MemberVO vo = new MemberVO();
	    vo.setId("hong");
	    vo.setPwd("1234");
	    vo.setName("홍길동");
	    vo.setEmail("hong@test.com");
	    return vo;
	  } 
	  
	  @RequestMapping("/membersList")
	  public List<MemberVO> listMembers () {
	    List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
		  MemberVO vo = new MemberVO();
		  vo.setId("hong"+i);
		  vo.setPwd("123"+i);
		  vo.setName("홍길동"+i);
		  vo.setEmail("hong"+i+"@test.com");
		  list.add(vo);
		}
	    return list; 
	  }
	
	  @RequestMapping("/membersMap")
	  public Map<Integer, MemberVO> membersMap() {
	    Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
	    for (int i = 0; i < 10; i++) {
	      MemberVO vo = new MemberVO();
	      vo.setId("hong" + i);
	      vo.setPwd("123"+i);
	      vo.setName("홍길동" + i);
	      vo.setEmail("hong"+i+"@test.com");
	      map.put(i, vo); 
	    }
	    return map; 
	  } 	
	  
	  @RequestMapping(value= "/notice/{num}" , method = RequestMethod.GET)
	  public String notice(@PathVariable(value = "num") String num ) throws Exception {
		  return num;
	  }
	  
	  @RequestMapping(value= "/notice2/{num}" , method = RequestMethod.GET)
	  public int notice2(@PathVariable(value = "num") int num ) throws Exception {
		  return num;
	  }
	  
	  
//	  @RequestMapping(value= "/info", method = RequestMethod.POST)
	  public void modify(@RequestBody MemberVO vo ){
	    logger.info(vo.toString());
	  }
	  
	  
	  //@RestControoler는 별도의 뷰를 제공하지 않은 채 데이터를 전달하므로 전달 과정에서 예외가 발생할 수 있다
	  //예외에 대한 좀 더 세밀한 제어가 필요한 경우 ResponseEntity 클래스를 사용
	  //ResponseEntity에서 HTTP상태코드를 설정하여 전송 가능
	  //앱에서 HTTP상태 코드를 인식 할 수 있는 기능을 이용해 주문 상태나 예외 발생 알림
	  //Extension of HttpEntity that adds an HttpsStatusCode status code.
	  @RequestMapping("/membersList2")
	  public  ResponseEntity<List<MemberVO>> listMembers2() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
		  MemberVO vo = new MemberVO();
		  vo.setId("lee" + i);
		  vo.setPwd("123"+i);
		  vo.setName("이순신" + i);
	      vo.setEmail("lee"+i+"@test.com");
		  list.add(vo);
		}
	    return new ResponseEntity(list,HttpStatus.INTERNAL_SERVER_ERROR);
	  }	
	
	  //ResponseEntity를 이용하면  JSON 뿐 아니라 HTML이나 자바스크립트를 브라우저로 전송할 수 있어 
	  //결과 메시지나 오류 메시지를 전송할 때 편리함
	  @RequestMapping(value = "/res3")
		public ResponseEntity res3() {
			HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		    String message = "<script>";
			message += " alert('새 회원을 등록합니다.');";
			message += " location.href='/pro29/test/membersList2'; ";
			message += " </script>";
			return  new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		
	
	
}



