package com.bootcamp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


//@JsonPropertyOrder({"id","documentNumber","phoneNumber","email","balance","createdAt","updateAt"})
@Document(collection = "wallet")
@Data
public class Wallet {

    @Id
    private String id;

    @NotEmpty
    @Field(name = "document_number")
    private String documentNumber;

    @NotEmpty
    @Field(name = "phone_number")
    private String phoneNumber;

    @Email
    private String email;

    private Double balance;
}
