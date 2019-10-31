package io.vpv.math.problemgenerateor;

import io.vpv.math.problemgenerateor.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProblemGenerateorApplicationTests {

	@Test
	public void contextLoads() {
	}

	protected User getUser() {
		User user = new User();
		user.setEmail("me@you.com");
		user.setFirstName("Testing");
		user.setLastName("User");
		user.setAvatarUrl("https://math.vpv.op");
		user.setProfileUrl("https://me.vpv.io");
		user.setSource("VPV.io");
		user.setId("1234567890");
		return user;
	}
}
