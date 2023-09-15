package med.voll.api.domain.consulta.validacoes.cancelamento;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsultas;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsulta{
	
	@Autowired
	private ConsultaRepository repository;
	

	@Override
	public void validar(DadosCancelamentoConsultas dados) {
		var consulta = repository.getReferenceById(dados.id());
		var agora = LocalDateTime.now();
		var diferencaEmHoras = Duration.between(agora, consulta.getDate()).toHours();
		
		if(diferencaEmHoras < 24) {
			throw new ValidationException("Aconsulta 'so pode ser cancelada com antecedência minima de 24h!");
		}
		
	}

}
