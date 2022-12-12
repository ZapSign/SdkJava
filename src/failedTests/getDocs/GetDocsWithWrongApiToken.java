package failedTests.getDocs;

import body.doc.DocsResponse;
import docs.DocRequests;
import services.JsonConverter;

public class GetDocsWithWrongApiToken {
    public static void main(String[] args) throws Exception {
//      wrong token
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-test";

        try {
            DocsResponse docsResponse = new DocRequests().getDocs(apiToken);

            String jsonDocResponse = new JsonConverter().docsResponseToJson(docsResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
