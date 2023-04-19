package application;

import entities.Contract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        int number = scan.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        Date data = sdf.parse(scan.nextLine());
        System.out.print("Valor do contrato: ");
        double valor = scan.nextDouble();
        Contract contract = new Contract(number, data, valor);

        System.out.print("Entre com o numero de parcelas: ");
        int numParcelas = scan.nextInt();

        scan.close();
    }
}
