package com.example.controller;

import com.example.dto.BookDto;
import com.example.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookViewController {

    private final BookService bookService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book-list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("book", new BookDto());
        return "add-book";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("book") BookDto dto, RedirectAttributes ra) {
        BookDto saved = bookService.create(dto);
        ra.addFlashAttribute("message", "Book added (id=" + saved.getId() + ")");
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "edit-book";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("book") BookDto dto,
                         RedirectAttributes ra) {
        BookDto updated = bookService.update(id, dto);
        ra.addFlashAttribute("message", "Book updated (id=" + updated.getId() + ")");
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {
        bookService.delete(id);
        ra.addFlashAttribute("message", "Book deleted");
        return "redirect:/books";
    }
}
