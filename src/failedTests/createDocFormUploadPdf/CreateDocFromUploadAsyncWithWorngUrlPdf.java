package failedTests.createDocFormUploadPdf;


import body.doc.DocAsyncResponse;
import body.doc.DocFromPdf;
import body.signer.Signer;
import docs.DocRequests;
import services.JsonConverter;

import java.util.ArrayList;

public class CreateDocFromUploadAsyncWithWorngUrlPdf {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";

        Signer signer1 = Signer.builder()
                .name("My First Signer")
                .build();

        Signer signer2 = Signer.builder()
                .name("My Second Signer")
                .email("test@test.com")
                .lock_email(true)
                .lock_phone(true)
                .phone_country("55")
                .phone_number("99999999999")
                .auth_mode("assinaturaTela")
                .send_automatic_email(false)
                .send_automatic_whatsapp(false)
                .build();

        ArrayList<Signer> signers = new ArrayList<>();
        signers.add(signer1);
        signers.add(signer2);

        DocFromPdf docFromPdf = DocFromPdf.docFromPdfBuilder()
                .sandbox(false)
                .name("My Contract")
                .brand_primary_color("#000000")
                .lang("pt-br")
                .signers(signers)
//              Test with not url_pdf
//              .url_pdf("https://zapsign.s3.amazonaws.com/2022/1/pdf/63d19807-cbfa-4b51-8571-215ad0f4eb98/test123456")
                .build();

        try {
            DocAsyncResponse docAsyncResponse = new DocRequests().createDocFromUploadAsync(apiToken, docFromPdf);
            String jsonDocResponse = new JsonConverter().docAsyncResponseToJson(docAsyncResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
