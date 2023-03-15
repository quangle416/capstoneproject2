package org.perscholas.quanglecapstoneproject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.perscholas.quanglecapstoneproject.dao.AccountRepoI;
import org.perscholas.quanglecapstoneproject.dao.NewsLetterRepoI;
import org.perscholas.quanglecapstoneproject.model.Account;
import org.perscholas.quanglecapstoneproject.model.NewsLetter;
import org.perscholas.quanglecapstoneproject.service.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Capstoneproject2ApplicationTests {

	private AccountRepoI accountRepoI;

	private NewsLetterRepoI newsLetterRepoI;

	private NewsLetterService newsLetterService;

	@Autowired
	public Capstoneproject2ApplicationTests(AccountRepoI accountRepoI, NewsLetterRepoI newsLetterRepoI, NewsLetterService newsLetterService) {
		this.accountRepoI = accountRepoI;
		this.newsLetterRepoI = newsLetterRepoI;
		this.newsLetterService = newsLetterService;
	}

	//Test to add
	@Test
	public void testAddAccount() {
		Account addAccount = accountRepoI.save(new Account("Johnny",
														"John",
														"JJohn@gmail.com",
														"password"));
		Assertions.assertThat(addAccount).isNotNull();
	}

	@Test
	public void testAddNewsLetter() {
		NewsLetter addNewEmail = newsLetterRepoI.save(new NewsLetter("Bruno Mars",
																"BMars@gmail.com"));
		Assertions.assertThat(addNewEmail).isNotNull();
	}

	// Test to get information
	@Test
	public void testGetId() {
		Integer newsLetterId = 1;
		Optional<NewsLetter> getId = newsLetterRepoI.findById(newsLetterId);
		Assertions.assertThat(getId).isPresent();
	}

	//Test to check if List gets generated
	@Test
	public void testGetAll() {
		List<NewsLetter> newsLetterList = newsLetterRepoI.findAll();
		Assertions.assertThat(newsLetterList).hasSizeGreaterThan(0);
	}

	//	Test to update an account

	@Test
	public void testUpdate() {

		Integer id = 1;
		Optional<NewsLetter> newsLetter = newsLetterRepoI.findById(id);
		NewsLetter updatedNewsLetter = newsLetter.get();
		updatedNewsLetter.setEmail("quangle123@gmail.com");
		newsLetterRepoI.save(updatedNewsLetter);

		NewsLetter updatedAccount = newsLetterRepoI.findById(id).get();
		Assertions.assertThat(updatedAccount.getEmail()).isEqualTo("quangle123@gmail.com");
	}

	//Test to delete
	@Test
	public void testDeleteId() {
		Integer Id = 3;
		newsLetterRepoI.deleteById(Id);

		Optional<NewsLetter> newsLetterList = newsLetterRepoI.findById(Id);
		Assertions.assertThat(newsLetterList).isNotPresent();
	}
}