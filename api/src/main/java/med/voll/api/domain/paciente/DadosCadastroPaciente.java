package med.voll.api.domain.paciente;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroPaciente(
		@NotBlank(message = "O campo nome é obrigatório")
		String nome,
		
		@NotBlank(message = "O campo e-mail é obrigatório")
		@Email(message = "E-mail inválido")
		String email, 
		
		@NotBlank(message = "O campo telefone é obrigatório")
		String telefone, 
		
		@NotBlank(message = "O campo CPF é obrigatório")
		@CPF(message = "CPF inválido")
		String cpf, 
		
		@NotNull
		@Valid
		DadosEndereco endereco) {

}
