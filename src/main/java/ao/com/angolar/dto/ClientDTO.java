package ao.com.angolar.dto;

import ao.com.angolar.entities.Client;
import jakarta.persistence.Column;

import java.time.Instant;

public class ClientDTO {

    private long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant bithDate;
    private Integer children;

    public ClientDTO () {}

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.bithDate = client.getBithDate();
        this.children = client.getChildren();
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
