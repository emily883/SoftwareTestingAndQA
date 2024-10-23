import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    public boolean deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
        return true;
    }

    public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
        return true;
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
