package br.com.duxusdesafio.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "time")
public class Time {

	@Id
	@SequenceGenerator(name = "seq_time", sequenceName = "seq_time_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_time", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@NotBlank(message = "O nome não pode ser em branco")
	@Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	@Temporal(TemporalType.DATE)
	@NotNull(message = "A data de fundação deve ser informada")
	@Column(name = "data_fundacao", nullable = false)
	private Calendar dataFundacao;

	@OneToMany(mappedBy = "time", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Jogador> jogadores = new ArrayList<>();

	public Time() {
	}

	public void adicionarJogador(Jogador obj) {
		obj.setTime(this);
		this.jogadores.add(obj);
	}

	public void removerJogador(int index) {
		this.jogadores.remove(index);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
    private LocalDate data;
	
	@OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
	private List<ComposicaoTime> composicaoTime;

	public Time() {
	}

	public Time(LocalDate data, List<ComposicaoTime> composicaoTime) {
		this.data = data;
		this.composicaoTime = composicaoTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ComposicaoTime> getComposicaoTime() {
		return composicaoTime;
	}

	public void setComposicaoTime(List<ComposicaoTime> composicaoTime) {
		this.composicaoTime = composicaoTime;
	}


	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Time)) return false;
		Time time = (Time) o;
		return id == time.id && Objects.equals(data, time.data);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(id, data);
	}

	@Override
	public String toString() {
		return "Time{" +
				"id=" + id +
				", data=" + data +
				'}';
	}
}
