package com.aaditi;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    public static int chiefHopper(List<Integer> arr) {
        List<Integer> tmp = new ArrayList<>();
        for(int i=0 ; i<arr.size() ; i++){
            tmp.add(arr.get(i));
        }
        Collections.sort(tmp);
        int minBotEnergy=tmp.get(arr.size()- 1);
        int currBotEnergy = minBotEnergy;
        int newEnergy=currBotEnergy;
        int height=0 ,delta=0;
        int flag = 1;
        while( minBotEnergy > 0){
            newEnergy = currBotEnergy;
            for(int i=0 ; i<arr.size() ; i++){
                height = arr.get(i);
                if(newEnergy < height){
                    delta = height - newEnergy ;
                    newEnergy=newEnergy - delta;
                }
                else{
                    delta =newEnergy - height;
                    newEnergy= newEnergy + delta;
                }
                
                if(newEnergy < 0 ){
                    flag = 0;
                    break;
                }
            }
            if(flag == 0){
                break;
            }
            else{
                minBotEnergy = currBotEnergy ;
                currBotEnergy--;
                continue;
            }
        }
        
        return minBotEnergy;

    }
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.chiefHopper(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
