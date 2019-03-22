package dev.codenation.gestaohospital.hospital;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	
	@Autowired
	private IHospitalRepository repository;
	
	public Page<Hospital> pesquisar(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Optional<Hospital> obterPorId(String id) {
		return repository.findById(id);
	}
	
	public Hospital cadastrar(Hospital hospital) {
		return repository.insert(hospital);
	}

}
