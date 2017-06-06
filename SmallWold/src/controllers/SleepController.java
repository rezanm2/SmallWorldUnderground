package controllers;

public class SleepController
{
	public void sleep(int ms)
	{
		try
		{
				Thread.sleep(ms);
		} catch (InterruptedException e)
		{
			System.out.println("A: Whoops. I got a little too fast here.");e.printStackTrace();
		}
	}
}
