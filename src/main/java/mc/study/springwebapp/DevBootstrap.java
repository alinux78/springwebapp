package mc.study.springwebapp;

import mc.study.springwebapp.model.Author;
import mc.study.springwebapp.model.Book;
import mc.study.springwebapp.repositories.AuthorRepository;
import mc.study.springwebapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	@Autowired
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	private void initData() {

		Author jd = new Author("Jared", "Diamond");
		Book ggs = new Book("Guns, germs and steel", "1,2,3", "WS");
		jd .getBooks().add(ggs);
		ggs.getAuthors().add(jd);

		authorRepository.save(jd);
		bookRepository.save(ggs);

		Author jkr = new Author("J.K", "Rowling");
		Book hp = new Book("Harry Potter", "1,2,4", "WS");
		jkr .getBooks().add(hp);
		hp.getAuthors().add(jkr);

		authorRepository.save(jkr);
		bookRepository.save(hp);

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}
}
