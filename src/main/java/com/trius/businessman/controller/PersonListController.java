package com.trius.businessman.controller;

import com.trius.businessman.dao.entity.Address;
import com.trius.businessman.dao.entity.Contact;
import com.trius.businessman.dao.entity.Person;
import com.trius.businessman.dao.entity.PersonDetail;
import com.trius.businessman.dao.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PersonListController {

    
    @Autowired
    PersonService personService;

    @RequestMapping("/person-list")
    public  String get(Model model){

        List<Person> list = new ArrayList<>();
        List<Address> listAddress = new ArrayList<>();
        List<Contact> listContact = new ArrayList<>();

        list=personService.findAll();

        for(int i=0;i<list.size();i++) {

            for (Address t : list.get(i).getAddressSet())
                listAddress.add(t);

        }

        model.addAttribute("listPerson",list);
        model.addAttribute("listAddress",listAddress);


        return "person-list";
    }
}
