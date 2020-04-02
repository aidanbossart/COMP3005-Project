package carleton.comp.databases.bookstore;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

@RestController
public class BookstoreController
{
    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/books", method=RequestMethod.GET)

     
    public static JSONArray convertToJSONArray(ResultSet resultSet)
            throws Exception {
        JSONArray bookArray = new JSONArray();

        while (resultSet.next()) {
            JSONObject rowObj = new JSONObject();
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                rowObj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
            }
            bookArray.put(rowObj);
        }
        return bookArray;
    }
    
    public JSONObject getBooksTitle(String param) {
        JSONObject fullObject = new JSONObject();
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bookstore", "postgres", "root");
            Statement statement = connection.createStatement();
            )
			{
			//Get Course 
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * "+
            "from book "+
            "where book_name LIKE "+
            "'%"+param+"%' " + 
            "OR where book_name LIKE "+"'"+param+"%' "+
            "OR where book_name LIKE "+"'%"+param+"' "+
            "OR where book_name LIKE "+"'"+param+"'"
            );
            JSONArray bookArray = convertToJSONArray(resultSet);
            fullObject.put("bookArray",bookArray);
            System.out.print(fullObject);
			}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
        }        
        return fullObject;
    }

    public JSONObject getAllBooks(String param) {
        JSONObject fullObject = new JSONObject();
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bookstore", "postgres", "root");
            Statement statement = connection.createStatement();
            )
			{
			//Get Course 
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * "+
            "from book"
            );
            JSONArray bookArray = convertToJSONArray(resultSet);
            fullObject.put("bookArray",bookArray);
            System.out.print(fullObject);
			}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
        }        
        return fullObject;
    }
    
}