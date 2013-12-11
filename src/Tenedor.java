import java.util.concurrent.Semaphore;


public class Tenedor {
	private final Semaphore s=new Semaphore(1);
	public void coger() throws InterruptedException {
		s.acquire();
	}
	public void soltar() {
		s.release();
	}
}
