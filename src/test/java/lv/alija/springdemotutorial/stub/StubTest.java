package lv.alija.springdemotutorial.stub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubTest {

    @Test
    public void demoStub(){
        BookRepositoryStub bookRepository = new BookRepositoryStub();

        BookService bookService = new BookService(bookRepository);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(225, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(450, newBooksWithAppliedDiscount.get(1).getPrice());
    }
    @Test
    public void demoStubWithMock(){
        BookRepositoryStub bookRepository = Mockito.mock(BookRepositoryStub.class);

        BookService bookService = new BookService(bookRepository);

        List<Book> newBooks = new ArrayList<>();
        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("5678", "Spring in Action", 400, LocalDate.now());

        newBooks.add(book1);
        newBooks.add(book2);


        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}

