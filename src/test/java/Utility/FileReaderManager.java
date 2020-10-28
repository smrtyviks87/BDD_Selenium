package Utility;


public class FileReaderManager {
    public String getReportConfigPath(){

        System properties = null;
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null){
            return reportConfigPath;
        }
        else{
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
        }
    }
    public static FileReaderManager getInstance(){
        return new FileReaderManager();
    }


}
