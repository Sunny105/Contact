package contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Contact(String firstName, String lastName, String phoneNumber, String email, String adress, String postalCode, String city) {
        this.prenom = firstName;
        this.nom = lastName;
        this.num = phoneNumber;
        this.mail = email;
        this.adresse = adress;
        this.CP = postalCode;
        this.ville = city;
    }

}