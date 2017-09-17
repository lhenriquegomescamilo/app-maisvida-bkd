package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Doctor;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;


@RepositoryRestResource(collectionResourceRel = "doctor", path = "doctor")
public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Long> {

    @Query("MATCH (d:Doctor)<-[r:ACTED_IN]->")
    Collection<Doctor> findAllLimited(Integer limit);
}
