package com.serad.creditnote.creditscoreservice;

import com.serad.creditnote.creditscoreservice.models.Customer;
import com.serad.creditnote.creditscoreservice.repository.CreditScoreRepository;
import com.serad.creditnote.creditscoreservice.service.CreditScoreService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculationServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@MockBean
	CreditScoreRepository creditScoreRepository;

	@Autowired
	CreditScoreService creditScoreService;


	@Test
	public void createCustomerTest() {
		Customer customer = new Customer("1","serhat", "aydın", 440.00, "+905548534052", 600.00);
		when(creditScoreRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, creditScoreRepository.save(customer));
	}

	@Test
	public void getUserByUserName() {
		when(creditScoreRepository.findByTcknEquals("1")).thenReturn(
				new Customer("1","serhat", "aydın", 440.00, "+905548534052", 600.00));
		assertEquals(600.00, creditScoreService.getCustomerCreditScore("1"));
	}

}

