package failedTests.createDocFromTemplate;


import body.doc.DeParaTemplate;
import response.DocAsyncResponse;
import body.doc.DocFromTemplate;
import docs.DocRequests;
import services.JsonConverter;

import java.util.ArrayList;

public class CreateDocFromTemplateAsyncWithWrongId {
    public static void main(String[] args) throws Exception {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";

        DeParaTemplate deParaTemplateName = DeParaTemplate.deParaTemplateBuilder()
                .de("{{NOME COMPLETO}}")
                .para("Full Name")
                .build();

        DeParaTemplate deParaTemplateCpf= DeParaTemplate.deParaTemplateBuilder()
                .de("{{NÚMERO DO CPF}}")
                .para("Social Security Number")
                .build();

        DeParaTemplate deParaTemplateEnd = DeParaTemplate.deParaTemplateBuilder()
                .de("{{ENDEREÇO COMPLETO}}")
                .para("Full address")
                .build();

        ArrayList<DeParaTemplate> deParaTemplates = new ArrayList<>();
        deParaTemplates.add(deParaTemplateName);
        deParaTemplates.add(deParaTemplateCpf);
        deParaTemplates.add(deParaTemplateEnd);

        DocFromTemplate docFromTemplate = DocFromTemplate.docFromTemplateBuilder()
                .sandbox(false)
                .brand_primary_color("#000000")
                .lang("pt-br")
                .signer_name("My Signer for template async")
//              wrong template_id
                .template_id("75a3a92b-36d5-451f-test")
                .data(deParaTemplates)
                .build();

        try {
            DocAsyncResponse docAsyncResponse = new DocRequests().createDocFromTemplateAsync(apiToken, docFromTemplate);
            String jsonDocResponse = new JsonConverter().docAsyncResponseToJson(docAsyncResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
