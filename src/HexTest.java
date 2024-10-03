import java.util.HashMap;
import java.util.Map;

public class HexTest {
	public static void main(String[] args) {
		String hex = "3F0A0B0123456789101112131415";
		// 16진수는 2자리수마다 1byte
		// String result = hexToString(hex);
		// System.out.println(result); // 출력: Hello World
		String type = hex.substring(0, 4);
		int len = Integer.parseInt(hex.substring(4, 6), 16);
		String value = hex.substring(6, 6 + len * 2);

		System.out.println(type);
		System.out.println(len);
		System.out.println(value);

		Map<String, String> map = new HashMap<>();
		map.put(type, value);

	}

	public static String hexToString(String hex) {
		StringBuilder output = new StringBuilder();

		// 2자리씩 끊어서 16진수를 문자로 변환
		// for (int i = 0; i < hex.length(); i += 2) {
		// 	String str = hex.substring(i, i + 2);
		// 	// 16진수 문자열을 10진수로 변환 후, 그 값을 문자로 변환
		// 	output.append((char)Integer.parseInt(str, 16));
		// }

		return output.toString();
	}
}
