package edu.neu.service;

import edu.neu.pojo.Books;

import java.util.List;

public interface BooksService {

    int addBook(Books books);

    int deleteBook(int id);

    int updateBook(Books books);

    Books  queryBookById(int id);

    List<Books> queryAllBooks();
}
