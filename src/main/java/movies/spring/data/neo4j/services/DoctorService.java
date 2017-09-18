package movies.spring.data.neo4j.services;


import movies.spring.data.neo4j.domain.Doctor;
import movies.spring.data.neo4j.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public List<Doctor> findAllLimited(Integer limit) {
        return doctorRepository.findAllLimited(limit);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
