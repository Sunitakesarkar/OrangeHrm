package Default_package;

public class Exception_Class {
	
	static void demo(String a) {
		
		System.out.println("hi");
		if(a.equals("end"))
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	static String s;
	public static void main (String[] args) throws InterruptedException
	{
		demo("ended");
		 int a= 10;
		 int b=0;
		 int c=0;
	//	 try-->catch-->finally-->
		 try
		 {
			 System.out.println("try started");
			 System.out.println(s.charAt(1));     //null
			 c=a/b;
			 System.out.println("try ended");	 
		 }
		catch(ArithmeticException e)
		{
		//	System.out.println("You have entered the value of b "+ b + "Which is incorrect & operation is not allowed");
			b=1;
			c=a/b;
			 System.out.println(c);
		}
		 //alternative code
		catch (NullPointerException e)
		 {
			 System.out.println("You are trying to access null string");
			 //alternative code
			 
		 }
		 
		 finally
		 {
			 System.out.println("This is the end code of our programme");
		 } 
		 
	}
	
}
