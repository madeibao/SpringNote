package edu.neu.service.impl;

import edu.neu.dao.BooksMapper;
import edu.neu.pojo.Books;
import edu.neu.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    private BooksMapper booksMapper;
    public void setBooksMapper(BooksMapper booksMapper){
        this.booksMapper=booksMapper;
    }

    @Override
    public int addBook(Books books) {
        return booksMapper.addBook(books);
    }

    @Override
    public int deleteBook(int id) {
        return booksMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }
}
