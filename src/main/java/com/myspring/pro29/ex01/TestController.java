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

//REST ������� ����ϱ� ���ؼ��� ������ �����ӿ�ũ ������ pom���� 4.1.1�� ����
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
	    vo.setName("ȫ�浿");
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
		  vo.setName("ȫ�浿"+i);
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
	      vo.setName("ȫ�浿" + i);
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
	  
	  
	  //@RestControoler�� ������ �並 �������� ���� ä �����͸� �����ϹǷ� ���� �������� ���ܰ� �߻��� �� �ִ�
	  //���ܿ� ���� �� �� ������ ��� �ʿ��� ��� ResponseEntity Ŭ������ ���
	  //ResponseEntity���� HTTP�����ڵ带 �����Ͽ� ���� ����
	  //�ۿ��� HTTP���� �ڵ带 �ν� �� �� �ִ� ����� �̿��� �ֹ� ���³� ���� �߻� �˸�
	  //Extension of HttpEntity that adds an HttpsStatusCode status code.
	  @RequestMapping("/membersList2")
	  public  ResponseEntity<List<MemberVO>> listMembers2() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
		  MemberVO vo = new MemberVO();
		  vo.setId("lee" + i);
		  vo.setPwd("123"+i);
		  vo.setName("�̼���" + i);
	      vo.setEmail("lee"+i+"@test.com");
		  list.add(vo);
		}
	    return new ResponseEntity(list,HttpStatus.INTERNAL_SERVER_ERROR);
	  }	
	
	  //ResponseEntity�� �̿��ϸ�  JSON �� �ƴ϶� HTML�̳� �ڹٽ�ũ��Ʈ�� �������� ������ �� �־� 
	  //��� �޽����� ���� �޽����� ������ �� ����
	  @RequestMapping(value = "/res3")
		public ResponseEntity res3() {
			HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		    String message = "<script>";
			message += " alert('�� ȸ���� ����մϴ�.');";
			message += " location.href='/pro29/test/membersList2'; ";
			message += " </script>";
			return  new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		
	
	
}



