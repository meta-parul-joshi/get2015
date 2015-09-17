import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibraryInformationSystemHelper 
{	
	/* Function select books published by author and store them in list.
	 * It takes authorName as key parameter.
	 * It returns list of books.*/
	List<Title> booksPublishedByAuthor(String authorName) 
	{
		List<Title> titleList=new ArrayList<Title>();
		String query = " SELECT t.* FROM titles t  "
				+ " INNER JOIN title_author ta ON ta.title_id = t.title_id INNER JOIN author a ON "
				+ " a.author_id = ta.author_id WHERE author_name = '"
				+ authorName + "' ";		
		ResultSet rs = null;
		Statement stmt = null;
		
		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next())
			{
				Title t=new Title();
				t.setTitleId(Integer.parseInt(rs.getString(1)));
				t.setTitleName(rs.getString(2));
				t.setSubjectId(Integer.parseInt(rs.getString(3)));
				t.setPublisherId(Integer.parseInt(rs.getString(4)));
				titleList.add(t);
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

		return titleList;
	}
	
	/*Function checks book issued to member or not
	 * It takes bookName and member name as key parameter.
	 * It return a flag that implies book issued or not.*/
	public boolean bookIssuedOrNot(String bookName,String memberName)
	{
		boolean flag = false;
		String query ="SELECT accession_number FROM book WHERE title_Id = (SELECT title_Id FROM titles WHERE title_name = '" + bookName + "' ) " ;
		ResultSet rs = null;
		Statement stmt = null;
		
		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) 
			{
				int accessionNumber= 0;
				accessionNumber = Integer.parseInt(rs.getString(1));
				int id = getIdOfMember(memberName);
				if(id != 0 && accessionNumber != 0)
				{
					issueBookToMember(accessionNumber, id);
					flag = true;
				}
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

		return flag;
	}
	
	/*Function issues book to member.
	 * It takes accessionNumber and id as key parameter.*/
	private void issueBookToMember(int accessionNumber,int id) 
	{
		String query = "INSERT INTO book_issue( accession_number , member_Id ) VALUES ( " + accessionNumber
				+ " , " + id + " ) ";

		Statement stmt = null;
		
		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
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

	/*Function to get member id of existing member.
	 * It take memberName as parameter.*/
	private int getIdOfMember(String memberName)
	{
		int id = 0;
		String query = "SELECT member_Id FROM Members WHERE member_name = '"+memberName+"'";
		ResultSet rs = null;
		Statement stmt = null;
		
		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();
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

	/*Function to remove books from library which are not issued since last one year.
	 * it return number of books deleted.*/
	public int removeBooksFromThatAreNotIssuedSinceLasttYear() 
	{
		int count = 0;
		String query = "DELETE b FROM book b LEFT JOIN book_issue bi  ON b.accession_number = bi.accession_number "
				+"WHERE ( DATEDIFF(NOW(),issue_date)>=365 OR (b.accession_number NOT IN(SELECT accession_number from book_issue) AND (status !=0)))";

		Statement stmt = null;
		
		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			count = stmt.executeUpdate(query);
			System.out.println("Count "+ count);
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
		return count;
	}
}
