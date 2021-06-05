package conferenceroom;

import java.util.List;

public class Company {
    private String companyName;
    private List<Building> companyBuildingList;

    Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Building> getCompanyBuildings() {
        return companyBuildingList;
    }

    public void setCompanyBuildings(List<Building> companyBuildings) {
        this.companyBuildingList = companyBuildings;
    }


}
