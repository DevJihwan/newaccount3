package newaccount.domain;

import java.util.Date;
import java.util.List;
import java.util.*;
import javax.persistence.*;

import org.springframework.beans.BeanUtils;

import lombok.Data;
import newaccount.IncomecheckApplication;
import newaccount.domain.IncomeVerifiedE;
import newaccount.external.ExternalCheck;

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

       
            
    }

    public static IncomeVerificationResultARepository repository() {
        IncomeVerificationResultARepository incomeVerificationResultARepository = IncomecheckApplication.applicationContext.getBean(
            IncomeVerificationResultARepository.class
        );
        return incomeVerificationResultARepository;
    }

    public static void incomeVerify(PreAppliedE preAppliedE) {
        IncomeVerificationResultA incomeVerificationResultA = new IncomeVerificationResultA();
        BeanUtils.copyProperties(preAppliedE, incomeVerificationResultA);

        
        System.out.println("-------incomeVerify(PreAppliedE preAppliedE)-----------------------------------------------------------------") ;

        System.out.println("getRegNo=>: " + incomeVerificationResultA.getRegNo());

        System.out.println("------------------------------------------------------------------------") ;

        // mappings goes here
        newaccount.external.ExternalCheck checkResult = IncomecheckApplication.applicationContext
            .getBean(newaccount.external.ExternalCheckService.class)
            .externalCheck(incomeVerificationResultA.getRegNo());         
                    
        System.out.println("------------------------------------------------------------------------") ;
        System.out.println("사전등록 Event -> 소득검증 Policy 호출 ");
        System.out.println("------------------------------------------------------------------------") ;
        
        //Random rand = new Random();
        //int iValue = 10000000 * rand.nextInt(10);

        incomeVerificationResultA.setCustNo(preAppliedE.getCustNo()); 

        Long iValue = checkResult.getIncomeExtAmt();  
     
        // 소득금액 5000만원 이상이면 소득검증결과 Y , 상태정보 PASSED
        if(iValue > 50000000)
        {
            incomeVerificationResultA.setVerifyResult("Y");
            incomeVerificationResultA.setAppliedStatus("PASSED");
        
        }
        // 소득금액 5000만원 이상이면 소득검증결과 N , 상태정보 FAILED
        else
        {
            incomeVerificationResultA.setVerifyResult("N");
            incomeVerificationResultA.setAppliedStatus("FAILED");
        }
        
        // 결과값 저장 
        repository().save(incomeVerificationResultA);

        System.out.println("---소득검증---------------------------------------------------------------------") ;
        System.out.println("고객번호 :" + incomeVerificationResultA.getCustNo());
        System.out.println("실명번호 :" + incomeVerificationResultA.getRegNo());
        System.out.println("상태정보 :" + incomeVerificationResultA.getAppliedStatus());
        System.out.println("소득금액 :" + incomeVerificationResultA.getIncomeAmount());
        System.out.println("------------------------------------------------------------------------") ;            
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
