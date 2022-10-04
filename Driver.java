import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Driver { 
	 public static void main(String [] args) throws IOException { 
		 String a = "-x";
		 String[] sp = a.split("x");
		 for(int i=0;i<sp.length;i++)
		 {
			// System.out.println(sp[i]);
		 }
		 
	  //Polynomial p = new Polynomial(); 
	  //System.out.println(p.evaluate(3)); 
		 
	 /* double [] c1 = {6,-7}; 
	  int [] cc= {0,3};
	 
	  double [] c2 = {-2,9,7,-9};
	  int [] cc1= {1,2,3,4};
	  Polynomial p1 = new Polynomial(c1,cc); 
	 // System.out.println("asd");
	   
	  Polynomial p2 = new Polynomial(c2,cc1); 
	  
	  Polynomial s = p1.add(p2);
	  for(int i=0;i<s.a.length;i++)
	  {
		  System.out.println(s.a[i]);
		  System.out.println(s.ex[i]);
	  }
	  System.out.println("//////////////////////////////////////////////////");
	  Polynomial mul = p1.multiply(p2);
	  for(int i=0; i<mul.a.length;i++)
	  {
		  System.out.println(mul.a[i]);
		  System.out.println(mul.ex[i]);
	  }
	  //System.out.println("s(0.1) = " + s.evaluate(0.1)); 
//	  if(s.hasRoot(1)) 
//	   System.out.println("1 is a root of s"); 
//	  else 
//	   System.out.println("1 is not a root of s"); 
	 } */
		 	/*double c1[]= {1,2,1}, c2[] = {1,-5};
	        int e1[]= {2,1,0}, e2[] = {1,0};

	        double c3[] = {6,2,4,5};
	        int e3[] = {3,2,1,4};

	        double c4[] = {1,2,3};
	        int e4[] = {5,3,1};

	        Polynomial p1=new Polynomial(c1, e1);
	        Polynomial p2=new Polynomial(c2, e2);


	        Polynomial p3=p1.add(p2);

	        Polynomial p4=new Polynomial(c3, e3);
	        Polynomial p5=new Polynomial(c4, e4);

	        Polynomial p6=p4.add(p5);

	        //System.out.println(p3.evaluate(0));
	        for(int i=0; i<p6.a.length; i++) {
	
	            System.out.println(p6.a[i] + " ");
	            
	            System.out.println(p6.ex[i] + " ");
	        }
	//
	        System.out.println();

//	        for(int i=0; i<p6.coefficients.length; i++) {
	//
//	            System.out.print(p6.exponents[i] + " ");
//	        }
	//
	        Polynomial p7=p4.multiply(p5);

//
//	        for(int i=0; i<p7.a.length; i++) {
//
//	            System.out.print(p7.a[i] + " ");
//	        }
//	        System.out.println();
//
//	        for(int i=0; i<p7.ex.length; i++) {
//
//	            System.out.print(p7.ex[i] + " ");
//	        }
	 }
}*/
	


	//public static void main(String[] args) {
		 double c1[]= {15,17,-270}, c2[] = {1,-10};
	        int e1[]= {3,100,4}, e2[] = {3,100};

		
		Polynomial p1=new Polynomial(c1, e1);
		Polynomial p2=new Polynomial(c2, e2);
		
		
		Polynomial p3=p1.multiply(p2);
		for(int i=0; i<p3.a.length; i++) {
			
			System.out.println(p3.a[i]);	
			System.out.println(p3.ex[i]);	
		}
		System.out.println("sad");
		/*Polynomial p4=new Polynomial(c3, e3);
		Polynomial p5=new Polynomial(c4, e4);
		
		Polynomial p6=p4.multiply(p5);
		
		//System.out.println(p3.evaluate(0));
		for(int i=0; i<p6.a.length; i++) {
			
			System.out.print(p6.a[i] + " ");		
		}
		
		System.out.println();
		
		for(int i=0; i<p6.a.length; i++) {
			
			System.out.print(p6.ex[i] + " ");			
		}*/
		
		File file = new File("C:\\Users\\musta\\Desktop\\07\\b07Lec02\\lab2.txt");
		Polynomial f = new Polynomial(file);
		System.out.println("*******************");
		for(int i=0; i<f.a.length;i++)
		{
			System.out.println(f.a[i]+"\t"+f.ex[i]);
			//System.out.println(f.ex[i]);
		}
		f.saveToFile("do.txt");
		double c4[] = {-1,1,-1,1};
		int e4[] = {1,2,4,0};
		Polynomial n = new Polynomial(c4,e4);
		n.saveToFile("test.txt");
	}

}