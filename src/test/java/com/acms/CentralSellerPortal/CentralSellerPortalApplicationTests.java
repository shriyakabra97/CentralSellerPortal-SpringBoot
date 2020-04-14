package com.acms.CentralSellerPortal;

import com.acms.CentralSellerPortal.Entities.Seller;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CentralSellerPortalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CentralSellerPortalApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateUser() {
		Seller seller = new Seller();
		seller.setSellerName("admin");
		seller.setSellerAddress("admn");
		seller.setShopName("admin");
		seller.setSellerContactNo("admin");
		seller.setSellerEmailId("adn");

		ResponseEntity<Seller> postResponse = restTemplate.postForEntity(getRootUrl() + "/seller",seller, Seller.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
}
