package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {


    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String accountNumber;

    @Enumerated
    private Currency currency;
    private Long availableFunds;
    private Long balance;
}
