package newaccount.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newaccount.AccountopenApplication;
import newaccount.domain.AccountOpenedE;

@Entity
@Table(name = "AccountA_table")
@Data
public class AccountA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acctNo;

    private String custNo;

    private String openDate;

    private String accountStatus;

    private String accountBalance;

    @PostPersist
    public void onPostPersist() {
        AccountOpenedE accountOpenedE = new AccountOpenedE(this);
        accountOpenedE.publishAfterCommit();
    }

    public static AccountARepository repository() {
        AccountARepository accountARepository = AccountopenApplication.applicationContext.getBean(
            AccountARepository.class
        );
        return accountARepository;
    }

    public static void createAccount(IncomeVerifiedE incomeVerifiedE) {
        /** Example 1:  new item 
        AccountA accountA = new AccountA();
        repository().save(accountA);

        */

        /** Example 2:  finding and process
        
        repository().findById(incomeVerifiedE.get???()).ifPresent(accountA->{
            
            accountA // do something
            repository().save(accountA);


         });
        */

    }
}
