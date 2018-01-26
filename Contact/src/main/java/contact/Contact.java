package contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import contact.ContactForm;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nom;
	private String prenom;
	private String num;
	private String mail;
	private String adresse;
	private String CP;
	private String ville;

	protected Contact() {}
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

    public Contact(String lastName, String firstName, String phoneNumber, String email, String adress, String postalCode, String city) {
        this.prenom = firstName;
        this.nom = lastName;
        this.num = phoneNumber;
        this.mail = email;
        this.adresse = adress;
        this.CP = postalCode;
        this.ville = city;
    }
    
    public void setContactForm(ContactForm contactForm)
    {
        nom=contactForm.getNom();
        prenom=contactForm.getPrenom();
        num=contactForm.getNum();
        mail= contactForm.getMail();
        adresse= contactForm.getAdresse();
        CP=contactForm.getCP();
        ville=contactForm.getVille();
    }

}