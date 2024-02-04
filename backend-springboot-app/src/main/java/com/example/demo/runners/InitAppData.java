package com.example.demo.runners;

import com.example.demo.dao.DeskDAO;
import com.example.demo.dao.SrDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.entities.Desk;
import com.example.demo.entities.Sr;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitAppData implements CommandLineRunner {
    @Autowired private UserDAO userDAO;
    @Autowired private SrDAO srDAO;
    @Autowired private DeskDAO deskDAO;

    @Override
    public void run(String... args) throws Exception {
        User mz = new User(1234L, "Mohamed ZITOUNI");
        User ad = new User( 4321L, "Alex Dubois");
        User sk = new User( 1111L, "Samir Kilani");
        User az = new User( 2222L, "Amir Zoughlami");
        userDAO.save(mz);
        userDAO.save(ad);
        userDAO.save(sk);
        userDAO.save(az);

        Desk d1 = new Desk("DESK A", List.of(mz, ad, sk, az));
        Desk d2 = new Desk("DESK B", List.of(mz, sk, az));
        Desk d3 = new Desk("DESK C", List.of(sk, az));
        deskDAO.save(d1);
        deskDAO.save(d2);
        deskDAO.save(d3);

        Sr sr1 = new Sr("SR 1", d1, mz);
        Sr sr2 = new Sr("SR 2", d1, ad);
        Sr sr3 = new Sr("SR 3", d1, sk);
        Sr sr4 = new Sr("SR 4", d1, az);
        Sr sr5 = new Sr("SR 5", d2, mz);
        Sr sr6 = new Sr("SR 6", d2, sk);
        Sr sr7 = new Sr("SR 7", d2, az);
        Sr sr8 = new Sr("SR 8", d3, sk);
        Sr sr9 = new Sr("SR 9", d3, az);
        srDAO.save(sr1);
        srDAO.save(sr2);
        srDAO.save(sr3);
        srDAO.save(sr4);
        srDAO.save(sr5);
        srDAO.save(sr6);
        srDAO.save(sr7);
        srDAO.save(sr8);
        srDAO.save(sr9);
    }
}
