    package baekjoon.solvedac.gold4;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.HashMap;
    import java.util.StringTokenizer;

    //https://www.acmicpc.net/problem/2141
    public class BJ2141_우체국 {
        static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static private StringTokenizer st = null;

        public static void main(String[] args) throws Exception {
            st = new StringTokenizer(br.readLine());
            int townCount = Integer.parseInt(st.nextToken());

            /**
             * 문제풀이
             * 1. key: 마을위치, value: 사람수로 맵을 만들어서 입력값을 넣는다.
             * 2. key: 마을위치, value: 거리 * 사람수로 맵을 만든다
             * 3. value가 가장 작은 key를 출력한다.
             */
            HashMap<Integer, Integer> townPeopleCountMap = new HashMap<>();

            for(int i = 0; i < townCount; i++) {
                st = new StringTokenizer(br.readLine());

                int townLocation = Integer.parseInt(st.nextToken());
                int townPeopleCount = Integer.parseInt(st.nextToken());

                townPeopleCountMap.put(townLocation, townPeopleCount);
            }

            //각 마을위치별 다른 마을 사람별 거리를 계산해서 value에 기입
            HashMap<Integer, Long> sumTownDistancePeopleCountMap = new HashMap<>();
            for(int townLocation : townPeopleCountMap.keySet()) {
                Long distancePeopleCount = (long)0;

                for(int calculatingTownLocation : townPeopleCountMap.keySet()) {
                    distancePeopleCount += Math.abs(townLocation - calculatingTownLocation) * townPeopleCountMap.get(calculatingTownLocation);
                }

                sumTownDistancePeopleCountMap.put(townLocation, distancePeopleCount);
            }

            Long minDistancePeopleCount = Long.MAX_VALUE;
            int minTownLocation = Integer.MAX_VALUE;

            for(int key : sumTownDistancePeopleCountMap.keySet()) {
                if(minDistancePeopleCount > sumTownDistancePeopleCountMap.get(key)) {
                    minTownLocation = key;
                    minDistancePeopleCount = sumTownDistancePeopleCountMap.get(key);
                }
            }

            System.out.println(minTownLocation);
        }
    }
