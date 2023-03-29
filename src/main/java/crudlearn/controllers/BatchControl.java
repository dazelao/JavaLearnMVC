package crudlearn.controllers;


import crudlearn.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/batchupdate")
public class BatchControl {
    private final PersonDAO personDAO;

    @Autowired
    public BatchControl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String butchUpdateFunc(){
        return "batch/index";
    }

    @GetMapping("/without")
    public String withoutBatch(){
        personDAO.testUpdate();
        return  "redirect:/people";
    }

    @GetMapping("/with")
    public String withBatch(){
        personDAO.testBatchUpdate();
        return  "redirect:/people";
    }
}
