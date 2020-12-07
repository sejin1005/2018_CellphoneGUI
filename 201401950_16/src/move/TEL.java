
package move;

public class TEL {
    String subtel;
    
    TEL(String cb) {
        subtel = cb;
    }
    String add() {
        String Str = "010-1234-5678      >>>>>>>>>  ";
        Str = Str + subtel;
        return Str;
    }
}
