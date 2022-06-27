package newaccount.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import newaccount.config.kafka.KafkaProcessor;
import newaccount.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    IncomeVerificationResultARepository incomeVerificationResultARepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPreAppliedE_IncomeVerify(
        @Payload PreAppliedE preAppliedE
    ) {
        if (!preAppliedE.validate()) return;
        PreAppliedE event = preAppliedE;
        System.out.println(
            "\n\n##### listener IncomeVerify : " + preAppliedE.toJson() + "\n\n"
        );

        // Sample Logic //
        IncomeVerificationResultA.incomeVerify(event);
    }
    // keep

}
