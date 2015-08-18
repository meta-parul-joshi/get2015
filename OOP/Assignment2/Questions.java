import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Questions {
	String line;
	public List<String> ques()
	{
		List<String> question = new ArrayList<String>();
		try
		{
			//Read from file.
			BufferedReader br=new BufferedReader(new FileReader("C://Users/Parul/workspace/Assignment6/src/Questions.txt"));
			while((line=br.readLine())!=null)
			{
				String[] token=line.split(",");
				question.add(token[0]+" "+token[1]);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception Handled");
		}
		return question;
	}

}
