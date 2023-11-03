package my.springmvc.controller;

import my.springmvc.model.Book;
import my.springmvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }


    @RequestMapping(path = "/books/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "edit";
    }

    @RequestMapping(path = "books", method = RequestMethod.POST)
    public String saveBook(Book book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public String getAllBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    @RequestMapping(path = "/books/edit/{id}", method = RequestMethod.GET)
    public String editBook(Model model, @PathVariable(value = "id") String id){
        model.addAttribute("book", bookRepository.findById(id).get());
        return "edit";
    }

    @RequestMapping(path = "/books/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable(name = "id") String id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
