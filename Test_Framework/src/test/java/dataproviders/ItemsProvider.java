package dataproviders;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import pojo.ItemPrices;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ItemsProvider {

    @DataProvider(name = "getItemsDataFromJson")
    private Object[][] getItemsDataFromJson() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/itemPrices.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<ItemPrices> testData = new Gson().fromJson(dataSet, new TypeToken<List<ItemPrices>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
