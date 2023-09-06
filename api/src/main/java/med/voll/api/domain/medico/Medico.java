package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;
@Table(name="medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	@Embedded
	private Endereco endereco;
	
	private Boolean ativos;
	
	public Medico(DadosCadastroMedico dados) {
		this.ativos=true;
		this.nome= dados.nome();
		this.email=dados.email();
		this.telefone=dados.telefone();
		this.crm=dados.crm();
		this.endereco=new Endereco(dados.endereco());
		this.especialidade=dados.especialidade();
	}
	
	public void atualizarInformacoes(DadosAtualizarMedico dados) {
		if(dados.nome()!= null) {
			this.nome=dados.nome();
		}
		if(dados.telefone()!=null) {
			this.telefone=dados.telefone();
		}
		if(dados.endereco()!=null) {
			this.endereco.atualizarEndereco(dados.endereco());
		}
	}

	public void excluir() {
		this.ativos=false;
		
	}

	

}
