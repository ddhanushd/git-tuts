package com.investor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "investors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int investorId;
    private String investorName;
    private String username;
    private String password;
    private Long investorPhoneno;
    private String investorEmail;
    private String investorAddress;
}
