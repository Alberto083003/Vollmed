package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

	Boolean existsByMedicoIdAndDateAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime date);

	Boolean existsByPacienteIdAndDateBetween(Long idPaciente, LocalDateTime primeiroHorario,
			LocalDateTime ultimoHorario);

}
