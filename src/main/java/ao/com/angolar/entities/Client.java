package ao.com.angolar.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;
    private String name;
    private String cpf;
    private Double income;

    @Column(name = "bith_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant bithDate;
    private Integer children;

    public Client() {}

    public Client(long id, String name, String cpf, Double income, Instant bithDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.bithDate = bithDate;
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Instant getBithDate() {
        return bithDate;
    }

    public void setBithDate(Instant bithDate) {
        this.bithDate = bithDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
