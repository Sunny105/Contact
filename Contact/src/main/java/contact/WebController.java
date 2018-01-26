package contact;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ch.qos.logback.core.net.SyslogOutputStream;
import contact.Contact;
import contact.ContactRepository;
import contact.ContactForm;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

	@Autowired
    private ContactRepository repositoryC;
	
	private Contact currentContact = null;
	
    @GetMapping("/Form")
    public String showForm(ContactForm contactForm) {
        return "Form";
    }

    @PostMapping("/Form")
    public String checkPersonInfo(@Valid ContactForm contactForm, BindingResult bindingResult) {
    if (currentContact==null){
        if (bindingResult.hasErrors()) {
            return "Form";
        }
        else {
        	repositoryC.save(new Contact(contactForm.getNom(), contactForm.getPrenom(), contactForm.getNum(),contactForm.getMail(),contactForm.getAdresse(),contactForm.getCP(),contactForm.getVille()));
        	return "redirect:/ListeContact";
        }
    }
    else {
    	if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("Form");
            return "Form";
        } else {
            currentContact.setContactForm(contactForm);
            repositoryC.save(currentContact);
            currentContact =null;
            return "ListeContact";
        }
    }
    }
    
    @GetMapping("/ListeContact")
    public String showListeContacts() {
        return "ListeContact";
    }
    
    @ModelAttribute("contacts")
    public Iterable<Contact> getContacts(){
        return repositoryC.findAll();
    }
    
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable long id) {
        repositoryC.delete(id);
        return "redirect:/ListeContact";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView preEdit(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("Form");
        currentContact= repositoryC.findOne(id);
        ContactForm contactForm = new ContactForm();
        contactForm.setContact(currentContact);
        mav.addObject("contactForm",contactForm);
        System.out.println("Id: " + id + " id contact: "+ currentContact.getId());
        return mav;
    }
}