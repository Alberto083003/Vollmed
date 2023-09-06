package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
		@NotBlank(message = "O campo nome é obrigatório")
		String nome,
		@NotBlank(message = "O campo email é obrigatório ")
		@Email
		String email,
		@NotBlank(message = "O campo telefone é obrigatório")
		String telefone,
		@NotBlank(message = "O campo CRM é obrigatório")
		@Pattern(regexp = "\\d{4,6}")
		String crm, 
		@NotNull(message = "O campo especialidade não pode ser nulo")
		Especialidade especialidade,
		@NotNull(message = "O endereço não pode ser nulo")
		@Valid
		DadosEndereco endereco) {

}
