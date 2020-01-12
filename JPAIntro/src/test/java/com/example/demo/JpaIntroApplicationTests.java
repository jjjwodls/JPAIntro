package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaIntroApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testUserReository() {
		long userId = 150;
		long userAge = 10;
		String userName = "abc";
		
		JPAUser user = JPAUser.builder().userId(userId).userName(userName).userAge(userAge).build();
		userRepository.save(user);

		List<JPAUser> userList = userRepository.findAll();
		JPAUser getUser = userList.get(0);
		assertThat(getUser.getUserName(), is(userName));
		
		List<JPAUser> getUserNameList = userRepository.findByUserName(userName);
		getUser = getUserNameList.get(0);
		assertThat(getUser.getUserName(), is(userName));
		System.out.println(getUser);
		
		//test 데이터 삭제
		userRepository.deleteAll();
	}


}
