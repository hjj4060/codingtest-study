    package baekjoon.solvedac.gold4;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.HashMap;
    import java.util.StringTokenizer;
    import java.util.TreeMap;

    //https://www.acmicpc.net/problem/2141
    public class BJ2141_우체국_try2 {
        static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static private StringTokenizer st = null;

        public static void main(String[] args) throws Exception {
            st = new StringTokenizer(br.readLine());

            int townCount = Integer.parseInt(st.nextToken());

            /**
             * townPeopleCountMap
             * key: 마을 위치
             * value : 사람 수
             */
            TreeMap<Integer, Integer> townPeopleCountMap = new TreeMap<>();

            for (int i = 0; i < townCount; i++) {
                st = new StringTokenizer(br.readLine());

                int townLocation = Integer.parseInt(st.nextToken());
                int townPeopleCount = Integer.parseInt(st.nextToken());

                townPeopleCountMap.put(townLocation, townPeopleCount);
            }

            /**
             * 전체 마을 사람 / 2 나오는 값
             * 마을 사람 계속 더한 값
             * 마을 사람 계속 더한 값이 전체마을 사람 /2 해서 나오는 값보다 커지면 마을 위치에 우체국 설치
             */

            double peopleCountDivision2 = 0;
            for (int key : townPeopleCountMap.keySet()) {
                peopleCountDivision2 += townPeopleCountMap.get(key);
            }
            peopleCountDivision2 /= 2;

            int installOfficeLocation = 0;
            double sumPeopleCount = 0;
            for (int key : townPeopleCountMap.keySet()) {
                sumPeopleCount += townPeopleCountMap.get(key);

                if (peopleCountDivision2 <= sumPeopleCount) {
                    installOfficeLocation = key;
                    break;
                }
            }

            System.out.println(installOfficeLocation);
        }
    }
