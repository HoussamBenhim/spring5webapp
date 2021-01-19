package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting in Bootstrap");
		
		Publisher publisher = new Publisher();
		publisher.setName("SFG");
		publisher.setCity("Agadir");
		publisher.setState("Maroc");
		
		publisherRepository.save(publisher);
		
		
		Author eric = new Author("Eric", "Evans");
		Book firstBook = new Book("BlablaTitle", "1235646");
		
		eric.getBooks().add(firstBook);
		firstBook.getAuthors().add(eric);
		firstBook.setPublisher(publisher);
		publisher.getBooks().add(firstBook);
		
		authorRepository.save(eric);
		bookRepository.save(firstBook);
		publisherRepository.save(publisher);
		
		Author eric2 = new Author("Eric2", "Evans2");
		Book firstBook2 = new Book("BlablaTitle2", "12356d1246");
		
		
		eric2.getBooks().add(firstBook2);
		firstBook2.getAuthors().add(eric2);
		firstBook2.setPublisher(publisher);
		publisher.getBooks().add(firstBook2);
		
		authorRepository.save(eric2);
		bookRepository.save(firstBook2);
		publisherRepository.save(publisher);
		
		
		System.out.println("stat from Bootstrap");
		System.out.println("number of regestred book " + bookRepository.count());
		System.out.println("publisher number of book :" +  publisher.getBooks().size());
	}

	
	
	
}
