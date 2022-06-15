import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Utility {


    public static String mockLogin() {
        //Login successfully first
        ResponseWithAccessToken res = Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                .field("email", "ludlz@gmail.com")
                .field("password", "123456")
                .asObject(ResponseWithAccessToken.class)//ObjectMapper
                .getBody();
        //If successfully login, return access token for use
        return res.data.access_token;
    }

    public static String chooseBaseUrl() {
        Scanner sc = new Scanner(System.in);
        String baseUrl = "https://auctions-app-2.herokuapp.com/api/";//default
        String baseUrlID;
        System.out.println("==============MENU==============");
        System.out.println("Choose base URL(1/2/3/4/Enter): ");
        System.out.println("Enter: https://auctions-app-2.herokuapp.com/api/");
        System.out.println("1: https://auctions-app-2.herokuapp.com/api/auctions/");
        System.out.println("2: https://auctions-app-2.herokuapp.com/api/comments/");
        System.out.println("3: https://auctions-app-2.herokuapp.com/api/notifications/");
        System.out.println("4: https://auctions-app-2.herokuapp.com/api/bid/");
        System.out.println("5: https://auctions-app-2.herokuapp.com/api/news/");
        baseUrlID = sc.nextLine()
                .trim();
        if (!baseUrlID.isEmpty()) {
            System.out.println(baseUrlID);
            if (Constant.BASE_URL_LIST.containsKey(baseUrlID)) {
                baseUrl = Constant.BASE_URL_LIST.get(baseUrlID);
                System.out.println("Base URL is: " + baseUrl);
            } else {
                System.out.println("Wrong options");
                chooseBaseUrl();
            }
        } else {
            System.out.println("Base URL is: https://auctions-app-2.herokuapp.com/api/");
            return "0";
        }
        return baseUrlID;
    }

    public static String chooseAPIEndPoint(String baseUrlId) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> endPointList = Constant.ENDPOINT_LIST.get(baseUrlId);
        System.out.println("Choose an endpoint" + "(0-" + endPointList.size() + ")");
        int index = 0;
        for (String endPoint : endPointList) {
            System.out.println(index++ + ":/" + endPoint);

        }
        String endPointId = sc.nextLine()
                .trim();
        String testSuiteId = baseUrlId + "." + endPointId;
        return testSuiteId;
    }
}
