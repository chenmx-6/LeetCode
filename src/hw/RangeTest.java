package hw;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;

/**
 * @Description 类功能简要描述
 * @Author chenmx
 * @Date 2025-12-11 15:39
 */
public class RangeTest {

    public static void main(String[] args) {
        String processIdStr = "142";
        ArrayList<Long> processIds = new ArrayList<>();
        if (processIdStr.length()!=0) {
            String[] codes = processIdStr.split(",");
            if(codes!=null&&codes.length!=0){
                for (String code : codes) {
                    processIds.add(Long.parseLong(code));
                }
            }
        }
        System.out.println(processIds);
    }
}
