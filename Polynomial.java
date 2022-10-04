package b07Lec02;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Polynomial {
	double[] a;
	int[] ex;

	public Polynomial(){
		a = new double[1];
		ex= new int[1];
	}
	public Polynomial(double[] b, int[]d)
	{
		int n = 0;
		a = new double[b.length];
		while(n<a.length)
		{
			a[n]=b[n];
			n++;
		}
		n=0;
		ex = new int[d.length];
		while(n<d.length)
		{
			ex[n]=d[n];
			n++;
		}
	}
	public Polynomial add(Polynomial c)
	{
		Polynomial n;
		int count=0;
		int countt=0;
		double []n_cof;
		int []n_exp;
		int l =0;
		if(c.a.length>=a.length)
		{
			n=new Polynomial(c.a, c.ex);
			for(int i=0;i<ex.length;i++)
			{
				for(int j=0;j<c.ex.length;j++)
				{
					if(ex[i]==c.ex[j])
					{
						count++;
					}
				}
			}
			int n_len = ex.length-count;
			n_cof = new double [n_len];
			n_exp = new int [n_len];
			for(int i=0;i<ex.length;i++)
			{
				for(int j=0;j<c.ex.length;j++)
				{
					if(ex[i]==c.ex[j])
					{
						n.a[j]=a[i]+c.a[j];
					}
					else
					{
						countt++;
					}
				}
				if(countt==c.ex.length)
				{
					n_cof[l] = a[i];
					n_exp[l] = ex[i];
					l++;
				}
				countt=0;
			}
			double[] f_cof = new double[n_cof.length+c.a.length];
			int q=0;
			int [] f_exp = new int[n_exp.length+c.ex.length];
			for(int i=0; i<c.a.length;i++)
			{
				
				//if(n.a[i]!=0.0)
				{
					f_cof[q]=n.a[i];
					f_exp[q] = n.ex[i];
					q++;
				}
			}
			for(int i=0; i<n_cof.length;i++)
			{
				//if(n_cof[i]!=0.0)
				{
					f_cof[q]=n_cof[i];
					f_exp[q]=n_exp[i];
					q++;
				}
			}
			int zs = 0;
			for(int i=0;i<f_cof.length;i++)
			{
				if(f_cof[i]==0)
				{
					zs++;
				}
			}
			double[] cof = new double [f_cof.length-zs];
			int [] exp = new int [f_cof.length-zs];
			int w=0;
			for(int i=0;i<f_cof.length;i++)
			{
				if(f_cof[i]!=0.0)
				{
					cof[w]=f_cof[i];
					exp[w]=f_exp[i];
					w++;
				}
			}
			n=new Polynomial(cof, exp);
			return n;
		}
		else
		{
			n=new Polynomial(a, ex);
			for(int i=0;i<c.ex.length;i++)
			{
				for(int j=0;j<ex.length;j++)
				{
					if(c.ex[i]==ex[j])
					{
						count++;
					}
				}
			}
			int n_len = c.ex.length-count;
			n_cof = new double [n_len];
			n_exp = new int [n_len];
			for(int i=0;i<c.ex.length;i++)
			{
				for(int j=0;j<ex.length;j++)
				{
					if(c.ex[i]==ex[j])
					{
						n.a[j]=c.a[i]+a[j];
					}
					else
					{
						countt++;
					}
				}
				if(countt==ex.length)
				{
					n_cof[l] = c.a[i];
					n_exp[l] = c.ex[i];
					l++;
				}
				countt=0;
			}
			//for(int i=0; )
			double[] f_cof = new double[n_cof.length+a.length];
			int q=0;
			int [] f_exp = new int[n_exp.length+ex.length];
			
			for(int i=0; i<a.length;i++)
			{
				f_cof[q]=n.a[i];
				f_exp[q] = n.ex[i];
				q++;
			}
			for(int i=0; i<n_cof.length;i++)
			{
				f_cof[q]=n_cof[i];
				f_exp[q]=n_exp[i];
				q++;
			}
			int zs = 0;
			for(int i=0;i<f_cof.length;i++)
			{
				if(f_cof[i]==0)
				{
					zs++;
				}
			}
			double[] cof = new double [f_cof.length-zs];
			int [] exp = new int [f_cof.length-zs];
			int w=0;
			for(int i=0;i<f_cof.length;i++)
			{
				if(f_cof[i]!=0.0)
				{
					cof[w]=f_cof[i];
					exp[w]=f_exp[i];
					w++;
				}
			}
			n=new Polynomial(cof, exp);
			return n;
		}
	}
	public double evaluate(double c)
	{
		double total =0;
		for(int i=0; i<a.length;i++)
		{
			total =total + a[i]*(Math.pow(c, ex[i]));
		}
		return total;
	}
	public boolean hasRoot(double c)
	{
		if(evaluate(c)==0)
		{
			return true;
		}
		return false;
	}
	public Polynomial multiply(Polynomial c)
	{
		int siz = c.a.length*a.length;
		int q = 0;
		int count=0;
		double []all = new double[siz];
		int []all_exp = new int[siz];
		
		for(int i=0;i<c.a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				all[q]=c.a[i]*a[j];
				all_exp[q]=c.ex[i]+ex[j];
				q++;
			}
		}
		for(int i=0; i<siz;i++)
		{
			for(int j=i;j<siz;j++)
			{
				if(all_exp[i]==all_exp[j])
				{
					if(i!=j)
					{
						all[i]=all[i]+all[j];
						all[j]=0;
						all_exp[j]=-1;
					}
				}
			}
		}
		for(int i=0;i<siz;i++)
		{

//			System.out.println(all[i]);
//			System.out.println(all_exp[i]);

			if(all[i]==0||all_exp[i]==-1)
			{
				count++;
			}
		}

		//System.out.println(count);

		int f_siz = siz-count;
		double []fall = new double[f_siz];
		int []fall_exp = new int[f_siz];
		int w=0;
		for(int i=0;i<siz;i++)
		{
			if(all_exp[i]!=-1&&all[i]!=0.0)
			{
				//System.out.println(w);
				//w++;
				fall[w]=all[i];
				fall_exp[w]=all_exp[i];
				w++;
			}
		}
		Polynomial n;
		n=new Polynomial(fall,fall_exp);
		return n;
	}
	public int after(String[] a, int pol)
	{
//		for(int i=0;i<pol;i++)
//		{
//			int q=0;
//			while(a[q].equals("-")||a[q].equals("+"))
//		}
		return 0;
	}
	public Polynomial(File c) throws FileNotFoundException
	{
		Scanner s = new Scanner(c);
		String line = (s.nextLine());
		String[]sp = line.split("");
		String[] b = line.split("[+-]");
		int ind=0;
		int check=0;
		
		if(sp[0].equals("-"))
		{
			b[0]=b[0].replace("-", "");
		}
		//System.out.println(b[0]);
		if(sp[0].equals("-"))
		{
			check++;
		}
		String[]d = new String[b.length-1];
		for(int i=0;i<sp.length;i++)
		{
			if(sp[i].equals("+")||sp[i].equals("-"))
			{
				ind++;
				if(sp[i].equals("-"))
				{
					b[ind]="-"+b[ind];
				}
			}
		}
		if(check==1)
		{
			for(int i=1;i<b.length;i++)
			{
				d[i-1]=b[i];
			}
//			
//			for(int i=0;i<d.length;i++)
//			{
//				System.out.println(d[i]);
//			}
			a=new double[d.length];
			ex = new int[d.length];
			for(int i=0;i<d.length;i++)
			{
				String[] bi = d[i].split("x");
				if(bi.length==2)
				{
					if(bi[0].equals(""))
					{
						a[i]=1;
						
						ex[i]=Integer.parseInt(bi[1]);
					}
					else
					{
						if(!bi[0].equals("-"))
						{
							a[i]=Double.parseDouble(bi[0]);
						}
						else
						{
							a[i]=-1.0;
						}
						ex[i]=Integer.parseInt(bi[1]);
					}
					
				}
				else if(bi.length==0)
				{
					a[i]=1.0;
					ex[i]=1;
				}
				else if(bi.length==1)
				{
					if(bi[0].equals(d[i]))
					{
						a[i]=Double.parseDouble(bi[0]);
						ex[i]=0;
					}
					else if(bi[0].equals("-"))
					{
						a[i]=-1;
						ex[i]=1;
					}
					else
					{
						a[i]=Double.parseDouble(bi[0]);
						ex[i]=1;
					}
				
				}
				
			}		
		}
		else {
			
			a=new double[b.length];
			ex = new int[b.length];
			for(int i=0;i<b.length;i++)
			{
				String[] bi = b[i].split("x");
				if(bi.length==2)
				{
					if(bi[0].equals(""))
					{
						a[i]=1;
						
						ex[i]=Integer.parseInt(bi[1]);
					}
					else
					{
						if(!bi[0].equals("-"))
						{
							a[i]=Double.parseDouble(bi[0]);
						}
						else
						{
							a[i]=-1.0;
						}
						ex[i]=Integer.parseInt(bi[1]);
					}
					
				}
				else if(bi.length==0)
				{
					a[i]=1.0;
					ex[i]=1;
				}
				else if(bi.length==1)
				{

					
					if(bi[0].equals(b[i]))
					{
						a[i]=Double.parseDouble(bi[0]);
						ex[i]=0;
					}
					else if(bi[0].equals("-"))
					{
						a[i]=-1;
						ex[i]=1;
					}
					else
					{
						a[i]=Double.parseDouble(bi[0]);
						ex[i]=1;
					}
				
				}
				
			}
			
		}
		s.close();

	}
	public void saveToFile(String n) throws IOException
	{
		File out = new File(n);
		FileWriter wr = new FileWriter (out);
		PrintWriter pr = new PrintWriter(wr);
		for(int i=0;i<a.length;i++)
		{
			if(ex[i]==0)
			{
				if(a[i]<0)
				{
					pr.print(a[i]);
				}
				else if(a[i]>0&&i!=0)
				{
					pr.print("+" + a[i]);
				}
				else 
				{
					pr.print(a[i]);
				}
			}
			else
			{
				if(a[i]>0)
				{
					if(i!=0)
					{
						pr.print("+"+a[i]);
						pr.print("x");
						pr.print(ex[i]);
					}
					else
					{
						pr.print(a[i]);
						pr.print("x");
						pr.print(ex[i]);
					}
				}
				else
				{
					pr.print(a[i]);
					pr.print("x");
					pr.print(ex[i]);
				}
			}
		}
		pr.close();
	}
}