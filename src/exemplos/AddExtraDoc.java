package exemplos;


import body.doc.DocFromPdf;
import body.doc.DocResponse;
import body.doc.ExtraDoc;
import body.doc.ExtraDocResponse;
import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import docs.DocRequests;

import java.io.IOException;
import java.util.ArrayList;

public class AddExtraDoc {
    public static void main(String[] args) throws IOException, InterruptedException  {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";

        String docToken = "8245d99d-e838-4e82-b6f5-387a77435756";

        ExtraDoc extraDoc = ExtraDoc.extraDocBuilder()
                .name("Extra doc")
                .url_pdf("https://zapsign.s3.amazonaws.com/2022/1/pdf/63d19807-cbfa-4b51-8571-215ad0f4eb98/ca42e7be-c932-482c-b70b-92ad7aea04be.pdf")
                .build();

        ExtraDocResponse extraDocResponse = new DocRequests().addExtraDoc(apiToken, docToken, extraDoc);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonDocResponse = ow.writeValueAsString(extraDocResponse);
        System.out.println(jsonDocResponse);
    }
}
