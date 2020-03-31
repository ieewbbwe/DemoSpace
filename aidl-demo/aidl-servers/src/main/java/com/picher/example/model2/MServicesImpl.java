package com.picher.example.model2;

import android.os.RemoteException;

import com.picher.example.aidl.MServices;
import com.picher.example.aidlbean.Book;

import java.util.ArrayList;
import java.util.List;

public class MServicesImpl extends MServices.Stub {

    @Override
    public String getName() throws RemoteException {
        return "Picher";
    }

    @Override
    public List<Book> getBooks() throws RemoteException {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            books.add(new Book("name" + i));
        }
        return books;
    }
}
