package edu.neu.dao;

import edu.neu.pojo.Books;

import java.util.List;

public interface BooksMapper {

    int addBook(Books books);

    int deleteBook(int id);

    int updateBook(Books books);

    Books  queryBookById(int id);

    List<Books> queryAllBooks();
}
