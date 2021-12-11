import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;

/**
 * @author HaiLang
 * @date 2021/11/23 23:19
 */
public class BetterGsonTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        Gson gson = new Gson();
        String json = gson.toJson(list);
        //在java中不支持以下调用
        //List<Integer> result = gson.fromJson<List<Integer>>(json);
        List<Integer> result = gson.fromJson(json, new TypeToken<List<Integer>>() {
        }.getType());
        System.out.println(result);
    }
}
