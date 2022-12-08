package exemplos;

import body.doc.DocResponse;
import body.doc.DocsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import docs.DocRequests;

import java.io.IOException;

public class DetailDoc {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        String docToken = "8245d99d-e838-4e82-b6f5-387a77435756";
        DocResponse docResponse = new DocRequests().detailDoc(apiToken, docToken);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonDocResponse = ow.writeValueAsString(docResponse);
        System.out.println(jsonDocResponse);
    }
}
