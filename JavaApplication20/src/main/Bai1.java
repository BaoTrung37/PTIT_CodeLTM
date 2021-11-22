/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String s = sc.nextLine();
            int count = 1;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    System.out.print(count + " ");
                    list.add(count++);
                }
                else if(s.charAt(i) == ')'){
                    System.out.print(list.get(list.size() - 1) + " ");
                    list.remove(list.size() - 1);
                }
            }
            System.out.println();
        }
    }
}
