package newaccount.domain;

import newaccount.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "incomeVerificationResultAS",
    path = "incomeVerificationResultAS"
)
public interface IncomeVerificationResultARepository
    extends PagingAndSortingRepository<IncomeVerificationResultA, Long> {}
