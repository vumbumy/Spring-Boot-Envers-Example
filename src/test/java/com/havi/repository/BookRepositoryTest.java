package com.havi.repository;

import com.havi.domain.Book;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(BookRepositoryTest.class);

    @Autowired
    BookRepository bookRepository;

    @Test
    public void findRevisions() {
        Book book = bookRepository.save(
                Book.builder()
                        .title("A")
                        .build()
        );

        book.setTitle("B");

        bookRepository.save(book);

        Revisions<Integer, Book> boolRevisions = bookRepository.findRevisions(book.getId());
        boolRevisions.forEach(integerBookRevision -> LOG.info("{}", integerBookRevision.getEntity()));

        assertEquals(
                boolRevisions.getContent().size(), 2
        );
    }
}