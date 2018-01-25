package contact;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @GetMapping("/Form")
    public String showForm(ContactForm contactForm) {
        return "Form";
    }

    @PostMapping("/Form")
    public String checkPersonInfo(@Valid ContactForm contactForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "Form";
        }

        return "redirect:/ListeContact";
    }
    
    @GetMapping("/ListeContact")
    public String showContacts(ContactForm contactForm) {
        return "ListeContact";
    }
}