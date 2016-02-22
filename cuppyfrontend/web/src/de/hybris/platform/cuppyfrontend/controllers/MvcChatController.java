package de.hybris.platform.cuppyfrontend.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcChatController {

    @RequestMapping ("/getChatWoindow")
    public String getChatWindow (Model model) {
        model.addAttribute("messages", "mes1, mes2");
        return "chat";
    }

}
