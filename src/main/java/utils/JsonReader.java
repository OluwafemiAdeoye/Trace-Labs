package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public static Object[][] getJSONData(String JSON_Path, String JSON_Data, int JSON_Attributes) throws IOException, ParseException {

        Object object = new JSONParser().parse(new FileReader(JSON_Path));
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(JSON_Data);

        Object[][] array = new String[jsonArray.size()][JSON_Attributes];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            array[i][0] = String.valueOf(jsonObject1.get("validUsername"));
            array[i][1] = String.valueOf(jsonObject1.get("validemailAddress"));
            array[i][2] = String.valueOf(jsonObject1.get("validPassword"));
            array[i][3] = String.valueOf(jsonObject1.get("validConfirmPassword"));
        }

        for (int i = 1; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            array[i][0] = String.valueOf(jsonObject1.get("validUsername"));
            array[i][1] = String.valueOf(jsonObject1.get("existingemailAddress"));
            array[i][2] = String.valueOf(jsonObject1.get("validPassword"));
            array[i][3] = String.valueOf(jsonObject1.get("validConfirmPassword"));
        }

        for (int i = 2; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            array[i][0] = String.valueOf(jsonObject1.get("emptyUsername"));
            array[i][1] = String.valueOf(jsonObject1.get("emptyEmailAddress"));
            array[i][2] = String.valueOf(jsonObject1.get("emptyPassword"));
            array[i][3] = String.valueOf(jsonObject1.get("emptyConfirmPassword"));
        }

        for (int i = 3; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            array[i][0] = String.valueOf(jsonObject1.get("wrongUsernameLength"));
            array[i][1] = String.valueOf(jsonObject1.get("invalidEmailAddress"));
            array[i][2] = String.valueOf(jsonObject1.get("wrongPasswordLength"));
            array[i][3] = String.valueOf(jsonObject1.get("wrongConfirmPasswordLength"));
        }

        for (int i = 4; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            array[i][0] = String.valueOf(jsonObject1.get("wrongUsernameLength"));
            array[i][1] = String.valueOf(jsonObject1.get("invalidEmailAddress"));
            array[i][2] = String.valueOf(jsonObject1.get("validPassword"));
            array[i][3] = String.valueOf(jsonObject1.get("wrongConfirmPassword"));
        }
        return array;
    }
}
