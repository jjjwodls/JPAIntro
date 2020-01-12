package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/userAPI")
public class JPAController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	//Get All JPAUser
	@GetMapping("/JPAUser")
	@ResponseBody
	public List<JPAUser> GetAllUserJPAList(){
		return userRepository.findAll();
	}
	
	//add New User
	@PostMapping("/JPAUser")
	@ResponseBody
	public JPAUser createJPAUser(@Valid @RequestBody JPAUser jpaUser){
		return userRepository.save(jpaUser);
	}
	
	@GetMapping("/JPAUser/{id}")
	@ResponseBody
	public JPAUser getJPAUser(@PathVariable(value="id") Long JPAUserId) {
		//익명 객체를 생성 후 그안에 오버라이딩 메소드 내용을 기재한다.
		return userRepository.findById(JPAUserId).orElseThrow(()->new RuntimeException("id is not valid"));
	}
	
	@PutMapping("/JPAUser/{id}")
	@ResponseBody
	public JPAUser getJPAUser(@PathVariable(value="id") Long JPAUserId,@Valid @RequestBody JPAUser jpaUser) {
		JPAUser user = userRepository.findById(JPAUserId).orElseThrow(()->new RuntimeException("id is not valid"));
		user = JPAUser.builder().userId(JPAUserId).userAge(jpaUser.getUserAge()).userName(jpaUser.getUserName()).build();
//		user.setUserAge(jpaUser.getUserAge());
//		user.setUserName(jpaUser.getUserName());
		return userRepository.save(user);
		
	}
	
	@DeleteMapping("/JPAUser/{id}")
	public ResponseEntity<?> deleteJPAUser(@PathVariable(value="id") Long JPAUserId) {
		userRepository.deleteById(JPAUserId);
		return ResponseEntity.ok().build();
	}
	
}
