/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.bibtex;

/**
 *
 * @author antti
 */
public class BibtexEncoding {
    
    public static String encodeBibtexEncoding(String s) {
        StringBuilder sb = new StringBuilder("");
        for (char c : s.toCharArray()) {
            //Character is ASCII.
            if (c < 128) {
                sb.append(c);
                continue;
            }
            switch (c) {
                case 'ä':
                    sb.append("{\\\"a}");
                    break;
                case 'Ä':
                    sb.append("{\\\"A}");
                    break;
                case 'ö':
                    sb.append("{\\\"o}");
                    break;
                case 'Ö':
                    sb.append("{\\\"O}");
                    break;
                case 'å':
                    sb.append("{\\aa}");
                    break;
                case 'Å':
                    sb.append("{\\AA}");
                    break;
                default:
                    //Not supported special, non-ascii, character.
                    sb.append("{???}");
                    break;
            }
        }
        
        return sb.toString();
    }
    
}
