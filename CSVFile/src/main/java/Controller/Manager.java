
package Controller;

import Model.CSV;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Manager {
    public int checkInputIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if(result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }
    
    public void formatName(ArrayList<CSV> ls) {
        for(int i = 0; i < ls.size(); i++) {
            String name = ls.get(i).getName().trim();
            name = name.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = name.split(",");
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0))).append(arr[j].substring(1)).append(" ");
                
            }
            ls.get(i).setName(sb.toString().trim());
        }
        System.out.println("Format: Done");
    }
    
    public void formatAddress(ArrayList<CSV> ls) {
        for(int i = 0; i < ls.size(); i++) {
            String address = ls.get(i).getAddress().trim();
            address = address.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = address.split(",");
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0))).append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setAddress(sb.toString().trim());
        }
        System.out.println("Format: Done");
    }
    
    public void importFile(ArrayList<CSV> ls) {
        Scanner sc = new Scanner(System.in);
        String COMMA_DELIMITER = ",";
        String line = "";
        BufferedReader fileReader = null;
        System.out.print("Enter path: ");
        String filename = sc.nextLine().trim();
        try {
            fileReader = new BufferedReader(new FileReader("E:\\import.csv"));
            while((line = fileReader.readLine()) != null) {
                String[] splitCSV = line.split("COMMA_DELIMITER");
                ls.add(new CSV(Integer.parseInt(splitCSV[0]), splitCSV[1], splitCSV[2], splitCSV[3], splitCSV[4]));
            }
            System.out.println("Import: Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    public void exportFile(ArrayList<CSV> ls) {
        Scanner sc = new Scanner(System.in);
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        FileWriter fileWriter = null;
        System.out.print("Enter path: ");
        String fileName = sc.nextLine();
        try {
            fileWriter = new FileWriter("E:\\import.csv");
            for (CSV listCSV : ls) {
                fileWriter.append(String.valueOf(listCSV.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getEmail()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getPhone()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getAddress()));
                fileWriter.append(NEW_LINE_SEPARATOR);
                
            }
            System.out.println("Export Done!!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void print(ArrayList<CSV> ls) {
        for(int i = 0; i < ls.size(); i++) {
            System.out.printf("%d,%s,%s,%s,%s\n", ls.get(i).getId(), ls.get(i).getName(), ls.get(i).getEmail(), ls.get(i).getPhone(), ls.get(i).getAddress());
        }
    }
    
    public void display(ArrayList<CSV> ls) {
        while(true) {
            System.out.println("1. Import CSV");
            System.out.println("2. Format Address");
            System.out.println("3. Format Name");
            System.out.println("4. Export CSV");
            System.out.println("5. Exit");
            System.out.print("Please choice one option");
            int choice = checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    importFile(ls);
                    print(ls);
                            
                    break;
                case 2:
                    formatAddress(ls);
                    print(ls);
                    break;
                case 3:
                    formatName(ls);
                    print(ls);
                    break;
                case 4:
                    exportFile(ls);
                    break;
                case 5:
                    return;
            }
        }
    
    }
    
    
}
