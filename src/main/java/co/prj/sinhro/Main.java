package co.prj.sinhro;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ini4j.Ini;

/**
 *
 * @author dejan
 */
public class Main {

    public static void tmpFunction(AWSCredentials argCredentials) {
        AmazonS3Client s3 = new AmazonS3Client(argCredentials);

        // Test. For example, get object keys for a given bucket.
        //ObjectListing objects = s3.listObjects("bmllcustomers/megabank/" + iamUser.getUserName());
        // ObjectListing objects = s3.listObjects("bmllcustomers/megabank");
        List<Bucket> bucketList = s3.listBuckets();
        System.out.println("No. of Objects = " + bucketList.size());

        System.out.println(s3.getS3AccountOwner().toString());
    }

    /**
     * AWS session starts with a call to this function.
     *
     * @return Credentials object containing session credentials that we are going to use in the application.
     */
    public static AWSCredentials awsLogin(BasicAWSCredentials userCredentials, String argRegion) {
        AWSCredentials ret = null;

        try {
            /*
             * We are going to use the .aws/credentials file.
             * profile name: default
             */
            // ProfileCredentialsProvider cp = new ProfileCredentialsProvider("default");
            // The SDK in Maven repo can't read my credentials because I am using advanced features... :(

            AWSSecurityTokenServiceClient stsClient = new AWSSecurityTokenServiceClient(userCredentials);

            // Make a request to create a session token for us.
            GetSessionTokenRequest getSessionTokenRequest = new GetSessionTokenRequest();
            /* If we want to use MFA:
            GetSessionTokenRequest getSessionTokenRequest = new GetSessionTokenRequest()
                    .withSerialNumber(iamUser.getMfaARN())
                    //.withSerialNumber("GAKT0002405F") if we use hardware key
                    .withTokenCode(iamUser.getMfaCode());
            */

            GetSessionTokenResult sessionTokenResult = stsClient.getSessionToken(getSessionTokenRequest);

            Credentials sessionCredentials = (Credentials) sessionTokenResult.getCredentials();
            System.out.println("Session Credentials: " + sessionCredentials.toString());


            // Package the session credentials as a BasicSessionCredentials
            // object for an S3 client object to use.
            BasicSessionCredentials basicSessionCredentials =
             new BasicSessionCredentials(sessionCredentials.getAccessKeyId(),
        		                         sessionCredentials.getSecretAccessKey(),
        		                         sessionCredentials.getSessionToken());

            ret = basicSessionCredentials;
        } catch (Exception ex) {
            System.out.println(ex.getClass().getCanonicalName());
            System.out.println("-----");
            ex.printStackTrace();
        }

        return ret;
    } // awsLogin() method

    public static void main(String[] args) {
        Path path1 = Paths.get("./sinhro.conf");
        Path path2 = Paths.get("~/.config/sinhro.conf".replaceFirst("^~", System.getProperty("user.home")));
        Path configPath = null;

        if (Files.exists(path1)) {
          configPath = path1;
        } else {
            if (Files.exists(path2)) {
              configPath = path2;
            } else {
                System.out.println("Config file not found! (./sinhro.conf or ~/.config/sinhro.conf)");
                System.exit(1);
            }
        }

        Ini ini;
        BasicAWSCredentials bac = new BasicAWSCredentials("dummy", "cred");
        String region = "us-east-1";
        try {
            ini = new Ini(configPath.toFile());
            String keyID = ini.get("default", "aws_access_key_id");
            String accessKey = ini.get("default", "aws_secret_access_key");
            region = ini.get("default", "region");
            bac = new BasicAWSCredentials(keyID, accessKey);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        AWSCredentials cred = awsLogin(bac, region);
        tmpFunction(cred);
    }

}
