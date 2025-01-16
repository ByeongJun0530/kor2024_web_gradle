package day61Task.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MemberEntity {
    @Id
    public String id;
    @Column
    public String pwd;
}
