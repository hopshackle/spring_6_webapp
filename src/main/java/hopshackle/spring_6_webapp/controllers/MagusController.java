package hopshackle.spring_6_webapp.controllers;

import hopshackle.spring_6_webapp.services.BookService;
import hopshackle.spring_6_webapp.services.MagusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MagusController {

    private final MagusService magusService;

    public MagusController(MagusService magusService) {
        this.magusService = magusService;
    }

    @RequestMapping("/magi")
    public String getMagus(Model model) {
        model.addAttribute("allMagi", magusService.findAll());
        return "magi";  // this returns the name of the HTML template to be rendered
    }
}
