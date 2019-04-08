package dev.codenation.gestaohospital.hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import dev.codenation.gestaohospital.estoque.Estoque;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository repository;
	
	public Page<Hospital> pesquisar(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Optional<Hospital> obterPorId(String id) {
		return repository.findById(id);
	}
	
	public Hospital cadastrar(Hospital hospital) {
		return repository.insert(hospital);
	}

	public GeoResults<Hospital> localizar(double longitude, double latitude, double distancia) {
		return repository.findByLocationNear(new Point(longitude, latitude), new Distance(distancia, Metrics.KILOMETERS));
	}

	public List<Estoque> listarEstoque(String id) {
		return repository.findById(id).map(Hospital::getEstoque).orElse(Collections.emptyList());
	}

}
