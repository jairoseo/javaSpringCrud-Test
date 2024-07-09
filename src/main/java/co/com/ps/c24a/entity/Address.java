package co.com.ps.c24a.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Setter
@Getter
public class Address {
    @Id
    private Long id;
    @JsonProperty("person_id")
    @Column("person_id")
    private Long personId;
    private String city;
}
