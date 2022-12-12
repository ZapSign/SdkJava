package failedTests.addExtraDoc;


import body.doc.ExtraDoc;
import body.doc.ExtraDocResponse;
import docs.DocRequests;
import services.JsonConverter;

public class AddExtraDocWithWrongUrlPdf {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";

        String docToken = "8245d99d-e838-4e82-b6f5-387a77435756";

        ExtraDoc extraDoc = ExtraDoc.extraDocBuilder()
                .name("Extra doc")
//              wrong url_pdf:
                .url_pdf("https://zapsign.s3.amazonaws.com/2022/1/pdf/63d19807-cbfa-4b51-8571-215ad0f4eb98/linkDontExist")
                .build();

        try {
            ExtraDocResponse extraDocResponse = new DocRequests().addExtraDoc(apiToken, docToken, extraDoc);
            String jsonExtraDocs = new JsonConverter().extraDocToJson(extraDocResponse);
            System.out.println(jsonExtraDocs);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
