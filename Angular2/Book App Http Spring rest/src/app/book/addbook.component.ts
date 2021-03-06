import { Component, OnInit } from '@angular/core';
import { BookService } from './book.service';
import { Book } from './bike';

@Component({
    selector: 'add-book',
    templateUrl: '../book/addbook.html'
})
export class AddBookComponent {
    public newBook = new Book(undefined,'','');
    name = 'Praveen';
    constructor(private bookService: BookService) { }
    createBook(book: Book): void {
        console.dir(book);
        this.bookService.createBook(book);
    }

}