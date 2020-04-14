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
    @RequestMapping(value="/rest/books/by/id", method=RequestMethod.GET)
    public String getBooksId(@RequestParam String id)
    {
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
			//Get Course 
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from book where book_id = '"+id+"'");
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
    @RequestMapping(value="/rest/collections/all", method=RequestMethod.GET)
    public String getAllCollections(@RequestParam String collection)
    {
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * "+
            "from collection"
            );
            JSONArray bookArray = convertToJSONArray(resultSet);
            return bookArray.toString();
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
            return "";
        }
    }

    
    //select * from book join cart on book.book_id = cart.book_id where cart.cart_id = (select distinct cart_id from cart join bookstore_user on cart.u_id = bookstore_user.u_id where bookstore_user.username = 'userone')
    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/cart", method=RequestMethod.GET)
    public String getCart(@RequestParam String username)
    {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from book join cart on book.book_id = cart.book_id where cart.cart_id = (select distinct cart_id from cart join bookstore_user on cart.u_id = bookstore_user.u_id where bookstore_user.username = '"+username+"')");
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
            statement.executeUpdate("insert into cart values ((select distinct cart_id from bookstore_user inner join cart on cart.u_id = bookstore_user.u_id where bookstore_user.username = '"+result.getString("username")+"'), "+result.getInt("book_id")+")");
            resultSet = statement.executeQuery("select * from book join cart on book.book_id = cart.book_id where cart.cart_id = (select distinct cart_id from cart join bookstore_user on cart.u_id = bookstore_user.u_id where bookstore_user.username = '"+result.getString("username")+"')");

            JSONArray cartArray = convertToJSONArray(resultSet);
            return cartArray.toString();
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
            return "";
        }
    }


    //ADMINISTRATOR ONLY FUNCTIONS ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/books/add", method=RequestMethod.POST)
    public void addBook(@RequestParam String book_name, @RequestParam String author_name, @RequestParam String isbn, @RequestParam String genre, @RequestParam String publisher_name, @RequestParam String pagenum, @RequestParam float price, @RequestParam float rating)
    {
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
            ResultSet resultSet;

            int author_id = 0 ; //taking this approach instead of dowhile x_id = 0 because of threat of infinite inserts
            resultSet = statement.executeQuery("SELECT author_id "+"FROM author "+"WHERE "+"'"+author_name+"'"+" = 'author_name'");
            if(resultSet.next()){
                author_id = resultSet.getInt(1);
            }
            
            int publisher_id = 0;
            resultSet = statement.executeQuery("SELECT publisher_id "+"FROM publisher "+"WHERE "+"'"+publisher_name+"'"+" = 'publisher_name'");
            if(resultSet.next()){
                publisher_id = resultSet.getInt(1);
            }
            statement.executeUpdate("INSERT INTO book " + "VALUES (DEFAULT,"+"'"+book_name+"'"+","+"'"+author_id+"'"+","+"'"+isbn+"'"+","+"'"+genre+"'"+","+"'"+publisher_id+"'"+","+"'"+pagenum+"'"+","+"'"+price+"'"+","+"'"+rating+"'"+")");
            
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
        }        
    }

    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/publisher/add", method=RequestMethod.POST)
    public void addNewPublisher(@RequestParam String publisher_name ,@RequestParam String pub_addr,@RequestParam String pub_email,@RequestParam String pub_phone, @RequestParam String pub_banknum)
    {
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
            statement.executeUpdate("INSERT INTO publisher VALUES(DEFAULT,"+"'"+publisher_name+"'"+","+"'"+pub_addr+"'"+","+"'"+pub_email+"'"+","+"'"+pub_phone+"'"+","+"'"+pub_banknum+"'"+")");            
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
        }        
    }

    @CrossOrigin(origins = "*",
    allowedHeaders = "*",
    allowCredentials = "true",
    maxAge = 1000,
    methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    @RequestMapping(value="/rest/add/new/author", method=RequestMethod.POST)
    public void addNewAuthor(@RequestParam String author_name)
    {
        // JDBC code goes here. Return json of books in string form.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "root"); Statement statement = connection.createStatement();)
		{
            statement.executeUpdate("INSERT INTO author VALUES(DEFAULT,"+"'"+author_name+"'"+")");            
		}
		catch (Exception sqle) {
            System.out.println("Exception: " + sqle);
        }        
    }
    
    
}