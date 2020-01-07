package com.trius.businessman.dao.service.impl;


import com.trius.businessman.dao.dto.*;
import com.trius.businessman.dao.dto.PersonAddressDTO;
import com.trius.businessman.dao.entity.*;
import com.trius.businessman.dao.repository.*;
import com.trius.businessman.dao.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class PersonServiceImp implements PersonService {


    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressTypeRepository addressTypeRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    BloodGroupRepository bloodGroupRepository;
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

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person person){return  personRepository.save(person);}

    @Override
    public void deletePerson(Integer id) {

        personRepository.delete(personRepository.findByPersonId(id));

    }

    @Override
    public List<Person> findAll() {
     return   personRepository.findAll();
    }

    public Person findByPersonId(Integer id) {
        return personRepository.findByPersonId(id);
    }

    public PersonAddressDTO addPersonAddress(PersonAddressDTO personAddressDTO) {

        Person person = findByPersonId(personAddressDTO.getPersonId());
        Address address = Address.builder()
                .addressId(personAddressDTO.getAddressDTO().getAddressId())
                .addressDetail(personAddressDTO.getAddressDTO().getAddressDetail())
                .addressType(convertAddressTypeDTOToEntity(personAddressDTO.getAddressDTO().getAddressTypeDTO()))
                .district(convertDistrictDTOToEntity(personAddressDTO.getAddressDTO().getDistrictDTO()))
                .build();

        person.getAddressSet().add(addressRepository.save(address));
        save(person);
        return convertPersonToPersonAddressDTO(person, addressRepository.findByAddressId(address.getAddressId()));
    }

    public PersonContactDTO addPersonContact(PersonContactDTO personContactDTO) {

        Person person = findByPersonId(personContactDTO.getPersonId());
        Contact contact = Contact.builder()
                .contactId(personContactDTO.getContactDTO().getContactId())
                .contactInfo(personContactDTO.getContactDTO().getContactInfo())
                .contactType(convertContactTypeDTOToEntity(personContactDTO.getContactDTO().getContactTypeDTO()))
                .build();

        Contact newContact=contactRepository.save(contact);
        person.getContactSet().add(newContact);
        save(person);

        return convertPersonToPersonContactDTO(person,newContact);
    }

    public void deleteAddress(Integer person_id,Integer address_id){

            Person person = personRepository.findByPersonId(person_id);
            person.getAddressSet().removeAll(person.getAddressSet().stream().filter(address -> address.getAddressId().equals(address_id)).collect(Collectors.toList()));
            addressRepository.delete(addressRepository.findByAddressId(address_id));
            personRepository.save(person);

    }

    public void deleteContact(Integer person_id,Integer contact_id){

            Person person = personRepository.findByPersonId(person_id);
            person.getContactSet().removeAll(person.getContactSet().stream().filter(contact -> contact.getContactId().equals(contact_id)).collect(Collectors.toList()));
            contactRepository.delete(contactRepository.findByContactId(contact_id));
            personRepository.save(person);

    }



    // CONVERT DTO TO ENTİTY

    public Person convertPersonDTOToEntity(PersonDTO personDTO) {
        Person person = Person.builder()

                .personId(personDTO.getPersonId())
                .personName(personDTO.getPersonName())
                .personSurname(personDTO.getPersonSurname())

                .personDetail(PersonDetail.builder()
                        .personDetailId(personDTO.getPersonDetailDTO().getPersonDetailId())
                        .personDetailChildCount(personDTO.getPersonDetailDTO().getPersonDetailChildCount())
                        .personDetailChronicIll(personDTO.getPersonDetailDTO().getPersonDetailChronicIll())
                        .personDetailContactPhone(personDTO.getPersonDetailDTO().getPersonDetailContactPhone())
                        .personDetailGraduateYear(personDTO.getPersonDetailDTO().getPersonDetailGraduateYear())
                        .personDetailUniversityName(personDTO.getPersonDetailDTO().getPersonDetailUniversityName())

                        .militaryState(convertMilitaryStateDTOToEntity(personDTO.getPersonDetailDTO().getMilitaryStateDTO()))
                        .universityDepartment(convertUniversityDepartmentDTOToEntity(personDTO.getPersonDetailDTO().getUniversityDepartmentDTO()))
                        .build())

                .personIdentity(
                        PersonIdentity.builder()
                                .personIdentityId(personDTO.getPersonIdentityDTO().getPersonIdentityId())
                                .beforeSurname(personDTO.getPersonIdentityDTO().getBeforeSurname())
                                .bindNumber(personDTO.getPersonIdentityDTO().getBindNumber())
                                .birthPlace(personDTO.getPersonIdentityDTO().getBirthPlace())
                                .birthYear(personDTO.getPersonIdentityDTO().getBirthYear())
                                .deliveryDate(personDTO.getPersonIdentityDTO().getDeliveryDate())
                                .deliveryPlace(personDTO.getPersonIdentityDTO().getDeliveryPlace())
                                .deliveryReason(personDTO.getPersonIdentityDTO().getDeliveryReason())
                                .familyRowNumber(personDTO.getPersonIdentityDTO().getFamilyRowNumber())
                                .fatherName(personDTO.getPersonIdentityDTO().getFatherName())
                                .idNumber(personDTO.getPersonIdentityDTO().getIdNumber())
                                .motherName(personDTO.getPersonIdentityDTO().getMotherName())
                                .registerNumber(personDTO.getPersonIdentityDTO().getRegisterNumber())
                                .rowNumber(personDTO.getPersonIdentityDTO().getRowNumber())
                                .serialNumber(personDTO.getPersonIdentityDTO().getSerialNumber())

                                .bloodGroup(convertBloodGroupDTOToEntity(personDTO.getPersonIdentityDTO().getBloodGroupDTO()))
                                .gender(convertGenderDTOToEntity(personDTO.getPersonIdentityDTO().getGenderDTO()))
                                .maritalStatus(convertMaritalStatusDTOToEntity(personDTO.getPersonIdentityDTO().getMaritalStatusDTO()))
                                .build())

                .addressSet(new HashSet<>(Arrays.asList(
                        Address.builder()
                                .addressId(personDTO.getAddressDTO().getAddressId())
                                .addressDetail(personDTO.getAddressDTO().getAddressDetail())
                                .addressType(convertAddressTypeDTOToEntity(personDTO.getAddressDTO().getAddressTypeDTO()))
                                .district(convertDistrictDTOToEntity(personDTO.getAddressDTO().getDistrictDTO()))
                                .build())))

                .contactSet(new HashSet<>(Arrays.asList(
                        Contact.builder()
                                .contactId(personDTO.getContactDTO().getContactId())
                                .contactInfo(personDTO.getContactDTO().getContactInfo())
                                .contactType(convertContactTypeDTOToEntity(personDTO.getContactDTO().getContactTypeDTO()))
                                .build())))
                .build();

        return person;
    }

    private ContactType convertContactTypeDTOToEntity(ContactTypeDTO contactTypeDTO) {
        ContactType contactType = contactTypeRepository.findByContactTypeId(contactTypeDTO.getContactTypeId());
        return contactType;
    }

    private AddressType convertAddressTypeDTOToEntity(AddressTypeDTO addressTypeDTO) {
        AddressType addressType = addressTypeRepository.findByAddressTypeId(addressTypeDTO.getAddressTypeId());
        return addressType;
    }

    private District convertDistrictDTOToEntity(DistrictDTO districtDTO) {
        District district = districtRepository.findByDistrictId(districtDTO.getDistrictId());
        return district;
    }

    private UniversityDepartment convertUniversityDepartmentDTOToEntity(UniversityDepartmentDTO universityDepartmentDTO) {
        UniversityDepartment universityDepartment = universityDepartmentRepository.findByUniversityDepartmentId(universityDepartmentDTO.getUniversityDepartmentId());
        return universityDepartment;
    }

    private MilitaryState convertMilitaryStateDTOToEntity(MilitaryStateDTO militaryStateDTO) {
        MilitaryState militaryState = militaryStateRepository.findByMilitaryStateId(militaryStateDTO.getMilitaryStateId());
        return militaryState;
    }

    private MaritalStatus convertMaritalStatusDTOToEntity(MaritalStatusDTO maritalStatusDTO) {
        MaritalStatus maritalStatus = maritalStatusRepository.findByMaritalStatusId(maritalStatusDTO.getMaritalStatusId());
        return maritalStatus;
    }

    private Gender convertGenderDTOToEntity(GenderDTO genderDTO) {
        Gender gender = genderRepository.findByGenderId(genderDTO.getGenderId());
        return gender;
    }

    private BloodGroup convertBloodGroupDTOToEntity(BloodGroupDTO bloodGroupDTO) {
        BloodGroup bloodGroup = bloodGroupRepository.findByBloodGroupId(bloodGroupDTO.getBloodGroupId());
        return bloodGroup;
    }


    // CONVERT ENTİTY TO DTO

    public PersonDTO convertPersonToDTO(Person person) {

        PersonDTO personDTO = PersonDTO.builder()
                .personId(person.getPersonId())
                .personName(person.getPersonName())
                .personSurname(person.getPersonSurname())

                .personDetailDTO(PersonDetailDTO.builder()
                        .personDetailId(person.getPersonDetail().getPersonDetailId())
                        .personDetailChildCount(person.getPersonDetail().getPersonDetailChildCount())
                        .personDetailChronicIll(person.getPersonDetail().getPersonDetailChronicIll())
                        .personDetailContactPhone(person.getPersonDetail().getPersonDetailContactPhone())
                        .personDetailGraduateYear(person.getPersonDetail().getPersonDetailGraduateYear())
                        .personDetailUniversityName(person.getPersonDetail().getPersonDetailUniversityName())
                        .universityDepartmentDTO(convertUniversityDepartmentToDTO(person.getPersonDetail().getUniversityDepartment()))
                        .militaryStateDTO(convertMilitaryStateToDTO(person.getPersonDetail().getMilitaryState()))
                        .build())

                .personIdentityDTO(PersonIdentityDTO.builder()
                        .personIdentityId(person.getPersonIdentity().getPersonIdentityId())
                        .beforeSurname(person.getPersonIdentity().getBeforeSurname())
                        .birthPlace(person.getPersonIdentity().getBirthPlace())
                        .birthYear(person.getPersonIdentity().getBirthYear())
                        .deliveryDate(person.getPersonIdentity().getDeliveryDate())
                        .deliveryPlace(person.getPersonIdentity().getDeliveryPlace())
                        .deliveryReason(person.getPersonIdentity().getDeliveryReason())
                        .familyRowNumber(person.getPersonIdentity().getFamilyRowNumber())
                        .fatherName(person.getPersonIdentity().getFatherName())
                        .idNumber(person.getPersonIdentity().getIdNumber())
                        .motherName(person.getPersonIdentity().getMotherName())
                        .registerNumber(person.getPersonIdentity().getRegisterNumber())
                        .rowNumber(person.getPersonIdentity().getRowNumber())
                        .serialNumber(person.getPersonIdentity().getSerialNumber())

                        .bloodGroupDTO(convertBloodGroupToDTO(person.getPersonIdentity().getBloodGroup()))
                        .genderDTO(convertGenderToDTO(person.getPersonIdentity().getGender()))
                        .maritalStatusDTO(convertMaritalStatusToDTO(person.getPersonIdentity().getMaritalStatus()))
                        .build())

                .addressDTO(AddressDTO.builder()
                        .addressId(((Address) person.getAddressSet().toArray()[0]).getAddressId())
                        .addressDetail(((Address) person.getAddressSet().toArray()[0]).getAddressDetail())

                        .addressTypeDTO(convertAddressTypeToDTO(((Address) person.getAddressSet().toArray()[0]).getAddressType()))
                        .districtDTO(convertDistrictToDTO((((Address) person.getAddressSet().toArray()[0]).getDistrict())))
                        .cityDTO(convertCityToDTO((((Address) person.getAddressSet().toArray()[0]).getDistrict().getCity())))
                        .countryDTO(convertCountryToDTO((((Address) person.getAddressSet().toArray()[0]).getDistrict().getCity().getCountry())))
                        .build())

                .contactDTO(ContactDTO.builder()
                        .contactId(((Contact) person.getContactSet().toArray()[0]).getContactId())
                        .contactInfo(((Contact) person.getContactSet().toArray()[0]).getContactInfo())
                        .contactTypeDTO(convertContactTypeToDTO(((Contact) person.getContactSet().toArray()[0]).getContactType()))
                        .build())
                .build();

        return personDTO;
    }

    private ContactTypeDTO convertContactTypeToDTO(ContactType contactType) {

        ContactTypeDTO contactTypeDTO = new ContactTypeDTO();
        contactTypeDTO.setContactTypeId(contactType.getContactTypeId());
        contactTypeDTO.setContactTypeName(contactType.getContactTypeName());
        return contactTypeDTO;
    }

    private UniversityDepartmentDTO convertUniversityDepartmentToDTO(UniversityDepartment universityDepartment) {
        UniversityDepartmentDTO universityDepartmentDTO = new UniversityDepartmentDTO();
        universityDepartmentDTO.setUniversityDepartmentId(universityDepartment.getUniversityDepartmentId());
        universityDepartmentDTO.setUniversityDepartmentName(universityDepartment.getUniversityDepartmentName());
        return universityDepartmentDTO;
    }

    private MilitaryStateDTO convertMilitaryStateToDTO(MilitaryState militaryState) {
        MilitaryStateDTO militaryStateDTO = new MilitaryStateDTO();
        militaryStateDTO.setMilitaryStateId(militaryState.getMilitaryStateId());
        militaryStateDTO.setMilitaryStateName(militaryState.getMilitaryStateName());
        return militaryStateDTO;
    }

    private MaritalStatusDTO convertMaritalStatusToDTO(MaritalStatus maritalStatus) {
        MaritalStatusDTO maritalStatusDTO = new MaritalStatusDTO();
        maritalStatusDTO.setMaritalStatusId(maritalStatus.getMaritalStatusId());
        maritalStatusDTO.setMaritalStatusName(maritalStatus.getMaritalStatusName());
        return maritalStatusDTO;
    }

    private GenderDTO convertGenderToDTO(Gender gender) {
        GenderDTO genderDTO = new GenderDTO();
        genderDTO.setGenderId(gender.getGenderId());
        genderDTO.setGenderName(gender.getGenderName());
        return genderDTO;
    }

    private BloodGroupDTO convertBloodGroupToDTO(BloodGroup bloodGroup) {
        BloodGroupDTO bloodGroupDTO = new BloodGroupDTO();
        bloodGroupDTO.setBloodGroupId(bloodGroup.getBloodGroupId());
        bloodGroupDTO.setBloodGroupName(bloodGroup.getBloodGroupName());
        return bloodGroupDTO;
    }

    private CountryDTO convertCountryToDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryId(country.getCountryId());
        countryDTO.setCountryName(country.getCountryName());
        return countryDTO;
    }

    private AddressTypeDTO convertAddressTypeToDTO(AddressType addressType) {
        AddressTypeDTO addressTypeDTO = new AddressTypeDTO();
        addressTypeDTO.setAddressTypeId(addressType.getAddressTypeId());
        addressTypeDTO.setAddressTypeName(addressType.getAddressTypeName());
        return addressTypeDTO;
    }

    private CityDTO convertCityToDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityId(city.getCityId());
        cityDTO.setCityName(city.getCityName());
        cityDTO.setCityCode(city.getCityCode());
        cityDTO.setCityPlateCode(city.getCityPlateCode());
        return cityDTO;
    }

    private DistrictDTO convertDistrictToDTO(District district) {
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setDistrictId(district.getDistrictId());
        districtDTO.setDistrictName(district.getDistrictName());

        return districtDTO;
    }

    private PersonAddressDTO convertPersonToPersonAddressDTO(Person person, Address address) {
        PersonAddressDTO personAddressDTO = PersonAddressDTO.builder()
                .personId(person.getPersonId())
                .personName(person.getPersonName())
                .personSurname(person.getPersonSurname())

                .personDetailDTO(PersonDetailDTO.builder()
                        .personDetailId(person.getPersonDetail().getPersonDetailId())
                        .personDetailChildCount(person.getPersonDetail().getPersonDetailChildCount())
                        .personDetailChronicIll(person.getPersonDetail().getPersonDetailChronicIll())
                        .personDetailContactPhone(person.getPersonDetail().getPersonDetailContactPhone())
                        .personDetailGraduateYear(person.getPersonDetail().getPersonDetailGraduateYear())
                        .personDetailUniversityName(person.getPersonDetail().getPersonDetailUniversityName())
                        .universityDepartmentDTO(convertUniversityDepartmentToDTO(person.getPersonDetail().getUniversityDepartment()))
                        .militaryStateDTO(convertMilitaryStateToDTO(person.getPersonDetail().getMilitaryState()))
                        .build())

                .personIdentityDTO(PersonIdentityDTO.builder()
                        .personIdentityId(person.getPersonIdentity().getPersonIdentityId())
                        .beforeSurname(person.getPersonIdentity().getBeforeSurname())
                        .birthPlace(person.getPersonIdentity().getBirthPlace())
                        .birthYear(person.getPersonIdentity().getBirthYear())
                        .deliveryDate(person.getPersonIdentity().getDeliveryDate())
                        .deliveryPlace(person.getPersonIdentity().getDeliveryPlace())
                        .deliveryReason(person.getPersonIdentity().getDeliveryReason())
                        .familyRowNumber(person.getPersonIdentity().getFamilyRowNumber())
                        .fatherName(person.getPersonIdentity().getFatherName())
                        .idNumber(person.getPersonIdentity().getIdNumber())
                        .motherName(person.getPersonIdentity().getMotherName())
                        .registerNumber(person.getPersonIdentity().getRegisterNumber())
                        .rowNumber(person.getPersonIdentity().getRowNumber())
                        .serialNumber(person.getPersonIdentity().getSerialNumber())

                        .bloodGroupDTO(convertBloodGroupToDTO(person.getPersonIdentity().getBloodGroup()))
                        .genderDTO(convertGenderToDTO(person.getPersonIdentity().getGender()))
                        .maritalStatusDTO(convertMaritalStatusToDTO(person.getPersonIdentity().getMaritalStatus()))
                        .build())
                .addressDTO(AddressDTO.builder()
                        .addressId(address.getAddressId())
                        .addressDetail(address.getAddressDetail())
                        .addressTypeDTO(convertAddressTypeToDTO(address.getAddressType()))
                        .districtDTO(convertDistrictToDTO(address.getDistrict()))
                        .cityDTO(convertCityToDTO(address.getDistrict().getCity()))
                        .countryDTO(convertCountryToDTO(address.getDistrict().getCity().getCountry()))

                        .build())
                .build();

        return personAddressDTO;
    }

    private PersonContactDTO convertPersonToPersonContactDTO(Person person, Contact contact) {
        PersonContactDTO personContactDTO = PersonContactDTO.builder()
                .personId(person.getPersonId())
                .personName(person.getPersonName())
                .personSurname(person.getPersonSurname())

                .personDetailDTO(PersonDetailDTO.builder()
                        .personDetailId(person.getPersonDetail().getPersonDetailId())
                        .personDetailChildCount(person.getPersonDetail().getPersonDetailChildCount())
                        .personDetailChronicIll(person.getPersonDetail().getPersonDetailChronicIll())
                        .personDetailContactPhone(person.getPersonDetail().getPersonDetailContactPhone())
                        .personDetailGraduateYear(person.getPersonDetail().getPersonDetailGraduateYear())
                        .personDetailUniversityName(person.getPersonDetail().getPersonDetailUniversityName())
                        .universityDepartmentDTO(convertUniversityDepartmentToDTO(person.getPersonDetail().getUniversityDepartment()))
                        .militaryStateDTO(convertMilitaryStateToDTO(person.getPersonDetail().getMilitaryState()))
                        .build())

                .personIdentityDTO(PersonIdentityDTO.builder()
                        .personIdentityId(person.getPersonIdentity().getPersonIdentityId())
                        .beforeSurname(person.getPersonIdentity().getBeforeSurname())
                        .birthPlace(person.getPersonIdentity().getBirthPlace())
                        .birthYear(person.getPersonIdentity().getBirthYear())
                        .deliveryDate(person.getPersonIdentity().getDeliveryDate())
                        .deliveryPlace(person.getPersonIdentity().getDeliveryPlace())
                        .deliveryReason(person.getPersonIdentity().getDeliveryReason())
                        .familyRowNumber(person.getPersonIdentity().getFamilyRowNumber())
                        .fatherName(person.getPersonIdentity().getFatherName())
                        .idNumber(person.getPersonIdentity().getIdNumber())
                        .motherName(person.getPersonIdentity().getMotherName())
                        .registerNumber(person.getPersonIdentity().getRegisterNumber())
                        .rowNumber(person.getPersonIdentity().getRowNumber())
                        .serialNumber(person.getPersonIdentity().getSerialNumber())

                        .bloodGroupDTO(convertBloodGroupToDTO(person.getPersonIdentity().getBloodGroup()))
                        .genderDTO(convertGenderToDTO(person.getPersonIdentity().getGender()))
                        .maritalStatusDTO(convertMaritalStatusToDTO(person.getPersonIdentity().getMaritalStatus()))
                        .build())
                .contactDTO(ContactDTO.builder()
                        .contactId(contact.getContactId())
                        .contactInfo(contact.getContactInfo())
                        .contactTypeDTO(convertContactTypeToDTO(contact.getContactType()))
                        .build())
                .build();

        return personContactDTO;
    }

}
