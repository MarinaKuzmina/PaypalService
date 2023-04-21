package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentServices onlinePaymentServices;

    public ContractService(OnlinePaymentServices onlinePaymentServices){
        this.onlinePaymentServices = onlinePaymentServices;
    }
    public void processContract(Contract contract, int months){
        //exemplo de parcela
        //contract.getInstallments().add(new Installment(LocalDate.of(2018, 7, 25), 206.04));
        //contract.getInstallments().add(new Installment(LocalDate.of(2018, 8, 25), 208.08));

        double basicQuota = contract.getTotalValue()/months;

        for(int i=1; i<=months; i++){
            //qual vai ser a data de vencimento de cada parcela? A data
            // original do contrato somada a qtd de meses da variável "i" (a parcela vai ser mais um mes)
            LocalDate dueDate = contract.getDate().plusMonths(i);
            //calculando parcelas

            //interest - juro; fee - taxa
            double interest = onlinePaymentServices.interest(basicQuota, i);
            double fee = onlinePaymentServices.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, quota));
        }
    }
}
