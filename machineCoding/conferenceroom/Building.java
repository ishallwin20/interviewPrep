package conferenceroom;

import java.util.List;

public class Building {
    private String buildingName;
    private List<Floor> floorList;

    Building(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<Floor> getFloorDetails() {
        return floorList;
    }

    public void setFloorDetails(List<Floor> floorDetails) {
        this.floorList = floorDetails;
    }
}
