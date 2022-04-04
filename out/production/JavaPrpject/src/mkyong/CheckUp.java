package mkyong;

import java.io.IOException;

public interface CheckUp {
    boolean checkUserName(String key,String value) throws NullPointerException;
    void checkInfo() throws IOException;
}
