package failedTests.detailDoc;

import response.DocResponse;
import docs.DocRequests;
import services.JsonConverter;

public class DetailDocWithWrongToken {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
//      wrong token
        String docToken = "8245d99d-e838-4e82-b6f5-test";

        try {
            DocResponse docResponse = new DocRequests().detailDoc(apiToken, docToken);

            String jsonDocResponse = new JsonConverter().docResponseToJson(docResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
