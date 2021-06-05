package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class filewriting {
    public static void Simple_Savings(String FileName, String Priniciple, String IneterestRate, String Period, String futureVal) throws IOException {
        File file01 = new File(FileName);
        FileWriter fileWriter =  new FileWriter(file01,true);
        fileWriter.write("\nPresent Value : "   + Priniciple);
        fileWriter.write("\nInterest Rate : "   + IneterestRate);
        fileWriter.write("\nTime : "            + Period);
        fileWriter.write("\nFuture Value : "    + futureVal          + "\n\n");

        fileWriter.close();

    }
    public static void Compound_Interest(String FileName,String futureVal,String IneterestRate,String Priniciple,String MonthlyPay,String Period) throws IOException {
        File file01 = new File(FileName);
        FileWriter fileWriter=  new FileWriter(file01,true);
        fileWriter.write("\nFuture Value : "     + futureVal);
        fileWriter.write("\nInterest Rate : "    + IneterestRate);
        fileWriter.write("\nPresent Value : "    + Priniciple);
        fileWriter.write("\nMonthly Payment : "  + MonthlyPay);
        fileWriter.write("\nPeriod : "           + Period     + "\n\n");

        fileWriter.close();

    }
    public static void Loan(String FileName,String homePrice,String interestRate,String loanTerm,String monthlyPay) throws IOException {
        File file01 = new File(FileName);
        FileWriter fileWriter =  new FileWriter(file01,true);
        fileWriter.write("\nHome Price : "       + homePrice);
        fileWriter.write("\nInterest Rate : "    + interestRate);
        fileWriter.write("\nLoan Term : "        + loanTerm);
        fileWriter.write("\nMonthly Payment : "  + monthlyPay   + "\n\n");

        fileWriter.close();

    }

    public static void Mortgage(String filename,String homePrice,String downPay,String Period,String interestRate,String monthlyPay) throws IOException {
        File file01 = new File(filename);
        FileWriter fileWriter =  new FileWriter(file01,true);
        fileWriter.write("\nHome value : "      + homePrice);
        fileWriter.write("\nDown Payment : "    + downPay);
        fileWriter.write("\nLoan  term : "      + Period);
        fileWriter.write("\nInterest Rate : "   + interestRate);
        fileWriter.write("\nMonthly Payment : " + monthlyPay    +  "\n\n");

        fileWriter.close();

    }
}