import java.util.Random;

/**
 * @author Miguel Angel Arilla
 *
 */
public class Filosofo extends Thread {
	private boolean zurdo;
	private Random rand;
	private final Tenedor izq;
	private final Tenedor der;
	private int id;
	
	public Filosofo(boolean zurdo, Tenedor izq, Tenedor der, int id) {
		this.zurdo = zurdo;
		this.izq = izq;
		this.der = der;
		this.id=id;
	}
	public void comer() throws InterruptedException
	{
		if(zurdo)
		{
			izq.coger();
			System.out.println("Filosofo "+id+": Tenedor izquierdo cogido.");
			der.coger();
			System.out.println("Filosofo "+id+": Tenedor derecho cogido.");
		} else
		{
			der.coger();
			System.out.println("Filosofo "+id+": Tenedor derecho cogido.");
			izq.coger();
			System.out.println("Filosofo "+id+": Tenedor izquierdo cogido.");
		}
		System.out.println("Filosofo "+id+": Comiendo.");
		rand=new Random();
		Thread.sleep(rand.nextInt(1000));
	}
	public void pensar() throws InterruptedException
	{
		System.out.println("Filosofo "+id+": Pensando.");
		der.soltar();
		izq.soltar();
		rand=new Random();
		Thread.sleep(rand.nextInt(1000));
	}
	@Override
	public void run()
	{
		while(true) {
			try {
				this.comer();
				this.pensar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
