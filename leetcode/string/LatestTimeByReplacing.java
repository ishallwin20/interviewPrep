package string;

public class LatestTimeByReplacing {

    private final int MAX_HOUR = 23;
    private final int MAX_MIN = 59;

    private String enrichTimeComponent(String timeComponent, String timeType) {
        StringBuilder enrichedtimeComponent = new StringBuilder();
        boolean firstCharMaxReached = false;



        if(timeComponent.contains("?")) {
            if("hour".equals(timeType)) {
                if (timeComponent.charAt(0) == '?') {
                    if (timeComponent.charAt(1) == '?' || Character.getNumericValue(timeComponent.charAt(1)) < 4) {
                        enrichedtimeComponent.append("2");
                        firstCharMaxReached = true;
                    } else {
                        enrichedtimeComponent.append("1");
                    }
                } else if (Character.getNumericValue(timeComponent.charAt(0)) == 2) {
                    enrichedtimeComponent.append(timeComponent.charAt(0));
                    firstCharMaxReached = true;
                } else {
                    enrichedtimeComponent.append(timeComponent.charAt(0));
                }
            } else {
                enrichedtimeComponent.append( timeComponent.charAt(0) == '?' ? "5" : (timeComponent.charAt(0)));
            }
            enrichedtimeComponent.append( timeComponent.charAt(1) == '?' ? (firstCharMaxReached ? "3" : "9") : (timeComponent.charAt(1)) );

            return enrichedtimeComponent.toString();
        } else {
            return timeComponent;
        }
    }

    public String maximumTime(String time) {
        String hour = time.split(":")[0];
        String min = time.split(":")[1];

        hour = enrichTimeComponent(hour, "hour");
        min = enrichTimeComponent(min, "min");



        return (hour + ":" + min);
    }
    public static void main(String[] args) {
        LatestTimeByReplacing latestTimeByReplacing = new LatestTimeByReplacing();

        System.out.println(latestTimeByReplacing.maximumTime("2?:?0"));
        System.out.println(latestTimeByReplacing.maximumTime("0?:3?"));
        System.out.println(latestTimeByReplacing.maximumTime("1?:22"));
        System.out.println(latestTimeByReplacing.maximumTime("?8:22"));
        System.out.println(latestTimeByReplacing.maximumTime("?3:22"));
    }
}
