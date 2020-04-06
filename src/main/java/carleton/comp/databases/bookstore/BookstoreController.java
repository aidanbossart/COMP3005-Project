package carleton.comp.databases.bookstore;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    public static JSONArray convertToJSONArray(ResultSet resultSet) throws Exception
    {
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
    

    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/books/by/title", method=RequestMethod.GET)
    public String getBooksTitle(@RequestParam String search)
    {
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
			//Get Course 
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * "+
            "from book "+
            "where UPPER(book_name) LIKE "+
            "UPPER('%"+search+"%') "
            );
            JSONArray bookArray = convertToJSONArray(resultSet);
            return bookArray.toString();
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
            return "";
        }        
    }

    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/books/all", method=RequestMethod.GET)
    public String getAllBooks()
    {
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * "+
            "from book"
            );
            JSONArray bookArray = convertToJSONArray(resultSet);
            return bookArray.toString();
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
            return "";
        }
    }

    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/books/by/isbn", method=RequestMethod.GET)
    public String getBooksISBN(@RequestParam String search)
    {
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
			//Get Course 
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * "+
            "from book "+
            "where UPPER(isbn) LIKE "+
            "UPPER('%"+search+"%') "
            );
            JSONArray bookArray = convertToJSONArray(resultSet);
            return bookArray.toString();
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
            return "";
        }        
    }

    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/authenticate", method=RequestMethod.POST)
    public String authenticate(@RequestBody String body)
    {
        JSONObject result = new JSONObject(body);
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
            ResultSet resultSet;
            resultSet = statement.executeQuery("select case when exists (select * from bookstore_user where username = '"+result.getString("username")+"' and password = '"+result.getString("password")+"') then cast(1 as bit) else cast(0 as bit) end");
            resultSet.next();
            if(resultSet.getBoolean(1) == true)
            {
                return "{\"authenticated\": \"true\"}";
            }
            else
            {
                return "{\"authenticated\": \"false\"}";
            }
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
            return "";
        }
    }

    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/addtocart", method=RequestMethod.POST)
    public String addToCart(@RequestBody String body)
    {
        JSONObject result = new JSONObject(body);
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
            ResultSet resultSet;
            resultSet = statement.executeQuery("select case when exists (select * from bookstore_user where username = '"+result.getString("username")+"' and password = '"+result.getString("password")+"') then cast(1 as bit) else cast(0 as bit) end");
            resultSet.next();
            if(resultSet.getBoolean(1) == true)
            {
                return "{\"authenticated\": \"true\"}";
            }
            else
            {
                return "{\"authenticated\": \"false\"}";
            }
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
            return "";
        }
    }
    
}