// MServices.aidl
package com.picher.example.aidl;
import com.picher.example.aidlbean.Book;

// Declare any non-default types here with import statements

interface MServices {

   String getName();

    List<Book> getBooks();
}
