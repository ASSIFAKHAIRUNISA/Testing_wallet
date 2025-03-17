package org.example;

import java.util.List;

public class LibraryHelper {

    private LibraryService service;
    public LibraryHelper(LibraryService service){ // udah hardcode, saat servicenya diubah ke mockito
        this.service = service;
    }

    public int countBooks(){
        List <Book> retrievedBooks = this.service.getAllBooks(); //untuk mengambil daftar buku dari service.getAllBooks() dan mengembalikan jumlah  buku
        return retrievedBooks.size();
    }

    public void saveBook(List<Book> books){
        if (books.size() > 0){
            this.service.storeData(books);
        }
    }
}
