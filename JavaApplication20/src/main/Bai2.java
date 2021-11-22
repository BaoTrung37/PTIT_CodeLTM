/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;
import java.util.Stack;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            int n = sc.nextInt();
            int d[] = new int [n + 10];
            int a[] = new int [n + 10];
            for(int i = 0; i < n ; i++){
                a[i] = sc.nextInt();
            }
            Stack <Integer> st = new Stack<>();
            st.push(0);
            d[0] = 1;
            for(int i = 1; i < n; i++){
                while(!st.isEmpty() && a[st.peek()] <= a[i]){
                    st.pop();
                }
                d[i] = (st.empty() ? (i + 1 ) : (i - st.peek()));
                st.push(i);
            }
            for(int i = 0; i < n; i++){
                System.out.print(d[i] + " ");
            }
            System.out.println();
        }
    }
}
