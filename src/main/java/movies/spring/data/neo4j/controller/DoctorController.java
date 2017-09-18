package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Doctor;
import movies.spring.data.neo4j.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/app-maisvida/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Doctor> save(@RequestBody Doctor doctor) {
        Doctor doctorSaved = doctorService.save(doctor);
        return ResponseEntity.ok().body(doctorSaved);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Doctor>> getAll(@RequestParam(value = "limit", required = false) Integer limit) {
        limit = Optional.ofNullable(limit).orElse(100);
        List<Doctor> doctors = doctorService.findAllLimited(limit);
        return ResponseEntity.ok().body(doctors);
    }
}
