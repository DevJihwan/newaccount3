package newaccount.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newaccount.PreapplyApplication;
import newaccount.domain.PreAppliedE;

@Entity
@Table(name = "PreApplicationA_table")
@Data
public class PreApplicationA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String appliedStatus;

    private String custNo;

    private String regNo;

    @PostPersist
    public void onPostPersist() {
        PreAppliedE preAppliedE = new PreAppliedE(this);
        preAppliedE.publishAfterCommit();
    }

    public static PreApplicationARepository repository() {
        PreApplicationARepository preApplicationARepository = PreapplyApplication.applicationContext.getBean(
            PreApplicationARepository.class
        );
        return preApplicationARepository;
    }

    public static void statusUpdateP(IncomeVerifiedE incomeVerifiedE) {
        /** Example 1:  new item 
        PreApplicationA preApplicationA = new PreApplicationA();
        repository().save(preApplicationA);

        */

        /** Example 2:  finding and process
        
        repository().findById(incomeVerifiedE.get???()).ifPresent(preApplicationA->{
            
            preApplicationA // do something
            repository().save(preApplicationA);


         });
        */

    }

    public static void statusUpdateP(AccountOpenedE accountOpenedE) {
        /** Example 1:  new item 
        PreApplicationA preApplicationA = new PreApplicationA();
        repository().save(preApplicationA);

        */

        /** Example 2:  finding and process
        
        repository().findById(accountOpenedE.get???()).ifPresent(preApplicationA->{
            
            preApplicationA // do something
            repository().save(preApplicationA);


         });
        */

    }

    public static void statusUpdateP(PreAppliedE preAppliedE) {
        /** Example 1:  new item 
        PreApplicationA preApplicationA = new PreApplicationA();
        repository().save(preApplicationA);

        */

        /** Example 2:  finding and process
        
        repository().findById(preAppliedE.get???()).ifPresent(preApplicationA->{
            
            preApplicationA // do something
            repository().save(preApplicationA);


         });
        */

    }
}
