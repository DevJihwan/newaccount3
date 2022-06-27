package newaccount.domain;

import newaccount.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "incomecheck",
    path = "incomecheck"
)
public interface IncomeVerificationResultARepository
    extends PagingAndSortingRepository<IncomeVerificationResultA, Long> {}
