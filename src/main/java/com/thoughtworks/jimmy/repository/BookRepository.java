package com.thoughtworks.jimmy.repository;

import com.thoughtworks.jimmy.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {

    public static final Map<String, Book> BOOKS_MAP =
            new HashMap<String, Book>() {
                {
                    put("9780201485677", new Book("9780201485677", "Refactoring", "Martin Fowler", 64.99));
                    put("9780132350884", new Book("9780132350884", "Clean Code", "Robert C. Martin", 35.44));
                    put("9780131429017", new Book("9780131429017", "The Art of UNIX Programming", "Eric S. Raymond", 39.99));
                }
            };

    public Iterable<Book> findAll() {
        return BOOKS_MAP.values();
    }

    public Book findOne(String isbn) {
        return BOOKS_MAP.get(isbn);
    }

    public Book save(Book book) {
        return BOOKS_MAP.put(book.getIsbn(), book);
    }

    public void delete(String isbn){
        BOOKS_MAP.remove(isbn);
    }

/*    static String book2Json(Map<String, Object> map) {
        if (map.isEmpty())
            return "{}";
        StringBuilder sb = new StringBuilder(map.size() << 4);
        sb.append('{');
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Object value = map.get(key);
            sb.append('\"');
            sb.append(key);
            sb.append('\"');
            sb.append(':');
            sb.append(toJson(value));
            sb.append(',');
        }
        // 将最后的 ',' 变为 '}':
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }*/

}
