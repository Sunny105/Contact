package contact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import contact.Contact;

public class ContactForm {
	@NotNull
	@Size(min=2, max=30)
	private String nom;
	
	@NotNull
	@Size(min=2, max=30)
	private String prenom;
	
	@Pattern(regexp="([0-9]{10})", message="Numero de telephone incorrect")
	private String num;
	
	@Email
	private String mail;
	
	@NotNull
	private String adresse;
	
	@Pattern(regexp="([0-9]{5})", message="Code postal incorrect")
	private String CP;
	
	@NotNull
	@Size(min=2)
	private String ville;
	
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
	
	public void setContact(Contact contact)
    {
        nom=contact.getNom();
        prenom=contact.getPrenom();
        num=contact.getNum();
        mail= contact.getMail();
        adresse= contact.getAdresse();
        CP= contact.getCP();
        ville= contact.getVille();
    }
}
