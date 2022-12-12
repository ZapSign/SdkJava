package tests.docs;


import body.doc.DeParaTemplate;
import body.doc.DocFromTemplate;
import response.DocResponse;
import docs.DocRequests;
import services.JsonConverter;

import java.util.ArrayList;

public class CreateDocFromTemplate {
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
                .signer_name("My Signer for template")
                .template_id("75a3a92b-36d5-451f-95cd-5af9a927a392")
                .data(deParaTemplates)
                .build();

        try {
            DocResponse docResponse = new DocRequests(apiToken).createDocFromTemplate(docFromTemplate);
            String jsonDocResponse = new JsonConverter().docResponseToJson(docResponse);
            System.out.println(jsonDocResponse);
        }
        catch(Exception exceptionError) {
            System.out.println(exceptionError.getMessage());
        }
    }
}
