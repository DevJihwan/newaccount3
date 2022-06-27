package newaccount.infra;

import newaccount.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class IncomeVerificationResultAHateoasProcessor
    implements
        RepresentationModelProcessor<EntityModel<IncomeVerificationResultA>> {

    @Override
    public EntityModel<IncomeVerificationResultA> process(
        EntityModel<IncomeVerificationResultA> model
    ) {
        return model;
    }
}
