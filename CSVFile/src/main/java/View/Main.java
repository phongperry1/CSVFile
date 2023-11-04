

package View;

import Model.CSV;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ArrayList<CSV> ls = new ArrayList<>();
        ls.add(new CSV(1, "pham   Ngoc hoA", "thaycacac@gmail.com", "'0968038714", "khaNh Cong   - yEN  KhanH -    Ninh binh"));
        ls.add(new CSV(2, "NGUyen hai         nAM   ", "namhai@gmail.com", "'0984481345", "ThaCH  HOA - thach that   -   Ha noI"));
        ls.add(new CSV(3, "Nguyen   van a      	", "uyenthao@gmail.com", "'0986246814", "Cau Giay     - Ha    Noi    - Viet Nam    "));
                
    }
}
