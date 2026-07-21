package model;

public class Guest {

    private String guestName;
    private String phoneNumber;
    private String email;
    private String idProof;

    public Guest(String guestName, String phoneNumber, String email, String idProof) {
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idProof = idProof;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    @Override
    public String toString() {
        return "Guest Name : " + guestName +
                "\nPhone : " + phoneNumber +
                "\nEmail : " + email +
                "\nID Proof : " + idProof;
    }
}