package newaccount.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "externalcheck", url = "${api.url.externalcheck}")
public interface ExternalCheckService {
    @RequestMapping(method = RequestMethod.GET, path = "/externalChecks/checkincome/{regNo}")
    public ExternalCheck externalCheck(@PathVariable String regNo);

    // keep

}
