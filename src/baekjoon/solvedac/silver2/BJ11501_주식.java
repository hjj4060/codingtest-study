package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11501
public class BJ11501_주식 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static int dayCount;
    static int[] stocks;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        dayCount = Integer.parseInt(st.nextToken());
        stocks = new int[dayCount];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dayCount; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            input();

            //주식 가격에서 최대값을 찾음
            int maxStockPrice = maxStockPrice(0);
            Queue<Integer> haveStock = new LinkedList<>();
            long sellMoney = 0;

            for (int j = 0; j < stocks.length; j++) {
                //주식 가격에서 최대값이 나올때 까지 삼
                if (maxStockPrice != stocks[j]) {
                    haveStock.add(stocks[j]);
                //최대값이 나오면 다 팔고 최대값 다시 구함
                } else {
                    while (!haveStock.isEmpty()) {
                        sellMoney += maxStockPrice - haveStock.poll();
                    }

                    if (j != stocks.length - 1) {
                        maxStockPrice = maxStockPrice(j + 1);
                    }
                }
            }

            sb.append(sellMoney).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int maxStockPrice(int startIndex) {
        int maxStockPrice = 0;

        for (int i = startIndex; i < stocks.length; i++) {
            maxStockPrice = Math.max(maxStockPrice, stocks[i]);
        }

        return maxStockPrice;
    }
}
