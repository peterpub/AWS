package aws.snsemail;

import java.io.IOException;
import java.util.Properties;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
public class SendMail {
    private AWSCredentials createAwsCredentials() throws IOException {
        Properties properties = new Properties();
        //properties.load(getClass().getClassLoader().getResourceAsStream(            "aws.properties"));
        AWSCredentials credentials = new BasicAWSCredentials(
        		"AKIAIGQMVTBZG7XU4IJQ",
                "wJZUtzlxflxKQC6ns3mYdgvuMEUzZhjYh5udS6gm");
        return credentials;
    }
    private AmazonSimpleEmailService createSimpleEmailService() throws IOException {
        return new AmazonSimpleEmailServiceClient(createAwsCredentials());
    }
    private void sendTestEmail() throws IOException {
        PostMan postMan = new PostMan(createSimpleEmailService());
        postMan.withFrom("z@z.z").withTo("jsfiddle9999@gmail.com")
                .withSubject("Email from AWS!!").withBody(
                    "This is a test email from AWS").send();
    }
    public static void main(String[] args) throws IOException {
        new SendMail().sendTestEmail();
    }
}