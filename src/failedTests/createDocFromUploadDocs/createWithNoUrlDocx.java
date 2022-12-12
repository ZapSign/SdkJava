package failedTests.createDocFromUploadDocs;

import body.doc.DocFromDocx;
import response.DocResponse;
import body.signer.Signer;
import docs.DocRequests;
import services.JsonConverter;

import java.io.IOException;
import java.util.ArrayList;

public class createWithNoUrlDocx {
    public static void main(String[] args) throws IOException, InterruptedException  {
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


        DocFromDocx docFromDocx = DocFromDocx.docFromDocxBuilder()
                .sandbox(false)
                .name("My Contract")
                .brand_primary_color("#000000")
                .lang("pt-br")
                .signers(signers)
//              Test with not url_docx
//              .url_docx("https://zapsign.s3.amazonaws.com/2022/1/docs/d7660fd2-fe74-4691-bec8-5c42c0ae2b3f/39a35070-8987-476d-86e3-75d91f588a5a.docx")
                .build();

        try {
            DocResponse docResponse = new DocRequests().createDocFromUploadDocx(apiToken, docFromDocx);
            String jsonDocResponse = new JsonConverter().docResponseToJson(docResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
