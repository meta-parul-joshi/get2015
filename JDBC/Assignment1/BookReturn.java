import java.sql.Date;

public class BookReturn {

	int memberId;
	int accessionNumber;
	Date issueDate;
	Date returnDate;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(int accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
