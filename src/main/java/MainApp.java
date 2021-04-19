/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rupesh
 */
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContext;
import javax.naming.NamingException;


public class MainApp {

  //  public static Logger LOGGER = Logger.getLogger(MainApp.class);

    public static void main(String args[]) {
        String ldapUri = System.getProperty("ldapUrl", "ldap://localhost:389");
        String password = System.getProperty("password", "admin");
        String prefix = System.getProperty("prefix", "cn=");
        String username = System.getProperty("userName", "admin");
        String suffix = System.getProperty("suffix", ",dc=student");
        String testUserName = prefix + username + suffix;
        DirContext ctx = null;
        System.out.println("you can provide custom values as -DldapUrl=ldap://localhost:389 -Dpassword=admin -Dprefix=CN= -DuserName=admin -Dsuffix=,DC=student");
        System.out.println("going to use ldapUrl=" + ldapUri + " prefix=" + prefix + " username=" + username + " suffix=" + suffix + " password=" + password);

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUri);
        env.put(Context.SECURITY_PRINCIPAL, testUserName);
        env.put(Context.SECURITY_CREDENTIALS, password);
        try {
            ctx = new InitialDirContext(env);
            System.out.println(" dirContext created successfully--" + ctx);
            System.out.println(" logged in successfully");

            //ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if (ctx != null) {
                System.out.println(" closing context in finally block " + ctx);
            }
        }

    }
}
