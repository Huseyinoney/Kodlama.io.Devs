package Kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.devs.entities.concretes.Technology;

public interface TechnologyRepository  extends JpaRepository<Technology, Integer>{

}
