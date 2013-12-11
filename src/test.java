

/**
 * 
 */

/**
 * @author Miguel Ángel Arilla Dueso
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Tenedor[] tenedores = new Tenedor[5];
		final Filosofo[] filosofos = new Filosofo[5];
		for(int i=0;i<5;i++) tenedores[i]=new Tenedor();
		for(int i=0;i<4;i++) filosofos[i]=new Filosofo(false,tenedores[i],tenedores[i+1],i+1);
		filosofos[4]=new Filosofo(true,tenedores[4],tenedores[0],5	);
		for(int i=0;i<5;i++) filosofos[i].start();
	}

}
