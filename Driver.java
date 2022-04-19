package com.assignment2.main;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

import com.assignment2.Company;
import com.assignment2.StockServices;

public class Driver {
    public static void main(String[] args) {
        StockServices stockService = new StockServices();


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of companies");
        int companiesSize = sc.nextInt();
        Company[] companyArray = new Company[companiesSize];
        double value;
        for (int i = 0; i < companiesSize; i++) {
            Company company = new Company();
            System.out.println("Enter current stock price of the company : " + (i + 1));
            company.setStockPrice(sc.nextDouble());
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            company.setStockVariation(sc.nextBoolean());
            companyArray[i] = company;
        }


        int option;
        do {
            System.out.println("-----------------------------------------------");
            System.out.println("Enter the operation that you want to perform");
            System.out.println("1. Display the companies stock prices in ascending order");
            System.out.println("2. Display the companies stock prices in descending order");
            System.out.println("3. Display the total no of companies for which stock prices rose today");
            System.out.println("4. Display the total no of companies for which stock prices declined today");
            System.out.println("5. Search a specific stock price");
            System.out.println("6. press 0 to exit");
            System.out.println("-----------------------------------------------");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    option = 1;
                    stockService.displayStockPricesAsc(companyArray);
                    break;
                case 2:
                    option = 2;
                    stockService.displayStockPricesDsc(companyArray);
                    break;
                case 3:
                    option = 3;
                    stockService.displayNoOfCompaniesOnARise(companyArray);
                    break;
                case 4:
                    option = 4;
                    stockService.displayNoOfCompaniesOnAFall(companyArray);
                    break;
                case 5:
                    option = 5;
                    System.out.println("enter the key value");
                    value = sc.nextDouble();
                    stockService.searchStockPrice(companyArray, value);
                    break;
            }

        } while (option != 0);
    }

}
