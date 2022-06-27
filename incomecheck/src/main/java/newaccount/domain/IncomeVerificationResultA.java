package newaccount.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newaccount.IncomecheckApplication;
import newaccount.domain.IncomeVerifiedE;

@Entity
@Table(name = "IncomeVerificationResultA_table")
@Data
public class IncomeVerificationResultA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String custNo;

    private String verifyResult;

    private Long incomeAmount;

    private String appliedStatus;

    private String regNo;

    @PostPersist
    public void onPostPersist() {
        IncomeVerifiedE incomeVerifiedE = new IncomeVerifiedE(this);
        incomeVerifiedE.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        newaccount.external.ExternalCheck externalCheck = new newaccount.external.ExternalCheck();
        // mappings goes here
        IncomecheckApplication.applicationContext
            .getBean(newaccount.external.ExternalCheckService.class)
            .externalCheck(externalCheck);
    }

    public static IncomeVerificationResultARepository repository() {
        IncomeVerificationResultARepository incomeVerificationResultARepository = IncomecheckApplication.applicationContext.getBean(
            IncomeVerificationResultARepository.class
        );
        return incomeVerificationResultARepository;
    }

    public static void incomeVerify(PreAppliedE preAppliedE) {
        /** Example 1:  new item 
        IncomeVerificationResultA incomeVerificationResultA = new IncomeVerificationResultA();
        repository().save(incomeVerificationResultA);

        IncomeVerifiedE incomeVerifiedE = new IncomeVerifiedE(incomeVerificationResultA);
        incomeVerifiedE.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(preAppliedE.get???()).ifPresent(incomeVerificationResultA->{
            
            incomeVerificationResultA // do something
            repository().save(incomeVerificationResultA);

            IncomeVerifiedE incomeVerifiedE = new IncomeVerifiedE(incomeVerificationResultA);
            incomeVerifiedE.publishAfterCommit();

         });
        */

    }
}
