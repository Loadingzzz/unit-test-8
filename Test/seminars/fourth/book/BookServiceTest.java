package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;


public class BookServiceTest {
    BookRepository mockBookRepository = mock(BookRepository.class);

    @Test
    public void testGetBookId(){
        BookService bookService = new BookService(mockBookRepository);
        Book book = new Book("1","A","B");
        when(bookService.findBookById("1")).thenReturn(book);
        Book validResult = bookService.findBookById("1");
        assertEquals(book,validResult);
        verify(mockBookRepository,times(1)).findById("1");
    }

    @Test
    public void testFindAllBook(){
        BookService bookService = new BookService(mockBookRepository);
        Book book1 = new Book("12","Gg","Ivan");
        Book book2 = new Book("14","GO AWAY","Ivan");
        Book book3 = new Book("14","GO AWAY","Ivan");
        List<Book> books = List.of(book1,book2,book3);
        when(bookService.findAllBooks()).thenReturn(books);
        List<Book> validResult = bookService.findAllBooks();
        assertEquals(books,validResult);
        verify(mockBookRepository,times(1)).findAll();
    }
}
