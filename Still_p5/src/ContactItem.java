public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public boolean createItem(String first, String last, String phone, String email)
    {
        if(!(isAllBlank(first, last, phone, email)))
        {
            this.firstName = first;
            this.lastName = last;
            this.phoneNumber = phone;
            this.emailAddress = email;
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean isAllBlank(String first, String last, String phone, String email)
    {
        return ( (first == "") && (last == "") && (phone == "") && (email == "") );
    }
}
