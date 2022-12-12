package tests.docs;

import body.doc.DocResponse;
import docs.DocRequests;
import services.JsonConverter;

public class DeleteDoc {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String docToken = "78248cee-f143-4b4f-983f-738c3c19122b";

        try {
            DocResponse docResponse = new DocRequests().deleteDoc(apiToken, docToken);

            String jsonDocResponse = new JsonConverter().docResponseToJson(docResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
