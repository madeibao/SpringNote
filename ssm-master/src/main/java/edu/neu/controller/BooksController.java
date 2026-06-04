package edu.neu.controller;

import edu.neu.pojo.Books;
import edu.neu.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {
    @Autowired
    @Qualifier("BooksServiceImpl")
    private BooksService booksService;
    //查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list=booksService.queryAllBooks();
        model.addAttribute("list",list);
        return "allBook";
    }
    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    //增加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){
        booksService.addBook((books));
        return "redirect:/book/allBook";
    }
    //跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model,int id){
        Books book=booksService.queryBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }
    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        booksService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        booksService.deleteBook(id);
        return "redirect:/book/allBook";
    }


}
