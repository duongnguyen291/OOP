package OOP.theory.week11;
import OOP.theory.week11.*;
public class PersonalPlannerController {
    private PersonalPlannerProfile profile;
    private BuyerRecord buyerRecord;
    private CustomerProfile customerProfile;

    public PersonalPlannerProfile getProfile() {
        return profile;
    }

    public void setProfile(PersonalPlannerProfile profile) {
        this.profile = profile;
    }

    public BuyerRecord getBuyerRecord() {
        return buyerRecord;
    }

    public void setBuyerRecord(BuyerRecord buyerRecord) {
        this.buyerRecord = buyerRecord;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }
}