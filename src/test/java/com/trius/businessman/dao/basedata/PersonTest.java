package com.trius.businessman.dao.basedata;


import com.trius.businessman.dao.entity.*;
import com.trius.businessman.dao.repository.*;
import com.trius.businessman.dao.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootTest
public class PersonTest {

    @Autowired
    PersonService personService;
    @Autowired
    BloodGroupRepository bloodGroupRepository;
    @Autowired
    AddressTypeRepository addressTypeRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    GenderRepository genderRepository;
    @Autowired
    MaritalStatusRepository maritalStatusRepository;
    @Autowired
    MilitaryStateRepository militaryStateRepository;
    @Autowired
    UniversityDepartmentRepository universityDepartmentRepository;
    @Autowired
    ContactTypeRepository contactTypeRepository;

    @Test
    public void addPerson() {

        Person person = Person.builder()
                .personName("nihat")
                .personSurname("SANDAL")
                .personDetail(
                        PersonDetail.builder()
                                .personDetailChildCount("2")
                                .personDetailChronicIll("Bronşit")
                                .personDetailContactPhone("1234")
                                .personDetailGraduateYear("2019")
                                .personDetailUniversityName("Trakya Üniversitesi")
                                .universityDepartment(universityDepartmentRepository.findByUniversityDepartmentId(2))
                                .militaryState(militaryStateRepository.findByMilitaryStateId(2))
                                .build())
                .personIdentity(
                        PersonIdentity.builder()
                                .beforeSurname("Güzel")
                                .bindNumber("2")
                                .birthPlace("Üsküdar")
                                .birthYear(LocalDateTime.now())
                                .deliveryDate(LocalDateTime.now())
                                .deliveryPlace("İstanbul")
                                .deliveryReason("Yenileme")
                                .familyRowNumber("6")
                                .fatherName("Salih")
                                .idNumber("11111111111")
                                .motherName("Zekiye")
                                .registerNumber("5")
                                .rowNumber("4")
                                .serialNumber("745")
                                .bloodGroup(bloodGroupRepository.findByBloodGroupId(3))
                                .gender(genderRepository.findByGenderId(2))
                                .maritalStatus(maritalStatusRepository.findByMaritalStatusId(2))
                                .build()).build();

        person.setAddressSet(new HashSet<>(Arrays.asList(
                Address.builder()
                        .addressType(addressTypeRepository.findByAddressTypeId(1))
                        .district(districtRepository.findByDistrictId(3))
                        .addressDetail("Deneme")
                        .build()

        )));

        person.setContactSet(new HashSet<>(Arrays.asList(
                Contact.builder()
                        .contactInfo("contact deneme")
                        .contactType(contactTypeRepository.findByContactTypeId(2))
                        .build()
        )));

        personService.save(person);
    }

    @Test
    public void addAddress() {
        Person person = personService.findByPersonId(15);


        person.getAddressSet().add(addressRepository.findByAddressId(3));
        personService.save(person);

    }


}
