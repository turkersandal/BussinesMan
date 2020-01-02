package com.trius.businessman.dao.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "company_contract",
            joinColumns = {@JoinColumn(name = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "contract_id")})
    private Set<Contract> contractSet;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "company_address",
            joinColumns = {@JoinColumn(name = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private Set<Address> addressSet;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "company_contact",
            joinColumns = {@JoinColumn(name = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "contact_id")})
    private Set<Contact> contactSet;

    @ManyToOne
    @JoinColumn(name = "company_sector_id")
    private CompanySector companySector;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_auth_full_name")
    private String companyAuthFullName;

    @Column(name = "company_tax_number")
    private String companyTaxNumber;

}
