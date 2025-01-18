package rest.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("/{id}")
    public EntityModel<Book> getBook(@PathVariable Long id) {
        // In a real-world scenario, you'd fetch the book from a database.
        Book book = new Book("Effective Java", "Joshua Bloch", 50.00);

        // Create HATEOAS links
        Link selfLink = linkTo(methodOn(BookController.class).getBook(id)).withSelfRel();
        Link authorLink = linkTo(methodOn(BookController.class).getAuthorDetails(id)).withRel("author");
        Link buyLink = linkTo(methodOn(BookController.class).buyBook(id)).withRel("buy");

        // Return the book with the HATEOAS links
        return EntityModel.of(book, selfLink, authorLink, buyLink);
    }

    @GetMapping("/{id}/authors")
    public String getAuthorDetails(@PathVariable Long id) {
        // In a real-world scenario, you'd fetch the author details.
        return "Author details for book with id: " + id;
    }

    @GetMapping("/{id}/buy")
    public String buyBook(@PathVariable Long id) {
        // Logic for buying a book can be implemented here.
        return "Book purchased with id: " + id;
    }
}
