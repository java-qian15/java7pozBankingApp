package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {


    @Id
    @GeneratedValue
    private Long id;
    private String accountNumber;
    private String currency;
    private Long availableFunds;
    private Long balance;
}
