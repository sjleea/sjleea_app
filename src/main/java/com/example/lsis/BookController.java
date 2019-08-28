package com.example.lsis;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;
    public BookController(BookRepository repository){
        bookRepository = repository;
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> find(@PathVariable Long id){
        Optional<Book> book = bookRepository.findById(id);
        ResponseEntity<Book> entity = null;
        if(book != null){
            entity = new ResponseEntity(book, HttpStatus.FOUND);
        }else{
            entity = new ResponseEntity(book, HttpStatus.NOT_FOUND);
        }
        return entity;
    }

    @GetMapping
    public ResponseEntity<List<Book>>  list(){
        return new ResponseEntity(bookRepository.findAll(),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public String save(@RequestBody Book book){
        bookRepository.save(book);
        return "Book "+book+" added";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id)
    {
        Optional<Book> book = bookRepository.findById(id);
        ResponseEntity<Book> entity = null;

        if(book != null){
            bookRepository.delete(book.get());

            return "Book" + id + " deleted";
        }else{
            return "Book" + id + " not found";
        }
    }
}
