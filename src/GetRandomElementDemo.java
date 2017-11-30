import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ��������ߣ�����ģʽ
 * @author XuJijun
 *
 */
public class GetRandomElementDemo {
	//private static Random random;

	//˫��У������ȡһ��Random����
	public static ThreadLocalRandom getRandom() {
		return ThreadLocalRandom.current();
		/*if(random==null){
			synchronized (RandomUtils.class) {
				if(random==null){
					random =new Random();
				}
			}
		}
		
		return random;*/
	}

	/**
	 * ���һ��[0,max)֮������������
	 * @param max
	 * @return
	 */
	public static int getRandomInt(int max) {
		return getRandom().nextInt(max);
	}
	
	/**
	 * ���һ��[min, max]֮����������
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandomInt(int min, int max) {
		return getRandom().nextInt(max-min+1) + min;
	}

	/**
	 * ���һ��[0,max)֮��ĳ�������
	 * @param max
	 * @return
	 */
	public static long getRandomLong(long max) {
		return getRandom().nextLong(max);
	}
	
	/**
	 * �������������ȡһ��Ԫ��
	 * @param array
	 * @return
	 */
	public static <E> E getRandomElement(E[] array){
		return array[getRandomInt(array.length)];		
	}
	
	/**
	 * ��list�����ȡ��һ��Ԫ��
	 * @param list
	 * @return
	 */
	public static <E> E getRandomElement(List<E> list){
		return list.get(getRandomInt(list.size()));
	}
	
	/**
	 * ��set�����ȡ��һ��Ԫ��
	 * @param set
	 * @return
	 */
	public static <E> E getRandomElement(Set<E> set){
		int rn = getRandomInt(set.size());
		int i = 0;
		for (E e : set) {
			if(i==rn){
				return e;
			}
			i++;
		}
		return null;
	}
	
	/**
	 * ��map�����ȡ��һ��key
	 * @param map
	 * @return
	 */
	public static <K, V> K getRandomKeyFromMap(Map<K, V> map) {
		int rn = getRandomInt(map.size());
		int i = 0;
		for (K key : map.keySet()) {
			if(i==rn){
				return key;
			}
			i++;
		}
		return null;
	}
	
	/**
	 * ��map�����ȡ��һ��value
	 * @param map
	 * @return
	 */
	public static <K, V> V getRandomValueFromMap(Map<K, V> map) {
		int rn = getRandomInt(map.size());
		int i = 0;
		for (V value : map.values()) {
			if(i==rn){
				return value;
			}
			i++;
		}
		return null;
	}
	
	/**
	 * ����һ��nλ���������������֤���
	 * @param n
	 * @return
	 */
	public static String getRandNumber(int n) {
		String rn = "";
		if (n > 0 && n < 10) {
			//Random r = new Random();
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < n; i++) {
				str.append('9');
			}
			int num = Integer.parseInt(str.toString());
			while (rn.length() < n) {
				rn = String.valueOf(ThreadLocalRandom.current().nextInt(num));
			}
		} else {
			rn = "0";
		}
		return rn;
	}
	
	public static void main(String[] args) {
		/*Set<String> set = new HashSet<>();
		for (int i = 0; i < 12; i++) {
			set.add("I am: " + i);	
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomElement(set));
		}*/
		
		System.out.println(getRandom().nextInt(-100, 10));
	}
}