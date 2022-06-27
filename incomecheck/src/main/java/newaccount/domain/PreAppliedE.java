package newaccount.domain;

import java.util.Date;
import java.util.Map;
import lombok.Data;
import newaccount.domain.*;
import newaccount.infra.AbstractEvent;

@Data
public class PreAppliedE extends AbstractEvent {

    private Long id;
    private String appliedStatus;
    private String custNo;
    private String regNo;
    // keep

}
