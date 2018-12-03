package Test;


import org.springframework.util.StringUtils;

import java.util.UUID;

public class MyTest {

    public static void main(String[] args){
        String str = " ";
        System.out.println(StringUtils.isEmpty(null));

        String a = "f";
        System.out.println(Integer.parseInt(a,16));

        System.out.println(UUID.randomUUID().toString());
    }
}
