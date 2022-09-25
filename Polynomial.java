public class Polynomial {
	double[] a;

	public Polynomial(){
		a = new double[1];
	}
	public Polynomial(double[] b)
	{
		int n = 0;
		a = new double[b.length];
		while(n<a.length)
		{
			a[n]=b[n];
			n++;
		}
	}
	public Polynomial add(Polynomial c)
	{
		Polynomial n;
		if(c.a.length>=a.length)
		{
			n=new Polynomial(c.a);
			int i=0;
			while(i<a.length)
			{
				n.a[i]=c.a[i]+a[i];
				i++;
			}
			return n;
		}
		else
		{
			int i = 0;
			n = new Polynomial(a);
			while(i<c.a.length)
			{
				n.a[i]= c.a[i]+a[i];
				i++;
			}
		}
		
		return n;
	}
	public double evaluate(double c)
	{
		double total =0;
		for(int i=0; i<a.length;i++)
		{
			total =total + a[i]*(Math.pow(c, i));
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
}
