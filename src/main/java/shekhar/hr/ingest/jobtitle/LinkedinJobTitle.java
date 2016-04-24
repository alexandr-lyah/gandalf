package shekhar.hr.ingest.jobtitle;

import com.comcast.ebi.common.fileutils.UtilitiesFile;
import com.comcast.ebi.common.urlutils.UtilitiesURL;
import shekhar.hr.utils.General;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author sagraw200
 */
public class LinkedinJobTitle {
    
    private static final String baseurl = "https://www.linkedin.com/ta/titleV2?query=";
    private static final String outputFile = "src/main/resources/data/data.ingest/linkedin.jobtitle.tmp";
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    private static UtilitiesURL uUrl;
    private static UtilitiesFile uFile;
    
    public LinkedinJobTitle() {
        uUrl = new UtilitiesURL();
        uFile = new UtilitiesFile();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(4);

        LinkedinJobTitle xyz = new LinkedinJobTitle();
        xyz.getLinkedinJobTitle(list);

    }

    /**
     * 
     * @param nums 
     */
    public void getLinkedinJobTitle(List<Integer> nums) {
        try {
            File f = new File(outputFile);
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
        } catch (Exception ex) {
            System.out.println("Error in deleting/creating file: " + ex);
        }
        
        TreeSet<String> set = new TreeSet<>();
        TreeSet<String> tmp = new TreeSet<>();
        
        if (nums.contains(1)) {
            tmp = General.getOneChar(alphabet, baseurl, uUrl);
            set.addAll(tmp); tmp.clear();
        }
        uFile.appendToFile(outputFile, General.setToBuilder(set)); set.clear();
        
        if (nums.contains(2)) {
            tmp = General.getTwoChar(alphabet, baseurl, uUrl);
            set.addAll(tmp); tmp.clear();
        }
        uFile.appendToFile(outputFile, General.setToBuilder(set)); set.clear();
        
        if (nums.contains(3)) {
            tmp = General.getThreeChar(alphabet, baseurl, uUrl);
            set.addAll(tmp); tmp.clear();
        }
        uFile.appendToFile(outputFile, General.setToBuilder(set)); set.clear();
        
        if (nums.contains(4)) {
            tmp = General.getFourChar(alphabet, baseurl, uUrl);
            set.addAll(tmp); tmp.clear();
        }
        uFile.appendToFile(outputFile, General.setToBuilder(set)); set.clear();
        
    }
    
}
