import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class LibraryInformationSystemHelper 
{
	List<Book> bookList=new ArrayList<Book>();
	
	/* execute query using statement*/
	private void booksPublishedByAuthor(String authorName) throws ParseException 
	{		
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Book b=null;
		String query = "select b.* from book b inner join titles t on b.title_id=t.title_id "
							+ "inner join title_author ta on ta.title_id=t.title_id inner join author a on"
								+ " a.author_id=ta.author_id where author_name='"+authorName+"'";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next())
			{
				b=new Book();
				b.setAccessionNumber(Integer.parseInt(rs.getString(1)));
				b.setPrice(Integer.parseInt(rs.getString(2)));
				b.setStatus(rs.getString(3));
				b.setPrice(Integer.parseInt(rs.getString(4)));
				Date startDate= (java.util.Date) df.parse(rs.getString(5));
				b.setPurchaseDate(startDate);	
				bookList.add(b);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		printListOFBooks();
	}
	
	public boolean checkAuthorExist(String authorName) throws ParseException
	{
		boolean authorExist = true;
		String query ="select author_Id From author where author_name = '"+authorName+"'";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()== false)
			{
				authorExist = false;
			}
			else
			{
				booksPublishedByAuthor(authorName);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 	
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
				con.close();
				}
				if (stmt != null) 
				{
				stmt.close();
				}
			} 	
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return authorExist;
	}
	
	private void printListOFBooks()
	{
		for(Book s : bookList)
		{
			System.out.println(s.getAccessionNumber()+"\t"+s.getTitleId()
					+"\t"+s.getPurchaseDate()+"\t"+s.getPrice()+"\t"+s.getStatus());
		}
	}
		
	public boolean bookIssuedOrNot(Members objMembers,String bookName) 
	{
		boolean flag = false;
		addMemberInlibrary(objMembers);	
		int id = getIdOfMember(objMembers);
		int accessionNumber = getAccessionNumberOfBook(bookName); 
		String query = "insert into book_issue(accession_number,member_Id) values ( "+accessionNumber
							+","+id+")";
		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			flag = true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 	
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
					}
				} 	
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		
		return flag;
	}
	
	int getAccessionNumberOfBook(String bookName)
	{
		int accessionNumber= 0;
		String query ="select accession_number From book where title_Id = (Select title_Id from titles where title_name = '"+bookName+"')";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()== false);
			else
			{
				accessionNumber = Integer.parseInt(rs.getString(1));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}		
				
				
		return accessionNumber;
	}
		
	boolean checkBookInLibrary(String bookName)
	{
		boolean bookExist = true;
		String query ="select accession_number From book where title_Id = (Select title_Id from titles where title_name = '"+bookName+"')";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()== false)
			{
				bookExist = false;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return bookExist;
	}
	
	private void addMemberInlibrary(Members objectMembers)
	{
		String query = "insert into Members(member_name,address_line1,address_linr2,category) values ('"
							+objectMembers.getMemberName()+
								"','"+objectMembers.getAddressLine1()
									+"','"+objectMembers.getAddressLine2()+"','"
											+objectMembers.getCategory()+"')";
			
		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 	
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
				}
			} 	
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	private int getIdOfMember(Members objMembers)
	{
		int id = 0;
		String query = "select member_Id from Members where member_name = '"+objMembers.getMemberName()+"'";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) 
			{
				id = Integer.parseInt(rs.getString(1));
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return id;
	}
	
	public void showMembers()
	{
		String query1 = "select * from Members";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);
			while (rs.next()) 
			{
				System.out.println(rs.getString(1) + "\t" + rs.getString(2)+ "\t" +rs.getString(3) + "\t" + rs.getString(4)+ "\t" + rs.getString(5));
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

	
	
	
	
	
	

