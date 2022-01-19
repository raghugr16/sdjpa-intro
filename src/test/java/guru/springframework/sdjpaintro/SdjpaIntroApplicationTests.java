package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.BookNatural;
import guru.springframework.sdjpaintro.domain.composite.AuthorComposite;
import guru.springframework.sdjpaintro.domain.composite.NameId;
import guru.springframework.sdjpaintro.repositories.AuthorCompositeRepository;
import guru.springframework.sdjpaintro.repositories.BookNaturalRepository;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SdjpaIntroApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookNaturalRepository bookNaturalRepository;

    @Autowired
    AuthorCompositeRepository authorCompositeRepository;

    @Test
    void authorCompositeTest() {
        NameId nameId = new NameId("John", "T");
        AuthorComposite authorComposite = new AuthorComposite();
        authorComposite.setFirstName(nameId.getFirstName());
        authorComposite.setLastName(nameId.getLastName());
        authorComposite.setCountry("US");

        AuthorComposite saved = authorCompositeRepository.save(authorComposite);
        assertThat(saved).isNotNull();

        AuthorComposite fetched = authorCompositeRepository.getById(nameId);
        assertThat(fetched).isNotNull();
    }


    @Test
    void testBookRepository() {
        long count = bookRepository.count();

        assertThat(count).isGreaterThan(0);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void bookNaturalTest() {
        BookNatural bookNatural = new BookNatural();
        bookNatural.setTitle("My Book");
        BookNatural saved = bookNaturalRepository.save(bookNatural);

        BookNatural fetched = bookNaturalRepository.getById(saved.getTitle());
        assertThat(fetched).isNotNull();
    }

}
