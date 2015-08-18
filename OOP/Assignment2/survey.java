import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class survey 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan =new Scanner(System.in);
		int ch,i=0,numOfParticipant=0,index=0;
		String str[]=new String[3];
		Questions object=new Questions();
		List<String> question=new ArrayList<String>();
		List<Participants> candidate=new ArrayList<Participants>();
		question=object.ques();
		int result;
		double totalA = 0.0, totalB = 0.0, totalC = 0.0, totalD = 0.0;
		do 
		{
			System.out.println("Menu");
			System.out.println("1.Take survey");
			System.out.println("2.View Statistics");
			System.out.println("3.View people and answers");
			System.out.println("4. to Exit");
		
			ch = Utility.GetInput("Enter your choice");
			String answer = "";

			switch (ch)
			{
			case 1:{	// To ask survey questions from user
						numOfParticipant++;
						System.out.println(question.get(0));
						result=Utility.GetInput("");
						if (result<1 || result>4)
						{
							while (result<1 || result>4)
							{
								result = Utility.GetInput("Add correct value(1-4)");		
							}
						} 
						
						System.out.println(question.get(1));
						int j=0;
						String a = "";
						while ((!answer.equals("4")) &&(j < 4)) 
						{
							answer = scan.next();
							if (!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4")) 
							{
								while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4")) 
								{
									System.out.println("Add correct value(1-4)");
									answer = scan.next();
									str[i]=answer;
									j++;	
								}
							}
							else
							{
								a = a + " " + answer;
								str[0]=a;
								j++;
							}
						}
						
						System.out.println(question.get(2));
						str[1]=scan.next();
						Participants object1=new Participants(numOfParticipant,result,str[0],str[1]); 
						candidate.add(object1);
					}
					break;
			
			case 2 :{// To display single select
					for (i = 1; i <= numOfParticipant; i++) 
					{
						for(Participants s : candidate)
						{
							if (s.answer1==1) 
							{
								totalA += 1.0; // how many users selected option 1
							} 
							else if (s.answer1==2) 
							{
								totalB += 1.0;
							} 
							else if (s.answer1==3) 
							{
								totalC += 1.0;
							}
							else 
							{
								totalD += 1.0;
							}
						}
		
					System.out.println("Total percentage of 1: " + totalA/ numOfParticipant * 100);
					System.out.println("Total percentage of 2: " + totalB/ numOfParticipant * 100);
					System.out.println("Total percentage of 3: " + totalC/ numOfParticipant * 100);
					System.out.println("Total percentage of 4: " + totalD/ numOfParticipant * 100);
					}
			}
			break;
				
			case 3:{// To display all participant
						for(Participants st : candidate )
						{
							System.out.println("Participant"+(++index));
							System.out.println(question.get(0));
							System.out.println(st.answer1);
							System.out.println(question.get(1));
							System.out.println(st.answer2);
							System.out.println(question.get(2));
							System.out.println(st.answer3);
						}
				}
				break;
			
			case 4 : System.exit(0);
			
			default : System.out.println("Wrong choice");
					  break;
			}

	}while(true);
  }
}

