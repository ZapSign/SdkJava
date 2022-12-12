package tests.docs;

import response.DocsResponse;
import docs.DocRequests;
import services.JsonConverter;

public class GetDocs {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";

        try {
            DocsResponse docsResponse = new DocRequests(apiToken).getDocs();

            String jsonDocResponse = new JsonConverter().docsResponseToJson(docsResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
