package rest.controllers;

import db.repositories.StubEntityRepository;
import model.stubs.StubEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2016-08-20.
 */

@RestController
public class BaseController {

    @Autowired
    StubEntityRepository stubEntityRepository;

    @RequestMapping(value="/")
    public List<StubEntity> getAllEntities() {
        return (List<StubEntity>) stubEntityRepository.findAll();
    }

    @RequestMapping(value="/testSave")
    public void generateDummyData() {
        StubEntity stub1 = new StubEntity("wojtek");
        StubEntity stub2 = new StubEntity("sara");
        StubEntity stub3 = new StubEntity("mateusz");
        StubEntity stub4 = new StubEntity("marcin");
        List<StubEntity> toSave = new ArrayList<StubEntity>();
        toSave.add(stub1);
        toSave.add(stub2);
        toSave.add(stub3);
        toSave.add(stub4);
        stubEntityRepository.save(toSave);
    }
}
