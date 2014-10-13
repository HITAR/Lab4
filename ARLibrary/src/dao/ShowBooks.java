package dao;

import infor.Author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.opensymphony.xwork2.ActionContext;

import dao.DBconn;

public class ShowBooks {
	private String isbn;
	private String title;
	private String publisher;
	private String publishdate;
	private String price;
	private String authorID;
	private String age;
	private String country;
	private String name;

	List<Author> lista = new ArrayList<Author>();

	private Connection conn = null;
	private DBconn dao = new DBconn();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	public List<Author> Choose(String na) throws Exception {
		lista = new ArrayList<Author>();
		try {
			conn = dao.GetConn();
			Statement stat = conn.createStatement();
			String sqlStatement = "SELECT book.ISBN AS isbn,book.Title AS title,book.AuthorID AS authorID,book.Publisher AS publisher,book.Publishdate AS publishdate,book.Price AS price,author.Name AS name,author.Age AS age,author.Country AS country FROM book JOIN author  ON author.AuthorID=book.AuthorID  where author.Name ="+ "'" + na + "'";
			ResultSet set = stat.executeQuery(sqlStatement);
			while (set.next()) {
				Author author = new Author();
				author.setTitle(set.getString("title"));   
				author.setAuthorID(set.getString("authorID")); //showDetails()通过authorID查找information，故必须有
				lista.add(author);
			}
			conn.close(); // 关闭数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public List<Author> showDetails(String tit) throws Exception {
		lista = new ArrayList<Author>();
		try {
			conn = dao.GetConn();
			Statement stat = conn.createStatement();
			String sqlStatement = "SELECT book.ISBN AS isbn,book.Title AS title,book.AuthorID AS authorID,book.Publisher AS publisher,book.Publishdate AS publishdate,book.Price AS price,author.Name AS name,author.Age AS age,author.Country AS country FROM book JOIN author  ON author.AuthorID=book.AuthorID  where book.Title="+ "'" + tit + "'";
			ResultSet set = stat.executeQuery(sqlStatement);
			while (set.next()) {
				Author author = new Author();
				author.setName(set.getString("name"));
				author.setCountry(set.getString("country"));
				author.setAge(set.getString("age"));
				author.setAuthorID(set.getString("authorID"));
				author.setIsbn(set.getString("isbn"));
				author.setTitle(set.getString("title"));
				author.setPublisher(set.getString("publisher"));
				author.setPublishdate(set.getString("publishdate"));
				author.setPrice(set.getString("price"));
				lista.add(author);
			}
			conn.close(); // 关闭数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public List<Author> deleteOne(String id) throws Exception {
		lista = new ArrayList<Author>();
		try {
			conn = dao.GetConn();
			Statement stat = conn.createStatement();
			String sqlStatement = "DELETE from book where AuthorID ="+ "'" + id + "'";
			stat.executeUpdate(sqlStatement);
			conn.close(); // 关闭数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Author> addOneBook(String isn,String tit,String id,String pub,String pubdt,String pri)
    {
		lista = new ArrayList<Author>();
		try {
        	conn = dao.GetConn();
			Statement stat = conn.createStatement();
			String sqlStatement = "INSERT into book (ISBN,Title,AuthorID,Publisher,Publishdate,Price) values ('" +isn+ "','"+tit+ "','"+ id+ "','"+pub+ "','"+ pubdt+ "','"+ pri+ "')";
			stat.executeUpdate(sqlStatement);			
			conn.close(); // 关闭数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
    }
	
	public List<Author> addOneAuthor(String id,String na,String ag,String conty)
    {
		lista = new ArrayList<Author>();
		try {
        	conn = dao.GetConn();
			Statement stat = conn.createStatement();
			String sqlStatement = "INSERT into author (AuthorID,Name,Age,Country) values ('" +id+ "','"+na+ "','"+ ag+ "','"+conty+  "')";
			stat.executeUpdate(sqlStatement);			
			conn.close(); // 关闭数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
    }
	
	public List<Author> updateOne(String id,String tit,String pub,String pubdt,String pri) //更新book
    {
		lista = new ArrayList<Author>();
		try {
			conn = dao.GetConn();
			Statement stat = conn.createStatement();
			String sqlStatement = "UPDATE book SET Publisher='"+pub+"',Publishdate='"+pubdt+"',Price='"+pri+"',AuthorID='"+id+"'where Title="+ "'" + tit + "'";
			stat.executeUpdate(sqlStatement);
            conn.close(); // 关闭数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
    }

	public List<Author> queryAuthor(String na) throws Exception {
		lista = new ArrayList<Author>();
		try {
			conn = dao.GetConn();
			Statement stat = conn.createStatement();
			String sqlStatement = "SELECT book.ISBN AS isbn,book.Title AS title,book.AuthorID AS authorID,book.Publisher AS publisher,book.Publishdate AS publishdate,book.Price AS price,author.Name AS name,author.Age AS age,author.Country AS country FROM book JOIN author  ON author.AuthorID=book.AuthorID  where author.Name="+ "'" + na + "'";
			ResultSet set = stat.executeQuery(sqlStatement);
			while (set.next()) {
				Author author = new Author();
				/*author.setName(set.getString("name"));
				author.setCountry(set.getString("country"));
				author.setAge(set.getInt("age"));*/
				author.setAuthorID(set.getString("authorID"));
				lista.add(author);
			}
			conn.close(); // 关闭数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	
	
}