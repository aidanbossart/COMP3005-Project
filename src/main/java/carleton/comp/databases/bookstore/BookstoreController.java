package carleton.comp.databases.bookstore;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookstoreController
{
    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/books", method=RequestMethod.GET)
    public String getBooks(@RequestParam String param) {
        // JDBC code goes here. Return json of books in string form.
        return "json";
    }
    
}