package med.voll.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Page<Paciente> findAllByAtivosTrue(Pageable paginacao);

	@Query("select p.ativos from Paciente p where p.id = :id")
	Boolean findAtivosById(@Param("id") Long id);



}
