import org.example.Book;
import org.example.LibraryHelper;
import org.example.LibraryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryHelperTest {

    @Mock
    public LibraryService service;

    @InjectMocks // replace = kode yang ada di libraryhelper itu bagian servicenya akan dipanggil di bagian public libraryService service
    public LibraryHelper helper;

    @Test
    public void testCountBooks(){

//        LibraryService service = new LibraryService();
        // menggunakan service yg mockita,
//        LibraryService service = Mockito.mock(LibraryService.class);
//        LibraryHelper helper = new LibraryHelper(service);

        // membuat set of book
        List<Book> books = new ArrayList<>();
        books.add(new Book("1", "OOP", "Assifa"));
        books.add(new Book("2", "Java", "Khairu"));

        when(service.getAllBooks()).thenReturn(books);
        Assertions.assertEquals(2, helper.countBooks());
//        Assertions.assertEquals(10, helper.countBooks());
    }

    // -	Memastikan metode void tidak berjalan untuk daftar kosong
    @Test
    public void testSaveEmptyBooks(){
        List <Book> books = new ArrayList<>();

//        LibraryService service = Mockito.mock(LibraryService.class);
//        LibraryHelper helper = new LibraryHelper(service);

        helper.saveBook(books);
        Mockito.verify(service, Mockito.never()).storeData(any());
    }

    // -	Memastikan metode berjalan untuk daftar yang tidak kosong
    @Test
    public void testSaveNotEmptyBooks(){
        List <Book> books = new ArrayList<>();

        books.add(new Book("1", "OOP", "Assifa"));
        books.add(new Book("2", "Java", "Khairu"));

//        LibraryService service = Mockito.mock(LibraryService.class);
//        LibraryHelper helper = new LibraryHelper(service);
        helper.saveBook(books);

        Mockito.verify(service).storeData(books);
    }

    // -	Menggunakan when().thenReturn() unntuk memalsukan data (stub) dan memverifikasi pemanggilan metode (mock)
    @Test
    public void testGetAllBooks() {
        List<Book> books = List.of(new Book("1", "Python", "Nisa"), new Book("2", "Kotlin", "Sifa"));

        // 💡 Memastikan getAllBooks() mengembalikan data palsu
        when(service.getAllBooks()).thenReturn(books);

        // Memanggil metode yang diuji
        int bookCount = helper.countBooks();

        // Memastikan jumlah buku sesuai dengan data mock
        Mockito.verify(service, times(1)).getAllBooks(); //Memeriksa apakah metode getAllBooks() dipanggil tepat satu kali
    }

    // -	Menggunakan doNothing().when() agar metode void tidak berjalan

    @Test
    public void testStoreData_ShouldNotExecute() {
        List<Book> books = List.of(new Book("1", "OOP", "Assifa"));

        // 💡 Memastikan storeData() tidak benar-benar berjalan
        doNothing().when(service).storeData(anyList());

        // Memanggil metode yang diuji
        helper.saveBook(books);

        // Memverifikasi bahwa metode storeData() dipanggil, tapi tidak melakukan operasi nyata
        verify(service, times(1)).storeData(books);
    }
}

